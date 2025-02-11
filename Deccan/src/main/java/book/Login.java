package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Login() {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		
		String one = request.getParameter("username");
		System.out.println(one);
		String two = request.getParameter("password");
		System.out.println(two);
		
		PrintWriter pw=response.getWriter();
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			String query = "select * from `Signup` where User_Name=? AND Password=?";
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, one);
			ps.setString(2, two);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("Flights.html");
				rd.include(request, response);
				pw.print("Login Sucessfully!!");
			}
			else
			{
				pw.print("Login !!");
	
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
