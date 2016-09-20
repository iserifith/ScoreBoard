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
	
	private final JPanel panel; // timer+undo button +period+addperiod
	private final JPanel homePanel; //txtfield+label+addbutton
	private final JPanel awayPanel; //same as above
//	private final JPanel panel;

	private final JFrame frame;
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
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new FlowLayout());

		JPanel awayPanel = new JPanel();
		awayPanel.setLayout(new FlowLayout());
//		panel = new JPanel(new FlowLayout());
//		homePanel = new JPanel(new FlowLayout());
//		awayPanel = new JPanel(new FlowLayout());
		
		frame = new JFrame("Score Board");
		frame.setResizable(false);
		
		//add stopwatch here
		
		home = new JLabel("Home");
		away = new JLabel("Away");
		hScores = new JTextField("");
		aScores = new JTextField("");
		
		period = new JLabel("Period");
		showPeriod = new JTextField("");
		addPeriod = new JButton("");
		
		hAdd = new JButton("+");
		aAdd = new JButton("+");
		undo = new JButton("Undo");
		
		
		
	
	
	
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.add(homePanel);
		frame.add(awayPanel);
		
		panel.add(period);
		panel.add(showPeriod);
		panel.add(addPeriod);
		panel.add(undo);
		// add stopwatch later
		
		homePanel.add(home);
		homePanel.add(hScores);
		homePanel.add(hAdd);
		
		awayPanel.add(away);
		awayPanel.add(aScores);
		awayPanel.add(aAdd);
		
		add(panel);
		add(homePanel);
		add(awayPanel);
		
		
		
		}
		
	public static void main(String[] args) {
        ScoreBoard ScoreBoard = new ScoreBoard();
    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}


