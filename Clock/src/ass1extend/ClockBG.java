package ass1extend;

import java.awt.*;
import javax.swing.*;

public class ClockBG  extends JFrame{
	
	private ImageIcon img;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JLabel label;
	private String str = "Clock";
	
	private int width;
	private int height;


	public ClockBG() {
		layeredPane = new JLayeredPane();
		img = new ImageIcon("src/bg.png");
		width = img.getIconWidth();
		height = img.getIconHeight();

		
		panel = new JPanel()
		{

		    @Override
			public void paint(Graphics g) {

				Clock clock = new Clock();
				clock.currentTime();
				double h = Integer.parseInt(clock.getHours());
//				if (h>= 12) {
//					h = h-12;
//				}
				double m = Integer.parseInt(clock.getMinutes());
				double s = Integer.parseInt(clock.getSeconds());
				
				h = 5*(h + m/60);
		    	super.paint(g);
				g.setColor(Color.GREEN);
				g.drawLine((width)/2, (height+10)/2,
						(int)((width)/2 + (Math.sin(Math.PI*2*s/60)*260)), 
						(int)((height+10)/2+(-Math.cos(Math.PI*2*s/60)*260)));
				
				g.setColor(Color.CYAN);
				g.drawLine((width)/2, (height+10)/2,
						(int)((width)/2 + (Math.sin(Math.PI*2*m/60)*180)), 
						(int)((height+10)/2+(-Math.cos(Math.PI*2*m/60)*180)));
				
				g.setColor(Color.RED);
				g.drawLine((width)/2, (height+10)/2,
						(int)((width)/2 + (Math.sin(Math.PI*2*h/60)*130)), 
						(int)((height+10)/2+(-Math.cos(Math.PI*2*h/60)*130)));
				
				
				g.setColor(Color.YELLOW);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
				g.drawString(str, width/2-40, height/2+100);

			}
					    
		};
		add(panel);
		panel.setBounds(0,0,width,height+10);
		label = new JLabel(img);
		panel.add(label);

		layeredPane.add(panel,JLayeredPane.DEFAULT_LAYER);
		
		this.setLayeredPane(layeredPane);
		this.setSize(width+15, height+45);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(50,50);
		this.setVisible(true);
		
	}
	
	
	public ClockBG(int offset) {
		layeredPane = new JLayeredPane();
		img = new ImageIcon("src/bg.png");
		width = img.getIconWidth();
		height = img.getIconHeight();

		
		panel = new JPanel()
		{

		    @Override
			public void paint(Graphics g) {

				Clock clock = new Clock();
				clock.currentTime();
				double h = Integer.parseInt(clock.getHours());
				if (h>= 12) {
					h = h-12;
				}
				h = h+4+offset;
				if (h<0) {
					h = h + 24;
				}
				else if (h >= 24) {
					h = h - 24;
				}
				double m = Integer.parseInt(clock.getMinutes());
				double s = Integer.parseInt(clock.getSeconds());
				
				h = 5*(h + m/60);
		    	super.paint(g);
				g.setColor(Color.GREEN);
				g.drawLine((width)/2, (height+10)/2,
						(int)((width)/2 + (Math.sin(Math.PI*2*s/60)*260)), 
						(int)((height+10)/2+(-Math.cos(Math.PI*2*s/60)*260)));
				
				g.setColor(Color.CYAN);
				g.drawLine((width)/2, (height+10)/2,
						(int)((width)/2 + (Math.sin(Math.PI*2*m/60)*180)), 
						(int)((height+10)/2+(-Math.cos(Math.PI*2*m/60)*180)));
				
				g.setColor(Color.RED);
				g.drawLine((width)/2, (height+10)/2,
						(int)((width)/2 + (Math.sin(Math.PI*2*h/60)*130)), 
						(int)((height+10)/2+(-Math.cos(Math.PI*2*h/60)*130)));
				
				
				g.setColor(Color.YELLOW);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
				g.drawString(str, width/2-100, height/2+100);

			}
					    
		};
		add(panel);
		panel.setBounds(0,0,width,height+10);
		label = new JLabel(img);
		panel.add(label);

		layeredPane.add(panel,JLayeredPane.DEFAULT_LAYER);
		
		this.setLayeredPane(layeredPane);
		this.setSize(width+15, height+45);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(50,50);
		this.setVisible(true);
		
	}
	

	public void setStr(String str) {
		this.str = str;
	}
}
