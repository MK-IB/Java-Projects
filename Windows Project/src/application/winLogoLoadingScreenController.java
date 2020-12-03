package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class winLogoLoadingScreenController implements Initializable{
	@FXML ImageView loadingCircle;
	@FXML VBox windowLogoLoadingRoot;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadingAnimation();
	}
private void loadingAnimation() {
	RotateTransition rt=new RotateTransition(Duration.millis(2000));
	rt.setNode(loadingCircle);
	rt.setFromAngle(0);
	rt.setToAngle(360);
	rt.setCycleCount(4);
	rt.setOnFinished((ActionEvent)->{
		try {
			Parent login =(VBox)FXMLLoader.load(getClass().getResource("dateTimeWindow.fxml"));
			Stage stage=(Stage)windowLogoLoadingRoot.getScene().getWindow();
			Scene sc=new Scene(login);
			sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(sc);
			stage.setFullScreen(true);
			stage.show();
		}catch(Exception e) {}
	});
	rt.play();
}
}
