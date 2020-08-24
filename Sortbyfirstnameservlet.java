package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Admindao;

/**
 * Servlet implementation class Sortbyfirstnameservlet
 */
@WebServlet("/Sortbyfirstnameservlet")
public class Sortbyfirstnameservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		out.println("<body><center");
		out.println("<h1>EMPLOYEE MANAGAEMENT SYSTEM</h1>");
		out.println("<form action ='Multiplevalueservlet' method = 'get'>");
		out.println("<input type ='text' name='value'>");
		out.println("<input type ='submit' value='search'>");
		out.println("</form>");
		
		out.println("<table width='100%'>");
		out.println("<form action = 'Insertservlet' method='post'>");
		out.println("<input type ='text' name = 'firstname' placeholder = 'firstname'>");
		out.println("<input type ='text' name = 'lastname' placeholder = 'lastname'>");
		out.println("<input type ='text' name = 'email' placeholder = 'email'>");
		out.println("<input type ='text' name = 'address' placeholder = 'address'>");
		out.println("<input type ='text' name = 'phone' placeholder = 'phone'>");
		out.println("<input type ='submit' value = 'insert new employee'>");
		out.println("</form>");
		out.println("</table>");
		
		out.println("<br><br>");
		out.println("<h2>All employees</h2>");
		out.println("<table width ='100%' border='1'>");
		out.println("<tr><td><a href='Sortbyidservlet'>sort</a></td><td><a  href='Sortbyfirstnameservletdesc'>sort</a></td><td><a>sort</a></td><td><a>sort</a></td><td><a>sort</a></td><td><a>sort</a></td></tr>");
		out.println("<tr><td>id</td><td>firstname</td><td>lastname</td><td>email</td><td>address</td><td>phone</td><td>edit</td><td>delete</td></tr>");
		List<User> list=Admindao.ascendingorderfirstname();
		
		for(   User u: list)
		{
			out.println("<tr><td>"+u.getId()+"</td><td>"+u.getFirstname()+"</td><td>"+u.getLastname()+"</td><td>"+u.getEmail()+"</td><td>"+u.getAddress()+"</td><td>"+u.getPhone()+"</td><td><a href ='Updateservlet1?id="+u.getId()+"'>edit</a></td><td><a href = 'Deleteservlet?id="+u.getId()+"'>delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("<br><br>");
	
		
		out.println("</center></body>");
		}
		catch(Exception em)
		{
			em.printStackTrace();
		}
	}

	
}
