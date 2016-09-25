package scoreBoard2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ShotClock extends JPanel {
	
	public static final String RES_PATH = "src/font";
	public static final String FILENAME = "src/font/digital-7.ttf"; //file name must be in relative to the source code. In our case, our font is inside "font" folder
	Font font = null;
	Font digitalFont = null;
	Boolean runShotClock = false;
	JPanel buttonP;
	JPanel buttonS;
	JTextField timeF;
	JButton startB;
	JButton stop;
	JButton addC;
	JButton subC;
	JLabel shotClock;
	
	
	public ShotClock(){
		
		
		RunEverySecond seconds = new RunEverySecond();
		// instantiate a Timer object
	    final Timer timer = new Timer();
	         
	    // scheduling the task at fixed rate delay. See http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask,%20long,%20long)
	    timer.scheduleAtFixedRate(seconds,0,1000);
	    
	    	
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(300, 140));
		
		try {		
			font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			digitalFont = new Font("digital-7", Font.PLAIN, 0); // font name must be the same as filename (without extension). Also changee the size to 150
		} catch (Exception e) {
			e.printStackTrace();
		}

		setLayout(new FlowLayout());
		
		shotClock = new JLabel("Shot Clock");		
		timeF = new JTextField("00");
		timeF.setFocusable(false);
		timeF.setFont(font);
		timeF.setPreferredSize(new Dimension(40, 40));
		timeF.setForeground(Color.RED);
		timeF.setBackground(Color.BLACK);
		timeF.setHorizontalAlignment(SwingConstants.CENTER);
		startB = new JButton("Start");
		startB.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runShotClock = true;
				
			}
			
		});
		
		startB.setPreferredSize(new Dimension(30, 50));
		
		
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				runShotClock = false;
				
			}
			
		});
		
		stop.setPreferredSize(new Dimension(40, 40));
		
		addC = new JButton("+");
		addC.setPreferredSize(new Dimension(40, 40));
		subC = new JButton("-");
		subC.setPreferredSize(new Dimension(40, 40));
		
		JPanel buttonS = new JPanel();
		buttonS.add(startB);
		buttonS.add(stop);
		
		JPanel buttonP = new JPanel();		
		buttonP.add(addC);
		buttonP.add(subC);
		
	
		add(shotClock);
		add(timeF);
		add(buttonS);
		add(buttonP);
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,30);
		    timeF.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
	}
	
	public void updateClock(){
		
		String s = timeF.getText();
		int i = Integer.parseInt(s) + 1;
		
		if (i > 4){
			i = 0;
		}
		timeF.setText(""+i);
		
		
	}
	
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runShotClock){
		    	 updateClock();
		     }   
		 }  
	}	
}

