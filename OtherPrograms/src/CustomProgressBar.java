import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomProgressBar extends JPanel implements ActionListener{
	
	Timer timer;
	int DELAY=20;
	int width=5;
	private final int height=20;
	private Font f1, f2;
	private boolean progress=true;
	
	public CustomProgressBar() {
		timer=new Timer(DELAY, this);
		timer.start();
		setBackground(Color.BLACK);
		 f1=new Font("Halvetica", Font.BOLD, 18);
		 f2=new Font("Typewriter", Font.BOLD, 28);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.yellow);
		
		g.setFont(f1);
		if(progress) {
		g.drawRect(80, 100, 500, 20);
		g.drawString(" "+width/5+"% completed", 250, 60);
		g.fillRect(80, 100, width, height);
		
		Toolkit.getDefaultToolkit().sync();
		}
		
		else {
			accessGranted(g);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		width+=5;
		repaint();
		if(width>=500) {
			progress=false;
			timer.stop();
		}
	}
	public void accessGranted(Graphics g) {
		g.setColor(Color.green);
		g.setFont(f2);
		g.drawRect(150, 200, 400, 100);
		g.drawString("ACCESS GRANTED", 200, 250);
	}
}
