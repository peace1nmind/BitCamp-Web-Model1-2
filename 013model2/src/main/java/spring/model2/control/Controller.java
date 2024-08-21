package spring.model2.control;
// W D 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	// Field

	// Method
	public void execute(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException;

}
// class end
