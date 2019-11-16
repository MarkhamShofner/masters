package BeartoothJDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private final static String url="jdbc:mysql://web6.jhuep.com:3306/";
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String user = "johncolter";
	private final static String pass = "LetMeIn";
	private final static String db="class"; // class
	
	// Note: only use the options for MySQL drivers version 8 or greater, do not use them with web7 connections
    private final static String options="?useSSL=false&serverTimezone=UTC"; // ?useSSL=false
    
    public Main() {
    	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
	    	try (Connection conn = DriverManager.getConnection(url + db + options, user, pass);
	    		Statement statement = conn.createStatement()) {
		        DatabaseMetaData meta = conn.getMetaData();
		        System.out.println("Driver name: " + meta.getDriverName());
		        System.out.println("Driver version: " + meta.getDriverVersion());
		
		        ResultSet resultSet = statement.executeQuery("select reservation.First, reservation.Last, guides.First, guides.Last, reservation.StartDay, locations.location from reservation, guides, locations where reservation.guide = guides.idguides and reservation.location = locations.idlocations and reservation.StartDay >= '2014-09-01'");
		        System.out.println("Reservations in the database after 2014-09-01 are:");
		        resultSet.first();
		        while (!resultSet.isAfterLast()) {
		            String firstName = resultSet.getString(1);
		            String lastName = resultSet.getString(2);
		            String guideFirstName = resultSet.getString(3);
		            String guideLastName = resultSet.getString(4);
		            String reservationStart = resultSet.getString("StartDay");
		            String location = resultSet.getString("location");
		            System.out.println("  " + firstName + " " + lastName + " " + guideFirstName + " " + guideLastName + " " + reservationStart + " " + location);
		            resultSet.next();
		        }
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} catch (Exception e) {
    		System.out.println(e.toString());
    	}

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
    }

}
