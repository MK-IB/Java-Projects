import com.sun.javafx.geom.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class translate extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Circle c=new Circle(100,200,100);
		c.setFill(Color.BLUEVIOLET);
		c.setStrokeWidth(10);
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(Duration.millis(1000));
		tt.setCycleCount(4);
		tt.setNode(c);
		//transition along x axis
		tt.setByX(300);
		//tt.setAutoReverse(false);
		tt.play();
		Group root=new Group(c);
		Scene sc=new Scene(root,600,500);
		stage.setScene(sc);
		stage.show();
		
	}
	public static void main(String[] ar) {
		launch(ar);
	}

}
