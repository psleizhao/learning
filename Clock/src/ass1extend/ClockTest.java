package ass1extend;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tests the Clock class.
 */
public class ClockTest
{
   public static void main(String[] args)
   {

	   		Clock clock=new Clock();
	   		ClockBG clockBG = new ClockBG();
	   		Timer timer=new Timer();
	   		TimerTask timerTask=new TimerTask(){
	   			public void run() {
	   				clock.currentTime();
	   			//	System.out.println(clock.getTime());
	   				clockBG.repaint();

	   			}
	   		};
	   		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	   		




   }
}
