package Lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


			@Override
			protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				HttpSession session = request.getSession();
				session.invalidate();
				PrintWriter pw = response.getWriter();
				pw.println("<html><head><title>Logout</title></head><body>");

				pw.println("<a href=Login>Login</a>");
				pw.println("</body></html>");
				response.sendRedirect("Login");
			}


			@Override
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
			}		
}
