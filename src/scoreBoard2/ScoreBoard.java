package scoreBoard2;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class ScoreBoard extends JPanel{
	
	JButton addPeriod, hAdd, aAdd, undo;
	JTextField hScores, aScores, showPeriod;
	JLabel home, away, period;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public ScoreBoard() {
		addPeriod = new JButton("Update Period");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(addPeriod , gbc);
		
		hAdd = new JButton("Home team scores!");
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(hAdd , gbc);
		
		aAdd = new JButton("Away team scores!");
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(aAdd , gbc);
		
		undo = new JButton("Undo");
		gbc.gridx = 3;
		gbc.gridy = 3;
		add(undo , gbc);
	}

	
	
	public static void main(String[] args) {
		ScoreBoard s = new ScoreBoard();
		JFrame jf = new JFrame();
		JPanel ScoreBoard = new JPanel();
		jf.setTitle("Score Board");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}
