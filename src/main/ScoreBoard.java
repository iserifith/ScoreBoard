package main;


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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ScoreBoard extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addPeriod;
	JButton hAdd;
	JButton aAdd;
	JButton undo;
	JTextField hScores, aScores, showPeriod;
	JLabel home, away, period, space;
	
	
	
	
	GridBagConstraints gbc = new GridBagConstraints();
	public static final String RES_PATH = "/home/seraf/serah-workspace/Score Board/src/main/font";
	public static final String FILENAME = "/home/seraf/serah-workspace/Score Board/src/main/font/digital-7.ttf"; 
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



		setBackground(Color.GRAY);
		
		
		setLayout(new GridBagLayout());
		
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		
		//button
		addPeriod = new JButton("Update Period");
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);	
		
		
		
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
		
		
//		//text fields
		
		hScores = new JTextField("00");
		hScores.setPreferredSize( new Dimension( 300, 220 ) ); //resize texfield
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
		aScores.setPreferredSize( new Dimension( 300, 220 ) );
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

	
		
		
		

		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,200);
		    hScores.setFont(digitalFont);
		    aScores.setFont(digitalFont);
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
		
		
		
		
		
		
		
		
		
	}

	
	
}

