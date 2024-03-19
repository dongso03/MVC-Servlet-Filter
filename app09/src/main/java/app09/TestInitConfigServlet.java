package app09;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class TestInitConfigServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		String initParameter = config.getInitParameter("configName");
		System.out.println("초기화 시 사용가능한 설정값: " + initParameter);
		//서블릿 생성시기 조절로 db드라이버 설정 등을 할수있다
//		try {
//			Class.forName(config.getInitParameter("driverName"));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
