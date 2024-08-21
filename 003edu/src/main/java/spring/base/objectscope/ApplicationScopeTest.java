package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/SessionScopeTest")
public class ApplicationScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ApplicationScopeTest() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();
		
		Integer count = (Integer) application.getAttribute("count");
		
		if (count == null) {
			out.println(":: 해당 페이지 1 번째 출력 ::");
			application.setAttribute("count", 1);
			
		} else {
			int changeCount = count.intValue() + 1;
			out.println(":: 해당 페이지 "+changeCount+" 번째 출력 ::");
			
			application.setAttribute("count", changeCount);
		}

	}// service end

}// class end
