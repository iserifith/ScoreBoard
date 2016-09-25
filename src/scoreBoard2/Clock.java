package scoreBoard2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends JPanel {
	
	public static final String RES_PATH = "src/font";
	public static final String FILENAME = "src/font/digital-7.ttf"; //file name must be in relative to the source code. In our case, our font is inside "font" folder
	Font font = null;
	Font digitalFont = null;
	Boolean runClock = false;
	JPanel buttonP;
	JPanel buttonS;
	JTextField timeF;
	JTextField timeM;
	JButton start;
	JButton stop;
	JButton addC;
	JButton subC;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Clock(){
		
		
		RunEverySecond seconds = new RunEverySecond();
		// instantiate a Timer object
	    Timer timer = new Timer();
	         
	    // scheduling the task at fixed rate delay. See http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask,%20long,%20long)
	    timer.scheduleAtFixedRate(seconds,0,1000);
	    
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(1500, 200));
		
		try {		
			font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			digitalFont = new Font("digital-7", Font.PLAIN, 0); // font name must be the same as filename (without extension). Also changee the size to 150
		} catch (Exception e) {
			e.printStackTrace();
		}

		setLayout(new GridBagLayout());

		timeF = new JTextField("00");
		timeF.setFocusable(false);
		timeF.setFont(font);
		timeF.setPreferredSize(new Dimension(400, 40));
		timeF.setForeground(Color.RED);
		timeF.setBackground(Color.BLACK);
		timeF.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.insets = new Insets(1, 1, 1, 1);
		
		timeM = new JTextField("00");
		timeM.setFocusable(false);
//		timeM.setFont(font);
		timeM.setPreferredSize(new Dimension(100, 40));
		timeM.setForeground(Color.RED);
		timeM.setBackground(Color.BLACK);
		
		start = new JButton("Start");
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runClock = true;
				
			}
			
		});
		
		start.setPreferredSize(new Dimension(40, 40));
		
		
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				runClock = false;
				
			}
			
		});
		
		stop.setPreferredSize(new Dimension(40, 40));
		
		addC = new JButton("+");
		addC.setPreferredSize(new Dimension(40, 40));
		subC = new JButton("-");
		subC.setPreferredSize(new Dimension(40, 40));
		
		JPanel buttonS = new JPanel();
		
		buttonS.add(start);
		buttonS.add(stop);
		
		JPanel buttonP = new JPanel();
		
		buttonP.add(addC);
		buttonP.add(subC);
		
	
		add(timeM);
		add(timeF);
		add(buttonS);
		add(buttonP);
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,30);
		    timeF.setFont(digitalFont);
		    timeM.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
	}
	
	public void updateClock(){
		
		String gcTextSec = timeF.getText();
		int gcSeconds = Integer.parseInt(gcTextSec);
		gcSeconds++;
		
		String gcTextMin = timeM.getText();
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
		
		timeM.setText(""+gcMinutes);
		timeF.setText(""+gcSeconds);
		
		
	}
	
	
	
	class RunEverySecond extends TimerTask {

		   public void run() {
		      
		     if (runClock){
		    	 updateClock();
		     }
		   }
	}
	
	

}

