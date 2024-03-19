package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "atyhFilter"
		//	, urlPatterns = {"/my","/your"}
				,urlPatterns = "/service/*"
		)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		String auth = (String) session.getAttribute("auth");
		if(auth == null) {
			resp.setStatus(401);
			req.getRequestDispatcher("/WEB-INF/needlogin.jsp").forward(req, resp);
			
		}else {
			chain.doFilter(request, response);
		}
		
	}
	
}
