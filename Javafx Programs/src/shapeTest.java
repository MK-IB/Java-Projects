import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class shapeTest extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Circle c=new Circle(100,200,100);
		c.setFill(Color.GREENYELLOW);
		//c.setFill(Color.TRANSPARENT);
		c.setStroke(Color.BURLYWOOD);
		c.setStrokeLineCap(null);
		c.setStrokeWidth(5);
		Group root=new Group(c);
		Scene sc=new Scene(root,700,500);
		arg0.setScene(sc);
		arg0.show();
	}

}
