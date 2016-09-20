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



public class ScoreBoard extends JFrame {
	
	/* declare variables and initialize them to something or "null" */
	private final JPanel panelPeriod = null;
	private final JPanel panelHome = null;  
	private final JPanel panelAway = null;  

	private final JLabel home;
	private final JLabel away;
	private final JLabel period;
	private final JTextField showPeriod;
	private final JButton addPeriod;
	private final JTextField hScores;
	private final JTextField aScores;
	private final JButton hAdd;
	private final JButton aAdd;
	private final JButton undo;
	
	
	public ScoreBoard() {
		
		
		/* TASK : change to GridBaglayout manager. Check this out : https://www.tutorialspoint.com/swing/swing_gridbaglayout.htm 
		Example is at the bottom of the page */
		
		// create panels. Note : use "camel case" for variable names
		JPanel panelPeriod = new JPanel();
		panelPeriod.setLayout(new BorderLayout());
		
		JPanel panelHome = new JPanel();
		panelHome.setLayout(new BorderLayout());

		JPanel panelAway = new JPanel();
		panelAway.setLayout(new BorderLayout());

		/* create elements for each panel */
		// for panelPeriod
		period = new JLabel("Period");
		showPeriod = new JTextField("1");
		addPeriod = new JButton("Add");
		undo = new JButton("Undo");

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
		panelPeriod.add(period, BorderLayout.NORTH);
		panelPeriod.add(showPeriod, BorderLayout.WEST);
		panelPeriod.add(addPeriod, BorderLayout.EAST);
		panelPeriod.add(undo, BorderLayout.SOUTH);
		
		// for panelHome
		panelHome.add(home, BorderLayout.NORTH);
		panelHome.add(hScores, BorderLayout.WEST);
		panelHome.add(hAdd, BorderLayout.EAST);
		
		// for panelAway
		panelAway.add(away, BorderLayout.NORTH);
		panelAway.add(aScores, BorderLayout.WEST);
		panelAway.add(aAdd, BorderLayout.EAST);
		
		/* remove this. This class is ALREADY a JFrame. We DONT add frame onto a frame. This is wrong 
		frame = new JFrame("Score Board");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panelPeriod);
		frame.add(panelHome);
		frame.add(panelAway);
		*/

		// Instead, add the panels directly into this class. This class is already a frame
		setResizable(false);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(panelPeriod, BorderLayout.NORTH);
		add(panelHome, BorderLayout.WEST);
		add(panelAway, BorderLayout.EAST);	

		// size the frame and display it
		pack();
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


