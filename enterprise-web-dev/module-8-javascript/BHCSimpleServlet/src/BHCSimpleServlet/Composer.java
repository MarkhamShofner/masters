package BHCSimpleServlet;

/*
 * PLEASE NOTE: much of this code is based on the pattern laid out in
 * SiompleFormServlet.java that was a part of the module's materials
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import simpleFormServlet.String;

/**
 * Servlet implementation class Composer
 */
@WebServlet("/Composer")
public class Composer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Composer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstName = null;
        String lastName = null;
        String hikingOption = null;
        String StartDate = null;
        int durationOption = 0;
        int partySize = 0;

        try {
            firstName = request.getParameter("firstName");
            if (firstName == null) {
                firstName = "<none entered>";
            }
            lastName = request.getParameter("lastName");
            if (lastName == null) {
                lastName = "<none entered>";
            }
            hikingOption = request.getParameter("hikingOption");
            if (hikingOption == null) {
            	hikingOption = "<none entered>";
            }
            StartDate = request.getParameter("StartDate");
            if (StartDate == null) {
            	StartDate = "<none entered>";
            }
            durationOption = Integer.parseInt(request.getParameter("durationOption"));
            partySize = Integer.parseInt(request.getParameter("partySize"));
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SimpleForm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Custom Tailored Receipt!</h1>");
            out.println("Welcome " + firstName + " " + lastName + ", ");
            out.println("you picked " + hikingOption + " for your adventure!");
            out.println("<br>");
            out.println("You want to start on " + StartDate + ".");
            out.println("<br>");
            out.println("With a party of " + partySize + ".");
            out.println("<br>");
            out.println("And go for " + durationOption + " days!");
            out.println("<br>");
            out.println("</body>");
            out.println("</html>");

        } finally { 
            out.close();
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
