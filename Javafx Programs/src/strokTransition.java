import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class strokTransition extends Application{
	public static void main(String[] arg) {
		launch(arg);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		Circle c=new Circle(300,300,100);
		c.setStrokeWidth(20);
		StrokeTransition st=new StrokeTransition();
		st.setDuration(Duration.millis(1000));
		st.setShape(c);
		st.setFromValue(Color.BLUE);
		st.setToValue(Color.YELLOW);
		st.setCycleCount(100);
		st.setAutoReverse(true);
		st.play();
		Group root=new Group(c);
		Scene scene=new Scene(root, 500,500);
		arg0.setScene(scene);
		arg0.setTitle("Effects");
		arg0.show();
	}

}
