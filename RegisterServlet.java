package servlets;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Admin;
import dao.Admindao;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
    
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			PrintWriter out= response.getWriter();
			response.setContentType("text/html");
			
		  //1. get all the beans from the jsp and html page
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2. get this bean inside the bean class (admin class), setUsername() and setPassword()	
		Admin a = new Admin();
		a.setUsername(username);
		a.setPassword(password);
		
		//3. call the dao method which register this particulars admin 
		 int result = Admindao.registeradmin(a);
		 
		 //4. depending om the result we have to decide at which page it should show the result, success page or error page
		 if(result>0)
		 {
			response.sendRedirect("index.jsp"); 
		 }
		 else
		 {
			out.println(" Unable to register, please try again ");
			response.sendRedirect("register.jsp"); 
		 }
		 
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	
	}

}
