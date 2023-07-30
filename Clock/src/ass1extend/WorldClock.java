package ass1extend;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class WorldClock extends Clock{
	
	public WorldClock(int offset) {

		// String timeString = LocalDateTime.now(ZoneOffset.UTC).toString();
		String timeString = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")).toString();
		int h = Integer.parseInt(timeString.substring(11, 13)) + offset;
		if (h<0) {
			h = h + 24;
		}
		else if (h >= 24) {
			h = h - 24;
		}
		setHours(String.valueOf(h));
		setMinutes(timeString.substring(14, 16));
		setSeconds(timeString.substring(17, 19));
	};
	
}
