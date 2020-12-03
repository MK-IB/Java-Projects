import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CustomProgressBarMain extends JFrame{
	public static void main(String a[]) {
		CustomProgressBarMain f=new CustomProgressBarMain();
		f.add(new CustomProgressBar());
		f.setSize(700, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}

}
