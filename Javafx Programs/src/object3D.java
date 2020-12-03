import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.stage.*;

public class object3D extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Box box=new Box();
		box.setWidth(150);;
		box.setHeight(120);
		box.setDepth(30);
		Translate tr=new Translate();
		tr.setX(400);tr.setY(150);tr.setZ(25);
		Rotate rx=new Rotate(0,0,0,0, Rotate.X_AXIS);
		Rotate ry=new Rotate(0,0,0,0, Rotate.Y_AXIS);
		Rotate rz=new Rotate(0,0,0,0, Rotate.Z_AXIS);
		rx.setAngle(30);
		ry.setAngle(50);
		rz.setAngle(30);
		box.getTransforms().addAll(tr,rx,ry,rz);
		Group g=new Group(box);
		Scene sc=new Scene(g,600,500);
		stage.setScene(sc);
		stage.show();
	}

}
