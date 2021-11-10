package application;
	
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
