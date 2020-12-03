package application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class dateTimeController implements Initializable{
	@FXML Label timeText;
	@FXML Label dateText;
	SimpleDateFormat time;
	@FXML VBox dateTimeScreen;
	double maxY;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		maxY=dim.getHeight();
		Date date=new Date();
		DateFormat time=new SimpleDateFormat("hh:mm");
		DateFormat day=new SimpleDateFormat("E");
		DateFormat d=new SimpleDateFormat("dd MMMM");
		timeText.setText(time.format(date));
		dateText.setText(day.format(date)+", "+d.format(date));
		
	}
	public void loadLoginScreen() {
		TranslateTransition tt=new TranslateTransition(Duration.millis(700));
		tt.setNode(dateTimeScreen);
		tt.setFromY(0);
		tt.setToY(maxY);
		tt.play();
		tt.setOnFinished((ActionEvent)->{
			Parent p = null;
			try {
			p=FXMLLoader.load(getClass().getResource("log.fxml"));
			}catch(Exception e) {}
			Stage stage=(Stage)dateTimeScreen.getScene().getWindow();
			Scene sc=new Scene(p);
			sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(sc);
			stage.setFullScreen(true);
			stage.show();
		});
		
	}
}
