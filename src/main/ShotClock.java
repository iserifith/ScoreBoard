package scoreBoard2;

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
	Boolean runShotClock = false;
	JPanel buttonP;
	JPanel buttonS;
	JTextField txtSCSec;
	JButton btnSCStart;
	JButton btnSCStop;
	JButton btnSCAdd;
	JButton btnSCSub;
	JLabel shotClock;
	
	GridBagConstraints gbc = new GridBagConstraints();

	
	public ShotClock(){
		
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
	    final Timer timer = new Timer();
	         
	    // scheduling the task at fixed rate delay. See http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask,%20long,%20long)
	    timer.scheduleAtFixedRate(seconds,0,1000);
	    
		setBackground(Color.RED);
		
		
		try {		
			font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			digitalFont = new Font("digital-7", Font.PLAIN, 0); // font name must be the same as filename (without extension). Also changee the size to 150
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		shotClock = new JLabel("Shot Clock");		
		txtSCSec = new JTextField("10");
		txtSCSec.setFocusable(false);
		txtSCSec.setFont(font);
		txtSCSec.setPreferredSize(new Dimension(100, 40));
		txtSCSec.setForeground(Color.RED);
		txtSCSec.setBackground(Color.BLACK);
		txtSCSec.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		btnSCStart = new JButton("Start");
		gbc.gridx = 1;
		gbc.gridy = 1;
		btnSCStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runShotClock = true;
				
			}
			
		});
		
		
		
		btnSCStop = new JButton("Stop");
		gbc.gridx = 2;
		gbc.gridy = 0;
		btnSCStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				runShotClock = false;
				
			}
			
		});
		
		
		btnSCAdd = new JButton("+");
		btnSCSub = new JButton("-");
		
		JPanel panelSC = new JPanel();
		panelSC.add(txtSCSec);
		panelSC.add(btnSCStart);
		panelSC.add(btnSCStop);
		panelSC.add(btnSCAdd);
		panelSC.add(btnSCSub);
		
		
	
		
		add(panelSC, gbc);
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,30);
		    txtSCSec.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
		
	}
	
	public void updateClock(){
		
		String s = txtSCSec.getText();
		int i = Integer.parseInt(s) + 1;
		
		if (i > 4){
			i = 0;
		}
		txtSCSec.setText(""+i);
		
		
	}
	
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runShotClock){
		    	 updateClock();
		     }   
		 }  
	}	
}

