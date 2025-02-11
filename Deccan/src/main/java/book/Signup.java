package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Signup() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
response.setContentType("text/html");

		String name = request.getParameter("username");
		System.out.println(name);
		String mobile = request.getParameter("mobile");
		System.out.println(mobile);
		String mail = request.getParameter("email");
		System.out.println(mail);
		String password=request.getParameter("password");
		System.out.println(password);
		
		PrintWriter pw=response.getWriter();
		
		try {
			 String query="insert into `Signup`(`User_Name`,`Mobile`,`Email`,`Password`)values(?,?,?,?)";  
			PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, mail);
			ps.setString(4, password);
			
			if(ps.executeUpdate()>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Flights.html");
				rd.include(request, response);
				pw.print("Register Sucessfully!!");
			}
			else {
				pw.print("Not Reg");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
		
		
	}



		
		
		
	}


