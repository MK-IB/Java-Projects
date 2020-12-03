
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class cssTest extends Application {

	@Override
	public void start(Stage stage) {
		Circle c=new Circle(300,100,100);
		Group root=new Group(c);
		Scene sc=new Scene(root,600,500);
		stage.setScene(sc);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
