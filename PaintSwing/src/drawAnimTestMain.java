import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class drawAnimTestMain extends JFrame{
	
	public drawAnimTestMain() {
		add(new DrawAnimTest());
		setSize(550, 400);
		//setBackground(Color.green);
		setResizable(false);
		setTitle("IMAGE DISPLAY DEMO");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {

     
            	drawAnimTestMain ex = new drawAnimTestMain();
                ex.setVisible(true);
	}
}
