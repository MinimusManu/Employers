package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Admindao;


@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			//collect the beans 
			int id = Integer.parseInt(request.getParameter("id"));
			Admindao.deleteempbyid(id);
			response.sendRedirect("Viewallservlet");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
