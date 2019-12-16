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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		PrintWriter out = response.getWriter();
//
//		out.println("<!DOCTYPE html>");
//
//		out.println("<html>");
//
//		out.println("<h1 align=\"center\">HelloWorld Servlet</h1>");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstName = null;
        String lastName = null;
        String hikingOption = null;
        int startDay = 0;
        int startMonth = 0;
        int startYear = 0;
        int durationOption = 0;

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
            startDay = Integer.parseInt(request.getParameter("startDay"));
            startMonth = Integer.parseInt(request.getParameter("startMonth"));
            startYear = Integer.parseInt(request.getParameter("startYear"));
            durationOption = Integer.parseInt(request.getParameter("durationOption"));
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SimpleForm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Custom Tailored Receipt!</h1>");
            out.println("Welcome " + firstName + " " + lastName + ", ");
            out.println("you picked " + hikingOption + " for your adventure!");
            out.println("<br>");
            out.println("You want to start on " + startMonth + "-" + startDay + "-" + startYear);
            out.println("<br>");
            out.println("And go for " + durationOption + " days");
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
