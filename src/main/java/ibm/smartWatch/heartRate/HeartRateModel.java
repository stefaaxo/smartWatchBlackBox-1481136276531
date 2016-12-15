package ibm.smartWatch.heartRate;

import java.util.Date;

public class HeartRateModel implements HeartRateThreshold {
	
	Integer heartRate = new Integer(70); // initial value
	Date startTime = new Date();
	Date endTime = new Date();

	public Integer getHeartRate() {
		return heartRate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setHeartRate(Integer currentHeartRate) {
		this.heartRate = currentHeartRate;
	}

}
