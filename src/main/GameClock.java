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
	JPanel buttonP;
	JPanel buttonS;
	JTextField txtGCSec;
	JTextField txtGCMin;
	JLabel clockLbl;
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

		
		
		
		clockLbl = new JLabel("Clock");
		clockLbl.setSize(60, 30);
		        gbc.gridx = 0;
		        gbc.gridy = 0;
		
		txtGCSec = new JTextField("10");
		txtGCSec.setFocusable(false);
		txtGCSec.setFont(font);
		txtGCSec.setPreferredSize(new Dimension(100, 40));
		txtGCSec.setForeground(Color.RED);
		txtGCSec.setBackground(Color.BLACK);
		txtGCSec.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.ipady = 40;      //make this component tall
	    gbc.weightx = 0.0;
	    gbc.gridwidth = 3;
	    gbc.gridx = 1;
	    gbc.gridy = 1;
		
		txtGCMin = new JTextField("00");
		txtGCMin.setFocusable(false);
//		timeM.setFont(font);
		txtGCMin.setPreferredSize(new Dimension(100, 40));
		txtGCMin.setForeground(Color.RED);
		txtGCMin.setBackground(Color.BLACK);
		gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.ipady = 40;      //make this component tall
	    gbc.weightx = 0.0;
	    gbc.gridwidth = 3;
	    gbc.gridx = 2;
	    gbc.gridy = 1;
		
		btnGCStart = new JButton("Start");
		btnGCStart.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = true;
				
			}
			
		});
		
		
		
		btnGCStop = new JButton("Stop");     
		btnGCStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				runClock = false;
				
			}
			
		});
		
		
		btnGCAdd = new JButton("+");
		
	        
		btnGCSub = new JButton("-");
		
	        
		JPanel panelGC = new JPanel();
		 if (shouldWeightX) 
		 {
			 gbc.weightx = 0.5;
		 }
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 6;
		gbc.gridy = 1;
		panelGC.add(txtGCMin);
		panelGC.add(txtGCSec);
		panelGC.add(btnGCStart);
		panelGC.add(btnGCStop);
		panelGC.add(btnGCAdd);
		panelGC.add(btnGCSub);
		
//		JPanel buttonP = new JPanel();
//		 if (shouldWeightX) 
//		 {
//			 gbc.weightx = 0.5;
//		 }
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		gbc.gridx = 4;
//		gbc.gridy = 1;
//		buttonP.add(btnGCAdd);
//		buttonP.add(btnGCSub);
		
//		add(clockLbl , gbc);
//		add(txtGCMin , gbc);
//		add(txtGCSec , gbc);
		
		
		
		add(panelGC , gbc);
		
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,30);
		    txtGCSec.setFont(digitalFont);
		    txtGCMin.setFont(digitalFont);
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
		
		//int gcMinutes = +1;
		
		if (gcSeconds > 60){
			gcSeconds = 0;
			
			//update gcMin

			gcMinutes++;
		}
		if (gcMinutes > 12){
			gcMinutes = 0;
			runClock = false;
		}
		
		txtGCMin.setText(""+gcMinutes);
		txtGCSec.setText(""+gcSeconds);
		
		
	}
	
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runClock){
		    	 updateClock();
		     }
		   }
	}
	
	

}

