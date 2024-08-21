package spring.model2.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.model2.service.user.dao.UserDao;
import spring.model2.service.user.vo.UserVO;

//@WebServlet({ "*.do", "/" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
        
    }
    
    
    public void init(ServletConfig sc) throws ServletException {
    	super.init(sc);
    	System.out.println("\n\n==============================");
    	System.out.println("DispatcherServlet의 init() Method");
    	System.out.println("==============================\n");
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("\n==> DispatcherServlet.service() start");
		
		String actionPage = (request.getRequestURI().contains(".do"))? getURI(request.getRequestURI()): request.getRequestURI();
//		String actionPage = getURI(request.getRequestURI());
		System.out.println(":: URL ? = "+request.getRequestURI());
		System.out.println(":: Client 요구사항 ? = "+actionPage);
		
		request.setCharacterEncoding("EUC-KR");
		
		Controller controller = null;
		
		ControllerMapping cm = ControllerMapping.getInstance();
		controller = cm.getController(actionPage);
		
		controller.execute(request, response);
		
		System.out.println("<== DispatcherServlet.service() end\n");
		
	}
	
	private String getURI(String requestURI) {
		
		int start = requestURI.lastIndexOf("/") + 1;
		int end = requestURI.lastIndexOf(".do");
		
		String actionPage = requestURI.substring(start, end);
		
		return actionPage;
	}

}
