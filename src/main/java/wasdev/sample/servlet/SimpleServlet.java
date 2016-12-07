package wasdev.sample.servlet;

import java.io.IOException;

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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.setContentType("text/html");
        // response.getWriter().print("Hello World!");
        
         try{
         // just the name of the parameter in the URL    
	   	 String fileUrl = request.getParameter("fileUrl");
         URL url = new URL(fileUrl);
             
	     response.getWriter().println("my file is: " + url.getName());
             
         // Create a temp file     
	     File tmp = File.createTempFile("myTmp", ".csv");
	     tmp.deleteOnExit();     	 
	     IOUtils.copy(url.openStream(), new FileOutputStream(tmp));
	 
	     
	 
	     response.setContentType("application/json");
	     response.getWriter().write("Stefy");

	   }catch(Exception e){
	     response.setContentType("text/html");	    	    
        response.getWriter().println("Hello no good parameter!");
        e.printStackTrace(response.getWriter());
        
	   }
    }

}
