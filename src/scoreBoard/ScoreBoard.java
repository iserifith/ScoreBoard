package scoreBoard;

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



public class ScoreBoard extends JFrame {
	
	/* declare variables and initialize them to something or "null" */
//	private final JPanel panelPeriod = null;
//	private final JPanel panelHome = null;  
//	private final JPanel panelAway = null;  

	
	JPanel panelPeriod, panelHome, panelAway;
	JButton addPeriod, hAdd, aAdd, undo;
	JTextField hScores, aScores, showPeriod;
	JLabel home, away, period;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public ScoreBoard() {
		
		
		/* TASK : change to GridBaglayout manager. Check this out : https://www.tutorialspoint.com/swing/swing_gridbaglayout.htm 
		Example is at the bottom of the page */
		
		// create panels. Note : use "camel case" for variable names
		JPanel panelPeriod = new JPanel();
		panelPeriod.setLayout(new GridBagLayout());
//		gbc.gridx = 0;
//		gbc.gridy = 0;
		
		JPanel panelHome = new JPanel();
		panelHome.setLayout(new GridBagLayout());
//		gbc.gridx = 1;
//		gbc.gridy = 1;
		
		JPanel panelAway = new JPanel();
		panelAway.setLayout(new GridBagLayout());
//		gbc.gridx = 2;
//		gbc.gridy = 2;
		/* create elements for each panel */
		// for panelPeriod
		period = new JLabel("Period");
		gbc.gridx = 0;
		gbc.gridy = 0;
		showPeriod = new JTextField("1");
		gbc.gridx = 1;
		gbc.gridy = 1;
		addPeriod = new JButton("Add");
		gbc.gridx = 2;
		gbc.gridy = 2;
		undo = new JButton("Undo");
		gbc.gridx = 3;
		gbc.gridy = 3;

		// for panelHome
		home = new JLabel("Home");
		hScores = new JTextField("00");
		hAdd = new JButton("+");

		// for panelAway
		away = new JLabel("Away");
		aScores = new JTextField("00");
		aAdd = new JButton("+");

		/* Add elements to respective panels */
		// for panelPeriod
		panelPeriod.add(period, gbc);
		panelPeriod.add(showPeriod, gbc);
		panelPeriod.add(addPeriod, gbc);
		panelPeriod.add(undo, gbc);
		
		// for panelHome
		panelHome.add(home, gbc);
		panelHome.add(hScores, gbc);
		panelHome.add(hAdd, gbc);
		
		// for panelAway
		panelAway.add(away, gbc);
		panelAway.add(aScores, gbc);
		panelAway.add(aAdd, gbc);
		
		

		// Instead, add the panels directly into this class. This class is already a frame
		setResizable(true);
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(panelPeriod);
		add(panelHome);
		add(panelAway);	

		// size the frame and display it
//		pack();
		setVisible(true);
	}
		
	public static void main(String[] args) {
        /* variable name MUST NOT be the same as class name. Use camel case for variable name.
        This is wrong > ScoreBoard ScoreBoard = new ScoreBoard(); */
        ScoreBoard scoreBoard = new ScoreBoard(); 

    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
}


