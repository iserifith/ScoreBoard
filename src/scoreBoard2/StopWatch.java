package scoreBoard2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class StopWatch extends JPanel{

	JTextField timeF;
	JLabel Time;	

	public StopWatch() {
		// housekeeping
		Time = new JLabel ("Time");
		setSize(225,200);
		
		setVisible(true);
		
		
		
	}
	
	public class Executor {
		public Executor() {
			new StopWatch;
		}
	}
	
}
