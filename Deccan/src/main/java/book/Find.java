package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Find
 */
@WebServlet("/Find")
public class Find extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Find() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type to HTML
    	response.setContentType("text/html");

    	// Get parameters from the request
    	String F = request.getParameter("from");
    	String T = request.getParameter("To");
    	String BD = request.getParameter("Bdate");

    	// Create the PrintWriter object to send HTML content to the client
    	PrintWriter pw = response.getWriter();

    	try {
    	    // SQL query to fetch flight details based on source and destination
    	    String query = "SELECT *, DATE_FORMAT(Date, '%d %m %Y') AS formatted_date FROM book WHERE Source=? AND Destination=? AND Date=?";
    	    PreparedStatement ps = MyConnection.getConnection().prepareStatement(query);

    	    ps.setString(1, F); // Set the first parameter (Source) 
    	    ps.setString(2, T);  // Set the second parameter (Destination)
    	    ps.setString(3, BD); // Set the third parameter (Date)

    	    // Execute the query and get the result set
    	    ResultSet rs = ps.executeQuery();

    	    // Include the Flight1.html page before displaying data
    	    RequestDispatcher rd = request.getRequestDispatcher("Flight1.html");
    	    rd.include(request, response);

    	    // Start the HTML table for displaying results
    	    pw.println("<html><body>");
    	    pw.println("<h2 align='center'>Flight Details</h2>");
    	    pw.println("<table border='1' align='center'>");
    	    pw.println("<tr><th>Flight_Num</th><th>Flight_Name</th><th>Source</th><th>Destination</th><th>Date</th><th>Status</th><th>Book</th></tr>");

    	    // Iterate through the result set and display flight data
    	    while (rs.next()) {
    	        String flightNum = rs.getString("Flight_Num");
    	        String flightName = rs.getString("Flight_Name");
    	        String source = rs.getString("Source");
    	        String destination = rs.getString("Destination");
    	        String date = rs.getString("Date");

    	        // Add flight data to the table and add a 'Book' link with parameters
    	        pw.println("<tr>");
    	        pw.println("<td>" + flightNum + "</td>");
    	        pw.println("<td>" + flightName + "</td>");
    	        pw.println("<td>" + source + "</td>");
    	        pw.println("<td>" + destination + "</td>");
    	        pw.println("<td>" + date + "</td>");
    	        pw.println("<td>Available</td>");  // You can use a dynamic status if available

    	        // Link to Booking page with flight details as query parameters
    	        pw.println("<td><a href='Booking.html?flightNum=" + flightNum + "&flightName=" + flightName + "&source=" + source + "&destination=" + destination + "&date=" + date + "'>Book</a></td>");
    	        pw.println("</tr>");
    	    }

    	    pw.println("</table>");
    	    pw.println("</body></html>");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    pw.println("<p>Error: " + e.getMessage() + "</p>");
    	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delegate POST requests to the doGet method
        doGet(request, response);
    }
}
