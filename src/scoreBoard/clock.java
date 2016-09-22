package scoreBoard;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class clock extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// components
	JTextField timeF;
	JPanel panel;
	
	public clock() {
		// housekeeping
		super("Java Clock by [insert your name here]");
		setSize(225,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);// for now
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		timeF = new JTextField(10);
		timeF.setEditable(false);
		timeF.setFont(new Font("Arial", Font.PLAIN, 50));
		
		panel.add(timeF);
		
		add(panel);
		
		Timer t = new Timer(1000,new Listener());
		t.start();
	}
	
	class Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
					
				Calendar rightNow = Calendar.getInstance();
				int hour = rightNow.get(Calendar.HOUR_OF_DAY);
				int min = rightNow.get(Calendar.MINUTE);
				int sec = rightNow.get(Calendar.SECOND);
				
				timeF.setText(hour+";"+min+";"+sec);
			}
	}
}