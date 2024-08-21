package spring.model2.control;
// W D 

import spring.model2.service.user.view.*;

public class ControllerMapping {

	// Field
	private static ControllerMapping controllerMapping;

	// Constructor
	private ControllerMapping() {
	}

	// Method
	public static ControllerMapping getInstance() {

		if (controllerMapping == null) {
			controllerMapping = new ControllerMapping();
		}

		return controllerMapping;

	}// getInstance end

	public Controller getController(String actionPage) {
		
		System.out.println("\n==> ControllerMapping.getController() start");
		
		Controller controller = new LogonController();
		
		if (actionPage.equals("logon")) {
			
		} else if (actionPage.equals("logonAction")) {
			controller = new LogonActionController();
		} else if (actionPage.equals("home")) {
			controller = new HomeController();
		}
		
		System.out.println("<== ControllerMapping.getController() end\n");
		
		return controller;
	}

}
// class end
