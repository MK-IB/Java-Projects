import java.awt.EventQueue;

import javax.swing.JFrame;

public class frame extends JFrame{
	

	    public frame() {

	        initUI();
	    }
	    
	    private void initUI() {
	        
	        add(new A());
	        
	        setTitle("Basic shapes");
	        setSize(350, 250);
	        setLocationRelativeTo(null);        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {

	       
	                frame ex = new frame();
	                ex.setVisible(true);
	          
	    }
	}