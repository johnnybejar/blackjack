package application;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	
	private boolean startGame = false;
    
    private boolean continueGame = true;
    
    private boolean playerStand = false;

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
	
	public void findWinner() {
		if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("Player wins!");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("Dealer wins...");
		} else {
			System.out.println("Draw!");
		}
	}
	
	public void endGameButtonPressed(ActionEvent e) {
		// Ends the game and closes the window
		Platform.exit();
	}
	
	//initializes a new deck, shuffles it, then deals to a player and dealer,
	//then displays cards and total value
	public void dealButtonPressed(ActionEvent e) {
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
			
			dealerCard1.setText(dealer.getHand()[0].toString());
			dealerCard2.setText(dealer.getHand()[1].toString());
			
			playerTotal.setText(Integer.toString(player.getHandValue()));
			dealerTotal.setText(Integer.toString(dealer.getHandValue()));
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		dealButton.setDisable(true);
		// addBet.setDisable(true);
		// minusBet.setDisable(true);
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
		playerStand = true;
		hitButton.setDisable(true);
		standButton.setDisable(true);
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
		
		
	}
	
	public void doubleButtonPressed(ActionEvent e) {
		int currentBet = player.getBet();
    	player.setBet(currentBet*2);
    	
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
