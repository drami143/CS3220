package lab6.servlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionPractice() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Random ran = new Random();
		
		int num1 = ran.nextInt(10);
		int num2 = ran.nextInt(10);
			   
			response.setContentType("text/html");
			
			response.getWriter().print("<html><head><title> Lab 6 </title></head>"
					+ "<h2> CS3220 Lab 6 </h2>" +
					"<div>" + "<form action=AdditionPractice method=post>"
							+ "<label>" + num1 + "</label>" + "&nbsp + &nbsp"
									+ "<label>" + num2 + "</label>" + "&nbsp = &nbsp" 
												+ "<input name=n1 type=hidden value=" + num1+ ">"
														+ "<input name=n2 type=hidden value=" + num2+ ">"
													+ "<input type=text name=ans>"
															+ "<button type=submit> Submit </button>"
																	+ "</form>"
																	+ "</div>"
																	+ "</body>"
																	+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		int a = n1 + n2;
		
		
		if(a == Integer.parseInt(request.getParameter("ans"))) {
			response.getWriter().println("<div>"
					+ "<p>" + n1 + " &nbsp + &nbsp" + n2 + "&nbsp = &nbsp" + a + "</p>"
					+ "<p> Your Answer &nbsp" + request.getParameter("ans") + " &nbsp is correct</p>" 
					+ "<p> <a href=AdditionPractice> Try Again </a> </p>"
					+ "</div>"
					+"</body> </html>");
		} else {
			response.getWriter().println("<div>" 
					  + "<p>" + n1 + "&nbsp + &nbsp" + n2 +  "&nbsp = &nbsp" + a + "</p>"
					  + "<p> Your answer &nbsp" + request.getParameter("ans") + "&nbsp is incorrect</p>"
					  + "<p> <a href=AdditionPractice> Try Again </a> </p>"
					  + "</div>"
					  +"</body> </html>");
		}
		
	}

}
