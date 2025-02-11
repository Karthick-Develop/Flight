package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Booking")
public class Booking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Booking() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve form parameters from the request
        String flightNum = request.getParameter("flightNum");
        String flightName = request.getParameter("flightName");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String seats = request.getParameter("seat");
        String net = request.getParameter("net");

        PrintWriter pw = response.getWriter();

        try {
            // Prepare SQL query to insert booking into the Ticket table
            String query = "INSERT INTO Ticket(Flight_Num, Flight_Name, Source, Destination, Date, Name, Mobile, Category, Price, seat, Amount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = MyConnection.getConnection().prepareStatement(query);

            // Set values for the prepared statement
            ps.setString(1, flightNum);
            ps.setString(2, flightName);
            ps.setString(3, source);
            ps.setString(4, destination);
            ps.setString(5, date);
            ps.setString(6, name);
            ps.setString(7, mobile);
            ps.setString(8, category);
            ps.setString(9, price);
            ps.setString(10, seats);
            ps.setString(11, net);

            // Execute the query and check if successful
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Store booking details in session
                HttpSession session = request.getSession();
                session.setAttribute("flightNum", flightNum);
                session.setAttribute("flightName", flightName);
                session.setAttribute("net", net);

                // Redirect to payment page
                response.sendRedirect("Payment.jsp");
            } else {
                pw.print("<p>Error in booking. Please try again.</p>");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            pw.print("<p>Error: " + ex.getMessage() + "</p>");
        }
    }
}
