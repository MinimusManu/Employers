package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Admindao;

@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			PrintWriter out= response.getWriter();
			response.setContentType("text/html");
			
		  //1. get all the beans from the jsp and html page
		int id = Integer.parseInt(request.getParameter("id"));	
		String firstname= request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		//2. get this bean inside the bean class (admin class), setUsername() and setPassword()	
		User u= new User();
		u.setId(id);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setEmail(email);
		u.setAddress(address);
		u.setPhone(phone);
		//3. call the dao method which register this particulars admin 
		 int result = Admindao.updateuser(u);
		 
		 //4. depending om the result we have to decide at which page it should show the result, success page or error page
		 if(result>0)
		 {
			response.sendRedirect("Viewallservlet"); 
		 }
		 else
		 {
			response.sendRedirect("Viewallservlet"); 
		 }
		 
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	
	}

}
