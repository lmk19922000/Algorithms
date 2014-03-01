package jp.co.wap.exam.lib;

/**
 * @author Le Minh Khue
 * It represents Time as an integer (minute representation).
 */
public class TimeInteger implements Comparable<Object>{
	final int time;
	final boolean isStartingTime;

	public TimeInteger(int minute, boolean isStart) {
		this.time = minute;
		this.isStartingTime = isStart;
	}
	
	public boolean isStartingTime(){
		return isStartingTime;
	}
	
	@Override
	public String toString() {
		return String.format("%04d", time);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TimeInteger)) {
			return false;
		}
		TimeInteger other = (TimeInteger) obj;
		return (this.time == other.time && this.isStartingTime == other.isStartingTime);
	}

	@Override
	public int compareTo(Object obj) {
		if (!(obj instanceof TimeInteger)) {
			return -1;
		}
		TimeInteger other = (TimeInteger) obj;
		
		if ((this.time < other.time) || (this.time == other.time && this.isStartingTime && !other.isStartingTime)){
        	return -1;
        } else if ((this.time > other.time) || (this.time == other.time && !this.isStartingTime && other.isStartingTime)){
        	return 1;
        } else {
        	return 0;
        }
	}
}
