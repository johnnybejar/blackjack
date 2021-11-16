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
	
	DeckOfCards deck = new DeckOfCards();
	
	Player player = new Player(500, new Hand(deck));
	
	Player dealer = new Player(500, new Hand(deck));
    
    private boolean continueGame = true;

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
	
	@FXML
	Label[] playerHand = {playerCard1, playerCard2, playerCard3, playerCard4, playerCard5};
	
	@FXML
	Label[] dealerHand = {dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5};
	
	public void initialize() {
		System.out.println(player.getHand());
		System.out.println(player.getHandValue());
		
		int i = 0;
		try {
			for (Label cardLabel : playerHand) {
				cardLabel.setText(player.getHand().getHand()[i].toString());
				i++;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		playerCard1.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
//				if (player.getHandValue() == 0) {
//					playerCard1.setVisible(false);
//					return;
//				}
				playerCard1.setVisible(true);
				playerCard1.setText(player.getHand().getHand()[0].toString());
			}
		});
		
//		while (continueGame) {
//			
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
	
	public void dealButtonPressed() {
		
	}
	
	public void hitButtonPressed() {
		
	}
	
	public void standButtonPressed() {
		
	}
	
	public void doubleButtonPressed() {
		
	}
	
}
