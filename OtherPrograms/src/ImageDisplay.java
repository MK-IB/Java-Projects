import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;

import com.sun.xml.internal.ws.api.server.Container;

public class ImageDisplay extends JApplet implements ActionListener{
	
	private ImageIcon img=new ImageIcon("apple.png");
	private JButton zoomBtn=new JButton("Zoom");
	private int height, width;
	java.awt.Container cont=getContentPane();
	public void init() {
		cont.setLayout(new FlowLayout());
		setSize(500, 500);
		zoomBtn.addActionListener(this);
		cont.add(zoomBtn);
		width=img.getIconWidth();
		height=img.getIconHeight();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		width=width*2;
		height=height*2;
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img.getImage(), 0, 0, width/2, height/2, this);
		
	}

}
