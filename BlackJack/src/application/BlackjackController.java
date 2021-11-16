package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BlackjackController {
	
	DeckOfCards deck = new DeckOfCards();
	
	Player player = new Player(500, new Hand(deck));
	
	Player dealer = new Player(500, new Hand(deck));
	
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
	
	public void initialize() {	
		try {
			playerCard1.setText(player.getHand()[0].toString());
			playerCard2.setText(player.getHand()[1].toString());
			
			dealerCard1.setText(dealer.getHand()[0].toString());
			dealerCard2.setText(dealer.getHand()[1].toString());
			
			playerTotal.setText(Integer.toString(player.getHandValue()));
			dealerTotal.setText(Integer.toString(dealer.getHandValue()));
		} catch (Exception e) {
			e.printStackTrace();
		}
			
//		while (continueGame) {
//			if (playerStand == false) {
//				
//			}
//			
//		}
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
		Platform.exit();
	}
	
	public void dealButtonPressed(ActionEvent e) {
		startGame = true;
	}
	
	public void hitButtonPressed(ActionEvent e) {
		try {
			/*
			 * We use var i and this while loop to determine where the
			 * next 'null' is in the player's hand
			 */
			int i = 0;
			while (player.getHand()[i] != null) {
				i++;
				if (i == 5) {
					return;
				}
			}
			
			player.getHandClass().Draw(deck);
			switch(i) {
				case 2:
					playerCard3.setText(player.getHand()[2].toString());
					break;
				case 3:
					playerCard4.setText(player.getHand()[3].toString());
					break;
				case 4:
					playerCard5.setText(player.getHand()[4].toString());
					break;
				default:
					break;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void standButtonPressed(ActionEvent e) {
		playerStand = true;
	}
	
	public void doubleButtonPressed(ActionEvent e) {
		
	}
	
}
