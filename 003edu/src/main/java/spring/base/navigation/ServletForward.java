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

//@WebServlet("/ServletForward")
public class ServletForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletForward() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("\n==> ServletForward.service() start");
		
		request.setAttribute("user01", new User("홍길동", "1111"));
		
		HttpSession session = request.getSession();
		session.setAttribute("user02", new User("이순신", "2222"));
		
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고", "3333"));
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/02Navigation/view.jsp");
		rd.forward(request, response);
		
		System.out.println("<== ServletForward.service() end\n");
	}

}

/*
 	forward
 	: RequestDispatcher에 의해서 기존 request와 response가 전달된다.
 	  request가 그대로 살아있기 때문에 request object scope가 가능하다
 	  + request의 변화가 없기 때문에 URL도 변화가 없다.
*/ 

