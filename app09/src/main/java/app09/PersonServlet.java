package app09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonServlet" , urlPatterns = {"/person", "/per","/persons"})
public class PersonServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person p = new Person("길동", 22);
		
		req.setAttribute("person", p);
		req.getRequestDispatcher("/WEB-INF/personList.jsp").forward(req, resp);
	}

	
	
}
