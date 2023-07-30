package ass1extend;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
   Part I: Implement a class Clock whose getHours, getMinutes and
   getTime methods return the current time at your location.
   Return the time as a string.

   Here is how to retrieve the current time as a String:
    With Java 8, you can use 3 classes in the java.time package:
      Instant, LocalDateTime and ZoneId. Here's how you do it:
      String timeString = LocalDateTime.ofInstant(Instant.now(),
                              ZoneId.systemDefault()).toString()

   you'll need to extract the hours and minutes as a substring.
*/
public class Clock
{
   // Your work goes here
	private String hours;
	private String minutes;
	private String seconds;
	

	public Clock() {
//		String timeString = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
//		setHours(timeString.substring(11, 13));
//		setMinutes(timeString.substring(14, 16));
//		setSeconds(timeString.substring(17, 19));
	};
	
	public void currentTime() {
		String timeString = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
		setHours(timeString.substring(11, 13));
		setMinutes(timeString.substring(14, 16));
		setSeconds(timeString.substring(17, 19));
	}

	/**
	 * @return the hours
	 */
	public String getHours() {
		return hours;
	}



	/**
	 * @param hours the hours to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}



	/**
	 * @return the minutes
	 */
	public String getMinutes() {
		return minutes;
	}



	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}



	/**
	 * @return the seconds
	 */
	public String getSeconds() {
		return seconds;
	}



	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	
	
	public String getTime() {
		return getHours() + ":" + getMinutes() + ":" + getSeconds();
	}


}

