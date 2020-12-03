import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class rotateAnim extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Rectangle rect=new Rectangle(300,200,200,200);
		RotateTransition rt=new RotateTransition();
		rt.setDuration(Duration.millis(1000));
		rt.setNode(rect);
		rt.setByAngle(360);
		rt.setCycleCount(5);
		rt.setAutoReverse(false);
		rt.play();
		Group root=new Group(rect);
		Scene sc=new Scene(root,600,500);
		stage.setScene(sc);
		stage.show();
		
}
}