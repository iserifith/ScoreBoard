package scoreBoard2;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String[] args) {
		
		Clock c = new Clock();
		ScoreBoard s = new ScoreBoard();
		JFrame jf = new JFrame();
		jf.setLayout(new FlowLayout());
		
		jf.add(c);
		jf.add(s);
		jf.setTitle("Score Board");
		jf.setSize(900,900);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.black);
		
		
		jf.setVisible(true);
		
		
	}
	
}