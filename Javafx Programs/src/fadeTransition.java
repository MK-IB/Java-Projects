
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class fadeTransition extends Application {

	@Override
	public void start(Stage primaryStage) {
		Circle c=new Circle(200,100,50);
		c.setFill(Color.BLUE);
		FadeTransition ft=new FadeTransition(Duration.millis(2000));
		ft.setNode(c);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		Group g=new Group(c);
		Scene sc=new Scene(g,500,400);
		primaryStage.setScene(sc);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
