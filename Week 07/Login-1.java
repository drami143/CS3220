package Lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><head><title>Login</title></head><body>");
		 pw.println("<form action='Login' method='post'>");
	        
	        pw.println("Username: " + "<input type='text' name='username'><br>");
	        pw.println("<h2></h2>");
	        pw.println("Password:  " + "<input type='text' name='password'><br>");
	        pw.println("<h2></h2>");
	        pw.println("<input type= 'submit' value='Login'>");
	        pw.println("</form>");
	        pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(user.equalsIgnoreCase("csyun") && pass.equalsIgnoreCase("abcd")) {
			HttpSession session=request.getSession();
			session.setAttribute("username",user);
			response.sendRedirect("Members");
		} else {
			response.sendRedirect("Login");
			
		}
	}
}
