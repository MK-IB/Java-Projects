import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawAnimTest extends JPanel{
	private Image apple;
	public DrawAnimTest() {
	setBackground(Color.black);
//	loadImage();
		
	}
	public void loadImage() {
	
	}
	
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	drawImage(g);
}
public void drawImage(Graphics g) {
	//Graphics2D g2d=(Graphics2D)g;
	ImageIcon ii=new ImageIcon("src\\fb12.jpg");
	//apple=ii.getImage();
	//g2d.drawImage(apple, 400, 200, null);
	ii.paintIcon(this, g, 50, 50);
	int x=ii.getIconHeight();
	
	Font font=new Font("Jokerman", Font.BOLD, 16);
	g.setColor(Color.WHITE);
	g.setFont(font);
	g.drawOval(100, 100, 30, 30);
	g.drawString("NAMASHKAR" , 100, 100);
	g.drawString(Integer.toString(x), 20, 30);
}
}