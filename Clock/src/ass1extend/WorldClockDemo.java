package ass1extend;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Tests the Clock and WorldClock Classes.
 */
public class WorldClockDemo
{
   public static void main(String[] args)
   {
      //test WorldClock
      System.out.println("");
      System.out.println("Testing WorldClock class");
      int offset = -4;
      System.out.println("Offset: " + offset);
      WorldClock wclock = new WorldClock(offset);
 		ClockBG clockBG = new ClockBG(offset);
 		clockBG.setStr("Time Zond: "+Integer.toString(offset));
 		Timer timer=new Timer();
 		TimerTask timerTask=new TimerTask(){
 			public void run() {
 				wclock.currentTime();
 			//	System.out.println(clock.getTime());
 				clockBG.repaint();

 			}
 		};
 		timer.scheduleAtFixedRate(timerTask, 0, 1000);
 		

   }
}
