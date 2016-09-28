package main;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameClock extends JPanel {
	
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
	JTextField txtGCTime;
	JTextField txtGCSec;
	JTextField txtGCMin;
	JButton btnGCStart;
	JButton btnGCStop;
	JButton btnGCAddMin;
	JButton btnGCSubMin;
	JButton btnGCAddSec;
	JButton btnGCSubSec;
	
	
	public GameClock(){
		if (RIGHT_TO_LEFT) {
				setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	       }
		
		setLayout(new GridBagLayout());
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

		JPanel panelGC = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		panelGC.setLayout(new GridBagLayout());
		panelGC.setBackground(Color.GRAY);
		 
		txtGCSec = new JTextField("0");
		
		txtGCMin = new JTextField("0");
    
	    txtGCTime = new JTextField("0:0");
	    txtGCTime.setFocusable(false);
	    txtGCTime.setFont(font);
	    txtGCTime.setPreferredSize(new Dimension(150, 150));
	    txtGCTime.setForeground(Color.RED);
	    txtGCTime.setBackground(Color.ORANGE);
	    txtGCTime.setHorizontalAlignment(SwingConstants.CENTER);	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridy = 1;
		panelGC.add(txtGCTime, gbc);
		
		

		JPanel btnP = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		btnP.setLayout(new GridBagLayout());
		
		btnGCStart = new JButton("Start");
		btnGCStart.setMargin(new Insets(0,0,0,0));
		btnGCStart.setPreferredSize(new Dimension(80,50));
		gbc.gridx = 1;
	    gbc.gridy = 0;
		btnGCStart.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = true;
				
			}
			
		});
		btnP.add(btnGCStart, gbc);
		
		
		
		btnGCStop = new JButton("Stop"); 
		btnGCStop.setMargin(new Insets(0,0,0,0));
		btnGCStop.setPreferredSize(new Dimension(80,50));
		gbc.gridx = 2;
	    gbc.gridy = 0;
	    gbc.weightx = 1.0;

		btnGCStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				runClock = false;
				
			}
			
		});
		btnP.add(btnGCStop, gbc);
		
		
		btnGCAddMin = new JButton("Add Min");
		btnGCAddMin.setMargin(new Insets(0,0,0,0));
		btnGCAddMin.setPreferredSize(new Dimension(80,50));
		btnGCAddMin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = false;
				ModifyClockAddMin();
				
			}
		
		});
		
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    btnP.add(btnGCAddMin, gbc);
	        
		btnGCSubMin = new JButton("Sub Min");
		btnGCSubMin.setMargin(new Insets(0,0,0,0));
		btnGCSubMin.setPreferredSize(new Dimension(80,50));
		btnGCSubMin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = false;
				ModifyClockSubMin();
				
			}
		
		});
		
		gbc.gridx = 2;
	    gbc.gridy = 1;
	    btnP.add(btnGCSubMin, gbc);
		
	    panelGC.add(btnP, gbc);
		
//////////////////////////////////////////////////////
	    
		btnGCAddSec = new JButton("Add Sec");
		btnGCAddSec.setMargin(new Insets(0,0,0,0));
		btnGCAddSec.setPreferredSize(new Dimension(80,50));
		btnGCAddSec.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = false;
				ModifyClockAddSec();
				
			}
		
		});
		
		gbc.gridx = 1;
	    gbc.gridy = 2;
	    btnP.add(btnGCAddSec, gbc);
	        
		btnGCSubSec = new JButton("Sub Sec");
		btnGCSubSec.setMargin(new Insets(0,0,0,0));
		btnGCSubSec.setPreferredSize(new Dimension(80,50));
		btnGCSubSec.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = false;
				ModifyClockSubSec();
				
			}
		
		});
		
		gbc.gridx = 2;
	    gbc.gridy = 2;
	    btnP.add(btnGCSubSec, gbc);
		
		
		add(panelGC , gbc);
		
		
		
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,90);
		    txtGCSec.setFont(digitalFont);
		    txtGCMin.setFont(digitalFont);
		    txtGCTime.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
	
		}
	
	
	
	}
	
	
	
		
		

	
	public void updateClock(){
		
		String gcTextSec = txtGCSec.getText();
		int gcSeconds = Integer.parseInt(gcTextSec);
		gcSeconds++;
		
		String gcTextMin = txtGCMin.getText();
		int gcMinutes = Integer.parseInt(gcTextMin);
		
		
		if (gcSeconds > 60){
			gcSeconds = 0;
			
			//update gcMin

			gcMinutes++;
		}
		if (gcMinutes > 12){
			gcMinutes = 1;
			runClock = false;
		}
		
		txtGCMin.setText(""+gcMinutes);
		txtGCSec.setText(""+gcSeconds);
		txtGCTime.setText(gcTextMin+":"+gcTextSec);

		
	}
	
	
	public void ModifyClockAddSec(){
		String s = txtGCSec.getText();
		int i = Integer.parseInt(s) + 1;
		
		txtGCSec.setText(""+i);
		txtGCTime.setText(txtGCMin.getText()  +":"+txtGCSec.getText());
		
	}
	
	public void ModifyClockSubSec(){
		String s = txtGCSec.getText();
		int i = Integer.parseInt(s) - 1;
	
		txtGCSec.setText(""+i);
		txtGCTime.setText(txtGCMin.getText()  +":"+txtGCSec.getText());

		
	}
	
	//////
	
	public void ModifyClockAddMin(){
		String s = txtGCMin.getText();
		int i = Integer.parseInt(s) + 1;
		
		txtGCMin.setText(""+i);
		
		txtGCTime.setText(txtGCMin.getText()  +":"+txtGCSec.getText());
	}
	
	public void ModifyClockSubMin(){
		String s = txtGCMin.getText();
		int i = Integer.parseInt(s) - 1;
	
		txtGCMin.setText(""+i);
		txtGCTime.setText(txtGCMin.getText()  +":"+txtGCSec.getText());

		
	}
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runClock){
		    	 updateClock();
		     }
		   }
		   
	}
	
	
	
	

}

