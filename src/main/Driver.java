package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class Driver {
	
	
	
	public static void main(String[] args) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		GameClock gameClock = new GameClock();
		ShotClock shotClock = new ShotClock();
		ScoreBoard scoreBoard = new ScoreBoard();
		
		JFrame frameMain = new JFrame();
		frameMain.setLayout(new GridBagLayout());
		
		JLabel lblGC = new JLabel("Game Clock");
		lblGC.setFont(new Font("Serif", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		frameMain.add(lblGC, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		frameMain.add(gameClock, gbc);
		
		JLabel lblSC = new JLabel("Shot Clock           Period");
		lblSC.setFont(new Font("Serif", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 2;
		frameMain.add(lblSC, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		frameMain.add(shotClock, gbc);
		
		JLabel gap = new JLabel("    ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		frameMain.add(gap, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		frameMain.add(scoreBoard, gbc);
		
		frameMain.setTitle("Score Board");
		frameMain.setSize(1200,900);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setBackground(Color.GRAY);
		frameMain.setVisible(true);	
	}
	
}
