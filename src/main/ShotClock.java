package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ShotClock extends JPanel {
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public static final String RES_PATH = "src/font";
	public static final String FILENAME = "src/font/digital-7.ttf"; //file name must be in relative to the source code. In our case, our font is inside "font" folder
	Font font = null;
	Font digitalFont = null;
	Boolean runClock = false;
	JPanel button;
	JTextField txtSCTime;
	JTextField txtSCSec;
	JTextField txtSCMin;
	JButton btnSCStart;
	JButton btnSCStop;
	JButton btnSCAdd;
	JButton btnSCSub;
	JTextField showPeriod;
	JButton addPeriod;
	
	
	public ShotClock(){
		if (RIGHT_TO_LEFT) {
				setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	       }
		
		setLayout(new FlowLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		if (shouldFill) {
		    //natural height, maximum width
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    }

		RunEverySecond seconds = new RunEverySecond();
		// instantiate a Timer object
	    Timer timer = new Timer();
	         
	    // scheduling the task at fixed rate delay. See http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask,%20long,%20long)
	    timer.scheduleAtFixedRate(seconds,0,1000);
	    
		setBackground(Color.BLUE);
		
		try {		
			font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			digitalFont = new Font("digital-7", Font.PLAIN, 0); // font name must be the same as filename (without extension). Also changee the size to 150
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel panelSC = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		panelSC.setLayout(new GridBagLayout());
		 
		txtSCTime = new JTextField("00");
	    txtSCTime.setFocusable(false);
	    txtSCTime.setPreferredSize(new Dimension(100, 100));
	    txtSCTime.setForeground(Color.RED);
	    txtSCTime.setBackground(Color.BLACK);
	    txtSCTime.setHorizontalAlignment(SwingConstants.CENTER);	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridy = 1;
		panelSC.add(txtSCTime, gbc);


		JPanel btnP = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		btnP.setLayout(new GridBagLayout());
		
		btnSCStart = new JButton("Start");
		btnSCStart.setPreferredSize(new Dimension(70,70));
		gbc.gridx = 1;
	    gbc.gridy = 0;
		btnSCStart.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = true;
				
			}
			
		});
		btnP.add(btnSCStart, gbc);
		
		
		
		btnSCStop = new JButton("Stop");  
		btnSCStop.setPreferredSize(new Dimension(70,70));
		gbc.gridx = 2;
	    gbc.gridy = 0;
	    gbc.weightx = 1.0;

		btnSCStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				runClock = false;
				
			}
			
		});
		btnP.add(btnSCStop, gbc);
		
		
		btnSCAdd = new JButton("+");
		btnSCAdd.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    btnP.add(btnSCAdd, gbc);
	        
		btnSCSub = new JButton("-");
		btnSCSub.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
	    gbc.gridy = 1;
	    btnP.add(btnSCSub, gbc);
		
	    panelSC.add(btnP, gbc);
		
		
		add(panelSC , gbc);
		
		JPanel periodPanel = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		periodPanel.setLayout(new GridBagLayout());
		
		showPeriod = new JTextField("00");
		showPeriod.setPreferredSize( new Dimension( 100, 100 ) );
		showPeriod.setFocusable(false);
		showPeriod.setFont(digitalFont);
		showPeriod.setForeground(Color.GREEN);
		showPeriod.setBackground(Color.BLACK);
		showPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		addPeriod = new JButton("Add");
		addPeriod.setPreferredSize( new Dimension( 70, 100 ) );
		gbc.gridx = 1;
		gbc.gridy = 0;
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
		
		periodPanel.add(showPeriod);
		periodPanel.add(addPeriod);
		add(periodPanel , gbc);
		
		
		
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,90);
		    txtSCTime.setFont(digitalFont);
		    showPeriod.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		}
		

	
	public void updateClock(){
		
		String s = txtSCTime.getText();
		int i = Integer.parseInt(s) + 1;
		
		if (i > 4){
			i = 0;
		}
		txtSCTime.setText(""+i);
		
	}
	
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runClock){
		    	 updateClock();
		     }
		   }
	}
	
	

}

