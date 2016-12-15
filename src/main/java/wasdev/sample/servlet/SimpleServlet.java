package wasdev.sample.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import ibm.smartWatch.heartRate.HeartRateController;
import ibm.smartWatch.utils.CSVReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HeartRateController heartController;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html");
		// response.getWriter().print("Hello World!");

		try {
			// just the name of the parameter in the URL
			String fileUrl = request.getParameter("fileUrl");

			URL url = new URL(fileUrl);
			response.getWriter().println("step 1 ");

			response.getWriter().println("my file is: " + url.getContent().toString());

			// Create a temp file
			File tmp = File.createTempFile("myTmp", ".csv");
			tmp.deleteOnExit();
			IOUtils.copy(url.openStream(), new FileOutputStream(tmp));

			response.setContentType("application/json");
			response.getWriter().write("Stefy");

		} catch (Exception e) {
			response.setContentType("text/html");
			response.getWriter().println("Hello no good parameter!");
			// e.printStackTrace(response.getWriter());

		}
	}

	public static void main(String[] args) throws ServletException {

		String csvFile = "C://smartwatch//Heart Rate data fromQSACCESS.csv";
		System.out.println("Evaluating file:  " + csvFile + System.lineSeparator());
		heartController = new HeartRateController();
		CSVReader.parseHeartRateCSVFile(csvFile,  heartController);
	}
	
	
	

}
