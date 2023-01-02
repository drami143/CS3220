package controller.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config) throws ServletException {
    	
        super.init(config);
        
        List<Question> question = new ArrayList<>();

        try {
        	Scanner sc  = new Scanner(new File (getServletContext().getRealPath("/WEB-INF/DrivingTest.txt")));
        	
        	int c = 0;
            while (sc.hasNextLine()) {
                Question questions = new Question();
                questions.setDescription(sc.nextLine());
                questions.setAnswerA(sc.nextLine());
                questions.setAnswerB(sc.nextLine());
                questions.setAnswerC(sc.nextLine());
                c++;
                questions.setCorrectAnswer(Integer.parseInt(sc.nextLine()));
                
                if(c !=10) {
                	sc.next();
                }
                question.add(questions);
              
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new ServletException(e);
        }
       
        getServletContext().setAttribute("question", question);
    }
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Question> question = (List<Question>) getServletContext().getAttribute("question");
    	int c;
    	
    	Object o = request.getSession().getAttribute("c");
    	c = (o == null) ? 0 : (Integer) o;
    	
    	request.setAttribute("questions", question.get(c));
    	request.getSession().setAttribute("c", (c + 1) % question.size());
    	request.getRequestDispatcher("/DrivingQuestions.jsp").forward(request, response);

    }

}
































