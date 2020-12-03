import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;
public class rotation extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Rectangle r=new Rectangle(100,200,300,100);
		r.setStrokeWidth(5);
		r.setStroke(Color.RED);
		Rotate rotate=new Rotate();
		rotate.setAngle(40);
		rotate.setPivotX(100);
		rotate.setPivotY(100);
		r.getTransforms().addAll(rotate);
		Group root=new Group(r);
		Scene scene=new Scene(root,600,500);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] srg) {
		launch(srg);
	}

}
