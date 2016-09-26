package scoreBoard2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame {

	
	public static void main(String[] args) {
		GridBagConstraints gbc = new GridBagConstraints();
		JFrame jf = new JFrame();
		
		ScoreBoard sc = new ScoreBoard();
		GameClock clock = new GameClock();
		ShotClock shot = new ShotClock();
		
		jf.setLayout(new GridBagLayout());
		jf.add(clock);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		jf.add(shot);
		gbc.gridx = 0;
		gbc.gridy = 1;
	
		jf.setTitle("Score Board");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.GRAY);
		jf.setSize(1200, 1200);
		jf.setVisible(true);

	}

}
