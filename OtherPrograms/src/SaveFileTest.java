import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;

//import com.sun.java.util.jar.pack.Package.File;

public class SaveFileTest extends JFrame implements ActionListener{
	private static JTextArea ta;
	private static JButton btn;
	JFileChooser fc;
	public SaveFileTest() {
		btn=new JButton("Save");
		ta=new JTextArea(20, 10);
		btn.addActionListener(this);
		fc=new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int result=fc.showSaveDialog(this);
		File file=fc.getSelectedFile();
		BufferedWriter writer=null;
		if(result==JFileChooser.APPROVE_OPTION) {
			try {
				writer=new BufferedWriter(new FileWriter(file.getAbsolutePath()+".txt"));
				writer.write(ta.getText().toString());
				writer.close();
				JOptionPane.showMessageDialog(this, "File was saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(IOException e) {
				JOptionPane.showMessageDialog(this, "File was not saved!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public static void main(String k[]) {
		JFrame f=new SaveFileTest();
		f.setSize(600, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(ta, BorderLayout.NORTH);
		f.add(btn, BorderLayout.SOUTH);
		f.setVisible(true);
		
		
	}

}
