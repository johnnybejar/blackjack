package application;

/*
 * Names: John Bejar, Daisy Fanjoy, Thomas Smith, Ben Williams
 * Class: CSC 331-003
 * Professor: Professor White
 * 
 * Project Description: Blackjack
 * - Blackjack game created using Java and JavaFX
 * - Allows the player to play continuously until
 * 	 they run out of money or they give up
 * - Dealer must draw to 16 and stand on 17
 * - Uses the 5 card rule meaning that if a player
 *   has 5 cards in their hand and does not bust,
 *   it's considered a win
 * 
 */
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Blackjack extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Blackjack.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Blackjack");
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
								
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
