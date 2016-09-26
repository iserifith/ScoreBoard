package scoreBoard2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class GameClock extends JPanel {
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public static final String RES_PATH = "src/font";
	public static final String FILENAME = "src/font/digital-7.ttf"; //file name must be in relative to the source code. In our case, our font is inside "font" folder
	Font font = null;
	Font digitalFont = null;
	Boolean runClock = false;
	JPanel button;
	JTextField txtGCTime;
	JTextField txtGCSec;
	JTextField txtGCMin;
	JButton btnGCStart;
	JButton btnGCStop;
	JButton btnGCAdd;
	JButton btnGCSub;
	
	
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
	    
		setBackground(Color.BLUE);
//		setSize(new Dimension(500, 500));
//		setPreferredSize(new Dimension(1500, 1500));
		
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
		 
		txtGCSec = new JTextField("0");
//		txtGCSec.setFocusable(false);
//		txtGCSec.setFont(font);
//		txtGCSec.setPreferredSize(new Dimension(100, 40));
//		txtGCSec.setForeground(Color.RED);
//		txtGCSec.setBackground(Color.BLACK);
//		txtGCSec.setHorizontalAlignment(SwingConstants.CENTER);
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//	    gbc.ipady = 40;      //make this component tall
//	    gbc.weightx = 0.0;
//	    gbc.gridwidth = 3;
//	    gbc.gridx = 1;
//	    gbc.gridy = 1;
		
		txtGCMin = new JTextField("0");
//		txtGCMin.setFocusable(false);
////		timeM.setFont(font);
//		txtGCMin.setPreferredSize(new Dimension(100, 40));
//		txtGCMin.setForeground(Color.RED);
//		txtGCMin.setBackground(Color.BLACK);
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//	    gbc.ipady = 40;      //make this component tall
//	    gbc.weightx = 0.0;
//	    gbc.gridwidth = 3;
//	    gbc.gridx = 2;
//	    gbc.gridy = 1;
//	    
	    txtGCTime = new JTextField("0:0");
	    txtGCTime.setFocusable(false);
	    txtGCTime.setFont(font);
	    txtGCTime.setPreferredSize(new Dimension(140, 140));
	    txtGCTime.setForeground(Color.RED);
	    txtGCTime.setBackground(Color.BLACK);
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
		btnGCStart.setPreferredSize(new Dimension(70,70));
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
		btnGCStop.setPreferredSize(new Dimension(70,70));
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
		
		
		btnGCAdd = new JButton("+");
		btnGCAdd.setPreferredSize(new Dimension(50,50));
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    btnP.add(btnGCAdd, gbc);
	        
		btnGCSub = new JButton("-");
		btnGCSub.setPreferredSize(new Dimension(50,50));
		gbc.gridx = 2;
	    gbc.gridy = 1;
	    btnP.add(btnGCSub, gbc);
		
	    panelGC.add(btnP, gbc);
		
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		gbc.gridx = 6;
//		gbc.gridy = 1;
		
//		panelGC.add(txtGCMin);
//		panelGC.add(txtGCSec);
//		panelGC.add(btnGCStart);
//		panelGC.add(btnGCStop);
//		panelGC.add(btnGCAdd);
//		panelGC.add(btnGCSub);
		

		
		
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
	
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runClock){
		    	 updateClock();
		     }
		   }
	}
	
	

}

