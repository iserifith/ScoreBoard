package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class ShotClock extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public static final String RES_PATH = "/home/seraf/serah-workspace/Score Board/src/main/font";
	public static final String FILENAME = "/home/seraf/serah-workspace/Score Board/src/main/font/digital-7.ttf"; 
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
	JButton subPeriod;
	
	
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
	    
		setBackground(Color.GRAY);
		
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
	    txtSCTime.setBackground(Color.ORANGE);
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
		btnSCStart.setMargin(new Insets(0,0,0,0));
		btnSCStart.setPreferredSize(new Dimension(70,50));
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
		btnSCStop.setMargin(new Insets(0,0,0,0));
		btnSCStop.setPreferredSize(new Dimension(70,50));
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
		
		
		btnSCAdd = new JButton("Add Sec");
		btnSCAdd.setMargin(new Insets(0,0,0,0));
		btnSCAdd.setPreferredSize(new Dimension(70,50));
		btnSCAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = false;
				modifyClockAdd();
				
			}
		
		});
		
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    btnP.add(btnSCAdd, gbc);
	        
		btnSCSub = new JButton("Sub Sec");
		btnSCSub.setMargin(new Insets(0,0,0,0));
		btnSCSub.setPreferredSize(new Dimension(70,50));
		btnSCSub.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = false;
				modifyClockSub();
				
			}
		
		});
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
		showPeriod.setForeground(Color.RED);
		showPeriod.setBackground(Color.GREEN);
		showPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		periodPanel.add(showPeriod, gbc);
		
		JPanel periodButton = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		periodButton.setLayout(new GridBagLayout());
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		
		addPeriod = new JButton("Add");
		addPeriod.setMargin(new Insets(0,0,0,0));
		addPeriod.setPreferredSize( new Dimension(70,100) );
		addPeriod.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = showPeriod.getText();
				int i = Integer.parseInt(s) + 1;
					
				showPeriod.setText(""+i);
				 	
			}
	
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		periodButton.add(addPeriod, gbc);
		
		subPeriod = new JButton("Sub");
		subPeriod.setMargin(new Insets(0,0,0,0));
		subPeriod.setPreferredSize( new Dimension(70,100) );
		subPeriod.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				String s = showPeriod.getText();
//				int i = Integer.parseInt(s) - 1;
//				
//				showPeriod.setText(""+i);
				
				String s = showPeriod.getText();
				int i = Integer.parseInt(s) - 1;
					
				showPeriod.setText(""+i);
				 	
			}
	
		});
		gbc.gridx = 1;
		gbc.gridy = 0;
		periodButton.add(subPeriod, gbc);
		
		
		
		periodPanel.add(periodButton, gbc);
		
		add(periodPanel, gbc);
		
		
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
		
		if (i > 12){
			i = 0;
		}
		txtSCTime.setText(""+i);
		
	}
	
	public void modifyClockAdd(){
		String s = txtSCTime.getText();
		int i = Integer.parseInt(s) + 1;
			
		txtSCTime.setText(""+i);
	}
	
	public void modifyClockSub(){
		String s = txtSCTime.getText();
		int i = Integer.parseInt(s) - 1;
		
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

