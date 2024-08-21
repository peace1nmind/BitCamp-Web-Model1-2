package spring.model2.service.user.view;
// W D 

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.model2.control.Controller;
import spring.model2.service.user.vo.UserVO;

public class LogonController implements Controller {

	// Field

	// Constructor

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("\n==> LogonController.execute() start");
		
		HttpSession session = request.getSession();
		
		if (session.isNew() || session.getAttribute("userVO") == null) {
			session.setAttribute("userVO", new UserVO());
		}
		
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		
		String requestPage = "/user/logon.jsp";
		
		if (userVO.isActive()) {
			requestPage = "/user/home.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(requestPage);
		rd.forward(request, response);
		
		System.out.println("<== LogonController.execute() end\n");
		
	}// execute(request, response) end

}
// class end
