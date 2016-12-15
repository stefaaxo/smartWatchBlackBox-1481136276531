package ibm.smartWatch.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import ibm.smartWatch.heartRate.HeartRateController;
import ibm.smartWatch.heartRate.HeartRateModel;

public class CSVReader {


	public static void parseHeartRateCSVFile(String csvFile, HeartRateController heartController) {

		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] heart = line.split(cvsSplitBy);
				// if (heart.length != 0)
				// System.out.println(" heart length " + heart.length);
				if (heart.length == 3) {
					// System.out.println("heart [startTime= " + heart[0] +  "]");
					// System.out.println("heart [endTime= " + heart[1] + "]");
					// System.out.println("heart [rate= " + heart[2] + "]");

					Integer rate = null;
					try {
						rate = new Integer(Integer.parseInt(heart[2]));
					} catch (NumberFormatException nfe) {
						continue;
					}

					HeartRateModel currentHeartRate = new HeartRateModel();

					currentHeartRate.setHeartRate(rate);
					SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy HH:mm");

					currentHeartRate.setStartTime(ft.parse(heart[0]));
					currentHeartRate.setEndTime(ft.parse(heart[1]));
					heartController.setCurrentHeartRateModel(currentHeartRate);
					heartController.evaluateHeartRate();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
