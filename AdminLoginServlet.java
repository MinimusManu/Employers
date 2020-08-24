package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Admin;
import dao.Admindao;
@WebServlet("/AdminLoginServlet")

public class AdminLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
  
    public AdminLoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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
		 int result = Admindao.loginadmin(username,password);
		 
		 //4. depending om the result we have to decide at which page it should show the result, success page or error page
		 if(result>0)
		 {
			response.sendRedirect("Viewallservlet"); 
		 }
		 else
		 {
			response.sendRedirect("index.jsp"); 
			out.println(" Unable to login, please try again ");
		 }
		 
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	
	}
	}



