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
		
		request.setAttribute("user01", new User("ȫ�浿", "1111"));
		
		HttpSession session = request.getSession();
		session.setAttribute("user02", new User("�̼���", "2222"));
		
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("�庸��", "3333"));
		
		response.sendRedirect("02Navigation/view.jsp");
		
		System.out.println("<== ServletSendRedierct.service() end\n");
	}

}

/* 
	response.sendRedirect
	: ���ο� Request�� �����ϱ� ������ ���� request�� �״´�
	  ���� request.getAttribute ���� ����(Null)
	  + ���ο� Request�� ���� ������ URL�� ����ȴ�.
*/
