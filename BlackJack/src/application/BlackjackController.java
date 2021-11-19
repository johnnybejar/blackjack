package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BlackjackController {
	
	private Player player = new Player(1000);
	
	private Dealer dealer = new Dealer();
	
	private BlackjackGame game;
	
	private int playerBet = 50;

	@FXML
	Button dealButton;
	
	@FXML
	Button hitButton;
	
	@FXML
	Button standButton;
	
	@FXML
	Button doubleButton;

	@FXML
	TextField dealerTotal;

	@FXML
	TextField playerTotal;

	@FXML
	TextField bankTotal;
	
	@FXML
	Button addBet;
	
	@FXML
	Button minusBet;
	
	@FXML
	TextField betTotal;

	@FXML
	Button endGameButton;
	
	@FXML
	Label playerCard1;
	
	@FXML
	Label playerCard2;
	
	@FXML
	Label playerCard3;
	
	@FXML
	Label playerCard4;
	
	@FXML
	Label playerCard5;
	
	@FXML
	Label dealerCard1;
	
	@FXML
	Label dealerCard2;
	
	@FXML
	Label dealerCard3;
	
	@FXML
	Label dealerCard4;
	
	@FXML
	Label dealerCard5;
	
	@FXML
	Label gameOutcome;
	
	public void initialize() {
		//disables all buttons but bet in order to force correct user inputs
		hitButton.setDisable(true);
		standButton.setDisable(true);
		doubleButton.setDisable(true);
		minusBet.setDisable(true);
	}
	public void peekDealer() {
		dealerCard1.setText(dealer.getHand()[0].toString());
		dealerTotal.setText(Integer.toString(dealer.getHandValue()));
	}
	
	public void playerLoses() {
		player.removeCash(playerBet);
		bankTotal.setText(Integer.toString(player.getCash()));
		if (player.getCash() == 0) {
			
			gameOutcome.setText("Game Over");
			hitButton.setDisable(true);
			standButton.setDisable(true);
			doubleButton.setDisable(true);
			minusBet.setDisable(true);
			dealButton.setDisable(true);
			addBet.setDisable(true);
			minusBet.setDisable(true);
			
		}else {
			gameOutcome.setText("Dealer Wins!");
			resetDefaults();
		}
	}
	
	public void playerWins() {
		player.addCash(playerBet);
		bankTotal.setText(Integer.toString(player.getCash()));
		gameOutcome.setText("Player Wins!");
		resetDefaults();
	}

	public void resetDefaults() {
		hitButton.setDisable(true);
		standButton.setDisable(true);
		doubleButton.setDisable(true);
		minusBet.setDisable(true);
		dealButton.setDisable(false);
		addBet.setDisable(false);
		minusBet.setDisable(true);
		playerBet = 50;
		betTotal.setText("50");
	}
	
	
	public void findWinner() {
		if (player.getHandValue() > dealer.getHandValue()) {

			playerWins();
			
		} else if (player.getHandValue() < dealer.getHandValue()) {
			
			playerLoses();
			
		} else {
			gameOutcome.setText("Draw...");
			resetDefaults();
		}
	}
	
	public void endGameButtonPressed(ActionEvent e) {
		// Ends the game and closes the window
		Platform.exit();
	}
	
	//first clears all text from previous hand, then initializes a new deck, shuffles it, then deals to a player and dealer,
	//then displays cards and total value
	public void dealButtonPressed(ActionEvent e) {

		playerCard1.setText("");
		playerCard2.setText("");
		playerCard3.setText("");
		playerCard4.setText("");
		playerCard5.setText("");
		
		dealerCard1.setText("");
		dealerCard2.setText("");
		dealerCard3.setText("");
		dealerCard4.setText("");
		dealerCard5.setText("");

		playerTotal.setText("0");
		dealerTotal.setText("0");
		
		gameOutcome.setText("");
		
		DeckOfCards deck = new DeckOfCards();
		BlackjackGame game = new BlackjackGame(deck, player, dealer);
		this.game = game;
		game.shuffle();
		game.deal();
		try {
			/*
			Initializes the GUI with the initial drawn cards by the player and the dealer,
			and updates the score
			*/
			playerCard1.setText(player.getHand()[0].toString());
			playerCard2.setText(player.getHand()[1].toString());
			
			dealerCard1.setText("?????????????");
			dealerCard2.setText(dealer.getHand()[1].toString());
			
			playerTotal.setText(Integer.toString(player.getHandValue()));
			dealerTotal.setText(Integer.toString(dealer.getHand()[1].getValue()));
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		dealButton.setDisable(true);
		addBet.setDisable(true);
		minusBet.setDisable(true);
		hitButton.setDisable(false);
		standButton.setDisable(false);
		doubleButton.setDisable(false);
	}
	
	public void hitButtonPressed(ActionEvent e) {
		try {
			/*
			 * We use var i and this while loop to determine where the
			 * next empty slot is in the player's hand
			 */
			int i = 0;
			while (player.getHand()[i] != null) {
				i++;
				if (i == 5) {
					return;
				}
			}
			game.playerHit();
			
			switch(i) {
				case 2:
					playerCard3.setText(player.getHand()[2].toString());
					playerTotal.setText(Integer.toString(player.getHandValue()));
					break;
				case 3:
					playerCard4.setText(player.getHand()[3].toString());
					playerTotal.setText(Integer.toString(player.getHandValue()));
					break;
				case 4:
					playerCard5.setText(player.getHand()[4].toString());
					playerTotal.setText(Integer.toString(player.getHandValue()));
					break;
				default:
					break;
			}
			if (!game.checkPlayerBlackjack() && !game.checkPlayerBust() && !game.playerCount5()) {
				return;
			}else {
				hitButton.setDisable(true);
				if (game.checkPlayerBlackjack() || game.playerCount5()) {
					playerWins();
				}
				
				if (game.checkPlayerBust()) {
					playerLoses();	
				}
				
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void standButtonPressed(ActionEvent e) {
		/*
		If this button is pressed, the player cannot make anymore decisions until
		the final result of the game is decided
		*/
		hitButton.setDisable(true);
		standButton.setDisable(true);
		peekDealer();
		game.dealerPlays();
		int j = 0;
		while (dealer.getHand()[j] != null) {
			j++;
			if (j == 5) {
				return;
			}
			switch(j-1) {
			case 2:
				dealerCard3.setText(dealer.getHand()[2].toString());
				dealerTotal.setText(Integer.toString(dealer.getHandValue()));
				break;
			case 3:
				dealerCard4.setText(dealer.getHand()[3].toString());
				dealerTotal.setText(Integer.toString(dealer.getHandValue()));
				break;
			case 4:
				dealerCard5.setText(dealer.getHand()[4].toString());
				dealerTotal.setText(Integer.toString(dealer.getHandValue()));
				break;
			default:
				break;
			}
		}
		if (game.checkDealerBlackjack() || game.checkDealerBust() || game.dealerCount5()) {
			if (game.checkDealerBlackjack() || game.dealerCount5()) {
				playerLoses();
			}
			
			if (game.checkDealerBust()) {
				playerWins();
			}
		}else findWinner();
		
	}
	
	public void doubleButtonPressed(ActionEvent e) {
    	if (playerBet*2 <= player.getCash()) {
    		playerBet *= 2;
			betTotal.setText(Integer.toString(playerBet));
			doubleButton.setDisable(true);
    	}else doubleButton.setDisable(true);
	}
	
	public void addButtonPressed(ActionEvent e) {
		try {
			if (playerBet != player.getCash()) {
				playerBet += 50;
				betTotal.setText(Integer.toString(playerBet));
				if (playerBet == 100) {
					minusBet.setDisable(false);
				}
			}else addBet.setDisable(true);
			
			
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void minusButtonPressed(ActionEvent e) {
		try {
			playerBet -= 50;
			betTotal.setText(Integer.toString(playerBet));
			if (playerBet == 50) {
				minusBet.setDisable(true);
			}
			if (playerBet == (player.getCash() - 50)) {
				addBet.setDisable(false);
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}
}
