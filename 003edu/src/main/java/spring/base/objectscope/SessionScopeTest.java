package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/SessionScopeTest")
public class SessionScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionScopeTest() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		
		Integer count = (Integer) session.getAttribute("count");
		
		if (count == null) {
			out.println(":: Browser 켜고 1 번째 방문 ::");
			session.setAttribute("count", 1);
			
		} else {
			int changeCount = count.intValue() + 1;
			out.println(":: Browser 켜고 "+changeCount+" 번째 방문 ::");
			
			session.setAttribute("count", changeCount);
		}

	}// service end

}// class end
