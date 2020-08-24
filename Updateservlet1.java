package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Admindao;

/**
 * Servlet implementation class Updateservlet1
 */
@WebServlet("/Updateservlet1")
public class Updateservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter out= response.getWriter();
			response.setContentType("text/html");
			
			int id = Integer.parseInt(request.getParameter("id"));
			User u = Admindao.viewallempbyid(id);
			
			out.println("<body><center");
			out.println("<h1>EMPLOYEE MANAGAEMENT SYSTEM</h1>");
			out.println("<form action ='Multiplevalueservlet' method = 'get'>");
			out.println("<input type ='text' name='value'>");
			out.println("<input type ='submit' value='search'>");
			out.println("</form>");
				
			out.println("<table width='100%'>");
			out.println("<form action = 'Updateservlet' method='post'>");
			out.println("<input type ='hidden' name = 'id' value='"+u.getId()+"'>");
			out.println("<input type ='text'   name = 'firstname' value='"+u.getFirstname()+"'>");
			out.println("<input type ='text'   name = 'lastname'value='"+u.getLastname()+"'>");
			out.println("<input type ='text'   name = 'email' value='"+u.getEmail()+"'>");
			out.println("<input type ='text'   name = 'address' value='"+u.getAddress()+"'>");
			out.println("<input type ='number'   name = 'phone' value='"+u.getPhone()+"'>");
			out.println("<input type ='submit' value = 'edit employee'>");
			out.println("</form>");
			out.println("</table>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
