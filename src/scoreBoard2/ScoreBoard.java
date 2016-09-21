package scoreBoard2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScoreBoard extends JPanel {
	
	
	
	JButton addPeriod;
	JButton hAdd;
	JButton aAdd;
	JButton undo;
	JTextField hScores, aScores, showPeriod;
	JLabel home, away, period, space;
	

	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public static final String RES_PATH = "font";
	public static final String FILENAME = "digital-7.ttf";
	
	//FONT
	Font font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	ge.registerFont=(new Font("font",Font.BOLD,20));

	
	@SuppressWarnings("static-access")
	public ScoreBoard() {
		setBackground(Color.BLACK);
		setLayout(new GridBagLayout());
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		//button
		addPeriod = new JButton("Update Period");
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);	
		
		add(addPeriod , gbc);
		
		hAdd = new JButton("Home team scores!");
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(hAdd , gbc);
		
		aAdd = new JButton("Away team scores!");
		gbc.gridx = 6;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(aAdd , gbc);
		
		undo = new JButton("Undo");
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(undo , gbc);
		
//		//text fields
		
		hScores = new JTextField("00");
		hScores.setPreferredSize( new Dimension( 50, 50 ) );
		hScores.setFocusable(false);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(hScores , gbc);
		
		aScores = new JTextField("00");
		aScores.setPreferredSize( new Dimension( 50, 50 ) );
		aScores.setFocusable(false);
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(aScores , gbc);
		
		showPeriod = new JTextField("00");
		showPeriod.setPreferredSize( new Dimension( 50, 50 ) );
		showPeriod.setFocusable(false);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(showPeriod , gbc);
		
//		//Labels
		home= new JLabel("Home");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(home , gbc);
		
		away = new JLabel("Away");
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(away , gbc);

		period = new JLabel("Period");
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);	
		add(period , gbc);
		
		
		
		hAdd.addActionListener(new ActionListener(){ 
			int total = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				String addScores = hScores.getText();
				Integer addInt = Integer.parseInt(addScores);
				int i = 1;
				int score = 0;
				score = 1;
				
				String scoreInString = addInt.toString(score);
				hScores.setText(scoreInString);
				
				
				 total += i;
				 hScores.setText(""+total);
				 	
			}

		});
		
		aAdd.addActionListener(new ActionListener(){ 
			int total = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				String addScores = aScores.getText();
				Integer addInt = Integer.parseInt(addScores);
				int i = 1;
				int score = 0;
				score = 1;
				
				String scoreInString = addInt.toString(score);
				aScores.setText(scoreInString);
				
				
				 total += i;
				 aScores.setText(""+total);
				 	
			}
	
		});
		
		addPeriod.addActionListener(new ActionListener(){ 
			int total = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				String addScores = showPeriod.getText();
				Integer addInt = Integer.parseInt(addScores);
				int i = 1;
				int score = 0;
				score = 1;
				
				String scoreInString = addInt.toString(score);
				showPeriod.setText(scoreInString);
				
				
				 total += i;
				 showPeriod.setText(""+total);
				 	
			}
	
		});
		
		
		
		
		
		/*public void clear() {
	        try {
	            display.setText("");
	            for(int i = 0; i < 4; i++)
	                function[i] = false;
	            for(int i = 0; i < 2; i++)
	                temporary[i] = 0;
	        } catch(NullPointerException e) {  
	        }
	    }*/
		
	}

	
	public static void main(String[] args) {
		ScoreBoard s = new ScoreBoard();
		JFrame jf = new JFrame();
		jf.add(s);
		jf.setTitle("Score Board");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.black);
		jf.setVisible(true);
		}
}

