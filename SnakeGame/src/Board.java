import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
//import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel implements ActionListener{
			private final int B_WIDTH=600;
			private final int B_HEIGHT=500;
			private final int DOT_SIZE=10; //APPLE SIZE & DOT OF THE SNAKE
			private final int ALL_DOTS=3000;
			private final int RAND_POS=29;
			private int DELAY=140; //SPEED OF THE GAME
			//STORE X AND Y COORD OF THE DOT(JOINTS) OF SNAKE
			private final int x[]=new int[ALL_DOTS];
			private final int y[]=new int[ALL_DOTS];
			private int dots;
			private int apple_x;
			private int apple_y;
			private boolean leftDirection=false;
			private boolean rightDirection=true;
			private boolean upDirection=false;
			private boolean downDirection=false;
			private boolean inGame=true;
			
			int level=1;
			private int score=0;
			private Timer timer, timer2;
			private Image ball;
			private Image apple;
			private Image head;
			
			Font f1,f2;
			
	public Board() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.gray));
		loadImages();
		initGame();
		
		f1=new Font("Arial", Font.BOLD, 35);
		f2=new Font("Arial", Font.BOLD, 14);
	}
   public void loadImages() {
	
	/*ImageIcon iid=new ImageIcon("dots.png");
	ball=iid.getImage(); 
	ImageIcon iia=new ImageIcon("src\\apple.png");
	apple=iia.getImage();
	ImageIcon iin=new ImageIcon("head.png");
	head=iin.getImage(); */
}
	public void initGame() {
			dots=3;
			for(int z=0; z<dots; z++) {
				x[z]=50-z*10;
				y[z]=50;
			}
			locateApple();
			timer=new Timer(DELAY, this);
			timer.start();		
	}
	
	//LOCATE APPLE RANDOMLY
	private void locateApple() {
		int r=(int)(Math.random()*RAND_POS);
		apple_x=r*DOT_SIZE;
		r=(int)(Math.random()*RAND_POS);
		apple_y=r*DOT_SIZE;
	}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setFont(f1);
			//g.setColor(Color.LIGHT_GRAY);
			g.drawString(Integer.toString(score)+" L"+Integer.toString(level), 40, 50);
			doDrawing(g);
		}
	private void doDrawing(Graphics g) {
		if(inGame) {
			//APPLE- SETTING COLOR TO RED
			g.setColor(Color.red);
			g.fillOval(apple_x, apple_y, 10, 10);
			for(int z=0; z<dots; z++) {
				
				if(z==0) {
					//HEAD
					g.setColor(Color.yellow);
					g.fillOval(x[z], y[z], 10, 10);
					
				}
				
				else {
					g.setColor(Color.white);
					g.fillOval(x[z], y[z], 10, 10);
					
				}
				if(z==dots-1) {
					g.setColor(Color.green);
					g.fillOval(x[z], y[z], 10, 10);
				}
			}
			Toolkit.getDefaultToolkit().sync();
		}
		else {
			gameOver(g);
		}
	}
	
	private void gameOver(Graphics g) {
		String msg="GAME OVER";
		Font large=new Font("Halvetica", Font.BOLD, 34);
		FontMetrics mtr=getFontMetrics(large);
		g.setColor(Color.red);
		g.setFont(large);
		g.drawString(msg, (B_WIDTH-mtr.stringWidth(msg))/2, B_HEIGHT/2);
	}
	private void checkApple() {//when head collides the apple
		//ScoreBoard s=new ScoreBoard();
		if((x[0]==apple_x) && (y[0]==apple_y)) {
			dots++;
			score+=5;
			locateApple(); //again locates apple randomly
			//new ScoreBoard().getScore(score);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(inGame) {
			checkApple();
		//	new ScoreBoard();
			checkCollision();
			moveJoints();
		}
		
		repaint();
	}
	//when action is performed
	private void moveJoints() {
		//one position upto the chain, follows where 1st dot was present
		for(int z=dots; z>0; z--) {
			//MOVES UP THE CHAIN
			x[z]=x[(z-1)];
			y[z]=y[(z-1)];
		}
		if(x[0]==B_WIDTH-DOT_SIZE) {
			y[0]+=DOT_SIZE;
			rightDirection=false;
		}
		if(x[0]==0) {
			y[0]-=DOT_SIZE;
			leftDirection=false;
		}
		if(y[0]==0) {
			x[0]+=DOT_SIZE;
			upDirection=false;
		}
		if(y[0]==B_HEIGHT-DOT_SIZE) {
			x[0]-=DOT_SIZE;
			downDirection=false;
		}
		if(leftDirection) {
			x[0]=x[0]-DOT_SIZE;
		}
		if(rightDirection) {
			x[0]=x[0]+DOT_SIZE;
		}
		if(upDirection) {
			y[0]-=DOT_SIZE;
		}
		if(downDirection) {
			y[0]+=DOT_SIZE;
		}
	}
	
	private void checkCollision() {
		for(int z=dots; z>0; z--) {
			if((z>4) && (x[0]==x[z]) && (y[0]==y[z])) {
				inGame=false;
			}	
		}
		/*
		if(y[0]>=B_HEIGHT) {// FINISHES IF HITS BOTTOM OF BOARD
			inGame=false;
		}
		if(y[0]<0) {
			inGame=false;
		}
		if(x[0]<0) {
			inGame=false;
		}
		*/
		if(!inGame) {
			timer.stop();
		}
	}
private class TAdapter extends KeyAdapter{
	@Override
	public void keyPressed(KeyEvent e) {
		int kc=e.getKeyCode();
		if((kc==KeyEvent.VK_LEFT) && (!rightDirection)) {
			leftDirection=true;
			upDirection=false;
			downDirection=false;
			
		}
		if((kc==KeyEvent.VK_RIGHT) && (!leftDirection)) {
			rightDirection=true;
			upDirection=false;
			downDirection=false;
			
		}
		if((kc==KeyEvent.VK_UP) && (!downDirection)) {
			upDirection=true;
			rightDirection=false;
			leftDirection=false;
			
		}
		if((kc==KeyEvent.VK_DOWN) && (!upDirection)) {
			downDirection=true;
			rightDirection=false;
			leftDirection=false;
			
		}
	}
		
	}
		

}