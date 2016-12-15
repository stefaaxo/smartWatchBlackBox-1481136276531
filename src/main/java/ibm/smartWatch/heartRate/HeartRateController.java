package ibm.smartWatch.heartRate;

public class HeartRateController {
	HeartRateModel highHeartRateModel = new HeartRateModel();
	HeartRateModel lowHeartRateModel = new HeartRateModel();
	HeartRateModel currentHeartRateModel = new HeartRateModel();

	public HeartRateController() {

		highHeartRateModel.setHeartRate(HeartRateModel.maxHeartRate);
		lowHeartRateModel.setHeartRate(HeartRateModel.minHeartRate);
	}

	public HeartRateModel getHighHeartRateModel() {
		return highHeartRateModel;
	}

	public void setHighHeartRateModel(HeartRateModel highHeartRateModel) {
		this.highHeartRateModel = highHeartRateModel;
	}

	public HeartRateModel getLowHeartRateModel() {
		return lowHeartRateModel;
	}

	public void setLowHeartRateModel(HeartRateModel lowHeartRateModel) {
		this.lowHeartRateModel = lowHeartRateModel;
	}

	public HeartRateModel getCurrentHeartRateModel() {
		return currentHeartRateModel;
	}

	public void setCurrentHeartRateModel(HeartRateModel currentHeartRateModel) {
		this.currentHeartRateModel = currentHeartRateModel;
	}

	public void evaluateHeartRate() {
		// HIGH heart rate
		if (currentHeartRateModel.getHeartRate() > highHeartRateModel.getHeartRate()) {
			System.err.println("Heart Rate: " + currentHeartRateModel.getHeartRate()
					+ " Alert!!! BOOST of Adrenaline at ---->> " + currentHeartRateModel.getEndTime());
		}
		// LOW heart rate
		if (currentHeartRateModel.getHeartRate() < lowHeartRateModel.getHeartRate()) {
			System.err.println("Heart Rate: " + currentHeartRateModel.getHeartRate()
					+ " Alert!!! Possible falling asleep at ---->> " + currentHeartRateModel.getEndTime());
		}

	}

}
