import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class FileDemo extends JFrame implements ActionListener{
	JFileChooser fc;
	JMenuItem open;
	JMenu file;

	JMenuBar menubar;
	//JButton btn;
	JTextArea ta;
	public FileDemo() {
		open=new JMenuItem("Open");
		file=new JMenu("File");
		file.add(open);
		menubar=new JMenuBar();
		menubar.setBounds(0, 0, 80, 20);
		menubar.add(file);
		add(menubar);
	//	setLayout(new LayoutManager(BorderLayout));
		ta=new JTextArea(800, 800);
		open.addActionListener(this);
		
		
		setSize(700, 500);
		setTitle("FILE CHOOSER");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()== open) {
		 fc=new JFileChooser();
		 int i=fc.showOpenDialog(this);
		 if(i==JFileChooser.APPROVE_OPTION) {
			 File file=fc.getSelectedFile();
			 String filepath=file.getAbsolutePath();
			 ta.setText(filepath);
		 }
	}
	}
	
	public static void main(String arg[]) {
		FileDemo d=new FileDemo();
		d.setVisible(true);
	}
}
