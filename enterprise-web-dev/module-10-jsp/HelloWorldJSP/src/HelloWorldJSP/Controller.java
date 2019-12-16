package HelloWorldJSP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class Controller. 
 * Heavily inspired by the lecture notes and MVC2 example.
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
    /** 
    * Processes requests for  HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
 
        ServletContext servletContext = getServletContext();

        Hike hike = new Hike();        
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String hikingOption = request.getParameter("hikingOption");
	    hike.setFirstName(firstName);
	    hike.setLastName(lastName);
	    hike.setHikingOption(hikingOption);
	    
	    System.out.println(hike.getFirstName());

		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/receipt.jsp");
		dispatcher.forward(request, response);
		
    } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
   
    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}


