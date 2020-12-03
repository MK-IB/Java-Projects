import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
//IT CREATES THE FRAME AND ADD BOARD JPANEL
public class SnakeMain extends JFrame{
		public SnakeMain() {
			add(new Board());
			setResizable(false);
			pack();
			setTitle("Snake");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		public static void main(String s[]) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					JFrame x=new SnakeMain();
					try {
						x.setIconImage(ImageIO.read(new File("src\\apple.png")));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x.setVisible(true);
				}
			});
		}
}

