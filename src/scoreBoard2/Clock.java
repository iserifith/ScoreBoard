package scoreBoard2;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Calendar;

public class Clock extends JPanel {
	
	public static final String RES_PATH = "src/font";
	public static final String FILENAME = "src/font/digital-7.ttf"; //file name must be in relative to the source code. In our case, our font is inside "font" folder
	Font font = null;
	Font digitalFont = null;
	
	
	
	JTextField timeF;
	JButton start;
	JButton stop;
	
	GridBagConstraints gbc = new GridBagConstraints();

	
	public Clock(){
		
		setBackground(Color.BLACK);
		
		setPreferredSize(new Dimension(500, 150));
		
		
		try {		
			font = Font.createFont(Font.TRUETYPE_FONT, new File(FILENAME));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			digitalFont = new Font("digital-7", Font.PLAIN, 150); // font name must be the same as filename (without extension). Also changee the size to 150
		} catch (Exception e){
			e.printStackTrace();
		}
		
	
		
		
		setLayout(new GridBagLayout());
		
		
		timeF = new JTextField();
		timeF.setFocusable(false);
		timeF.setFont(font);
		timeF.setPreferredSize(new Dimension(300, 140));
		timeF.setForeground(Color.RED);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);	
		
		start = new JButton("Start");
		start.setPreferredSize(new Dimension(100, 140));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(3,3,3,3);	
		
		stop = new JButton("Stop");
		stop.setPreferredSize(new Dimension(100, 140));
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		add(timeF);
		add(start);
		add(stop);
		
		final Timer t = new Timer(1000,new Listener());
		
		
		start.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        t.start();
		    }
		});
		
		
		try {
			
		    Font digitalFont = new Font("digital-7" ,Font.PLAIN,100);
		    timeF.setFont(digitalFont);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
		}
	
	
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				
			Calendar rightNow = Calendar.getInstance();
			int min = rightNow.get(Calendar.MINUTE);
			int sec = rightNow.get(Calendar.SECOND);
			int mil = rightNow.get(Calendar.MILLISECOND);
			
			timeF.setText(min+":"+sec+":"+mil);
		}
	}
}

