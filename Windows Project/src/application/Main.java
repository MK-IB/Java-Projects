package application;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.javafx.geom.Rectangle;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@FXML ImageView btn;
	@FXML static Button goBtn;
	@Override
	public void start(Stage primaryStage) {
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("E");
	    DateFormat dayFull = new SimpleDateFormat("EEEE");
	    DateFormat time = new SimpleDateFormat("hh:mm a");
	    System.out.println("Current day: " + dateFormat.format(date));
	    System.out.println("Current day: " + dayFull.format(date));
	    System.out.println("Current day: " + time.format(date));
	    //System.out.println(date);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		double maxWidth=dim.getWidth();
		double maxHeight=dim.getHeight();
		try {
			Parent root =FXMLLoader.load(getClass().getResource("windowLogoLoading.fxml"));
			Scene scene = new Scene(root,maxWidth, maxHeight);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
