package spring.base.navigation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.service.domain.User;

//@WebServlet("/ServletSendRedirect")
public class ServletSendRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSendRedirect() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("\n==> ServletSendRedirect.service() start");
		
		request.setAttribute("user01", new User("홍길동", "1111"));
		
		HttpSession session = request.getSession();
		session.setAttribute("user02", new User("이순신", "2222"));
		
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고", "3333"));
		
		response.sendRedirect("02Navigation/view.jsp");
		
		System.out.println("<== ServletSendRedierct.service() end\n");
	}

}

/* 
	response.sendRedirect
	: 새로운 Request로 접근하기 때문에 기존 request가 죽는다
	  따라서 request.getAttribute 값이 없다(Null)
	  + 새로운 Request가 들어가기 때문에 URL도 변경된다.
*/
