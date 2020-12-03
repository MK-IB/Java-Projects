package application;

import java.io.IOException;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SampleController{
	@FXML HBox rootPane;
	@FXML PasswordField passwordField;
	@FXML Button goButton;
	@FXML Button btn;
	@FXML ImageView gallery_ion;
	@FXML private Label label;
	@FXML ImageView indicator;
	@FXML Label passErrMsg;
	public String[] statusInfo;
	//declaring the password STRING
	String password;
	public SampleController(){
		statusInfo=new String[5];
		statusInfo[0]="Getting system ready for you...";
		statusInfo[1]="Checking booting info...";
		statusInfo[2]="Preparing batch files...";
		statusInfo[3]="Loadinf memory...";
		statusInfo[4]="Checking necesaary files..."; 
		//GET AND SET PASSWORD TO VAR
	}
	 @FXML
	    public void initialize() {
	        System.out.println("Controller Iintialized..");
	      //  loadingText.setVisible(false);
	    }

	public void makeFadeOut() {
		password=passwordField.getText();
		FadeTransition ft=new FadeTransition(Duration.millis(1000));
		if(password.equals("java")) {
		ft.setNode(rootPane);
		ft.setFromValue(1);
		ft.setToValue(0.5);
		ft.setOnFinished((ActionEvent)->{
			try {
			loadHomeScreen();}
			catch(Exception r) {}
		});
		}
		else 
			if(password=="") {passErrMsg.setText("Please enter password");}
		else {passErrMsg.setText("Incorrect password");}
		ft.play();
	}
	private void loadHomeScreen() {
		
	}
	
}
