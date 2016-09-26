package scoreBoard2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;


import java.awt.event.*;
import java.util.Calendar;


import java.lang.Exception;


public class ScoreBoard extends JPanel {
	
	JButton addPeriod;
	JButton hAdd;
	JButton aAdd;
	JButton undo;
	JTextField hScores, aScores, showPeriod;
	JLabel home, away, period, space;
	
	
	
	
	GridBagConstraints gbc = new GridBagConstraints();
	public static final String RES_PATH = "src/font";
	public static final String FILENAME = "src/font/digital-7.ttf"; //file name must be in relative to the source code. In our case, our font is inside "font" folder
	Font font = null;
	Font digitalFont = null;
	
	
	
	@SuppressWarnings("static-access")
	public ScoreBoard() {

		// Add try-and-catch clause for exception. See https://docs.oracle.com/javase/tutorial/essential/exceptions/
		try {		
			font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			digitalFont = new Font("digital-7", Font.PLAIN, 50); // font name must be the same as filename (without extension). Also changee the size to 150
		} catch (Exception e){
			e.printStackTrace();
		}



		setBackground(Color.RED);
		
		
		setLayout(new GridBagLayout());
		
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		
		//button
		addPeriod = new JButton("Update Period");
		gbc.gridx = 3;
		gbc.gridy = 6;
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
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(undo , gbc);
		
//		//text fields
		
		hScores = new JTextField("00");
		hScores.setPreferredSize( new Dimension( 50, 50 ) ); //resize texfield
		hScores.setFocusable(false);
		hScores.setForeground(Color.YELLOW);
		hScores.setBackground(Color.BLACK);
		hScores.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(hScores , gbc);
		
		
		
		aScores = new JTextField("00");
		aScores.setPreferredSize( new Dimension( 50, 50 ) );
		aScores.setFocusable(false);
		aScores.setFont(font);
		aScores.setForeground(Color.YELLOW);
		aScores.setBackground(Color.BLACK);
		aScores.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(aScores , gbc);
		
		showPeriod = new JTextField("00");
		showPeriod.setPreferredSize( new Dimension( 50, 50 ) );
		showPeriod.setFocusable(false);
		showPeriod.setFont(digitalFont);
		showPeriod.setForeground(Color.GREEN);
		showPeriod.setBackground(Color.BLACK);
		showPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(showPeriod , gbc);
		
//		//Labels
		home= new JLabel("Home");
		home.setForeground(Color.WHITE);
		home.setFont (home.getFont ().deriveFont (20.0f));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(home , gbc);
		
		away = new JLabel("Away");
		away.setForeground(Color.WHITE);
		away.setFont (away.getFont ().deriveFont (20.0f));
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);
		add(away , gbc);

		period = new JLabel("Period");
		period.setForeground(Color.WHITE);
		period.setFont (period.getFont ().deriveFont (20.0f));
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0,0,0,0);	
		add(period , gbc);
		
		

		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,50);
		    hScores.setFont(digitalFont);
		    aScores.setFont(digitalFont);
		    showPeriod.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
		
		
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
		
		
		
		
		
		
		
	}

	
	
}

