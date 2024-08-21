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
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlServlet() {
        super();
        
    }
    
    
    public void init(ServletConfig sc) throws ServletException {
    	super.init(sc);
    	System.out.println("\n\n==============================");
    	System.out.println("ControlServlet의 init() Method");
    	System.out.println("==============================\n");
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("\n==> ControlServlet.service() start");
		
		String actionPage = (request.getRequestURI().contains(".do"))? getURI(request.getRequestURI()): request.getRequestURI();
//		String actionPage = getURI(request.getRequestURI());
		System.out.println(":: URL ? = "+request.getRequestURI());
		System.out.println(":: Client 요구사항 ? = "+actionPage);
		
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		
		System.out.println("session.isNew()=" + session.isNew());
		
		String requestPage = "/user/logon.jsp";
		
		if (session.isNew() || session.getAttribute("userVO") == null) {
			session.setAttribute("userVO", new UserVO());
			
		}
		
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		System.out.println(userVO);
		
		if (userVO != null && userVO.isActive()) {
			requestPage = "/user/home.jsp";
			
		} else if (actionPage.equals("logon")) {
			
		} else if (actionPage.equals("logonAction")) {
			
			String userId = request.getParameter("userId");
			String userPasswd = request.getParameter("userPasswd");
			
			userVO.setUserId(userId);
			userVO.setUserPasswd(userPasswd);
			new UserDao().getUser(userVO);
			
			if (userVO.isActive()) {
				requestPage = "/user/home.jsp";
			}
			
		} else if (actionPage.equals("home")) {
			
		}
		
		System.out.println(":: 최종 View Page = "+requestPage);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(requestPage);
		rd.forward(request, response);
		
		System.out.println("최종 URL= ");
		System.out.println("<== ControlServlet.service() end\n");
		
	}
	
	private String getURI(String requestURI) {
		
		int start = requestURI.lastIndexOf("/") + 1;
		int end = requestURI.lastIndexOf(".do");
		
		String actionPage = requestURI.substring(start, end);
		
		return actionPage;
	}

}
