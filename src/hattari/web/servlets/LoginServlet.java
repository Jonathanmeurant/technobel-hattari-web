package hattari.web.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.entity.User;
import be.technobel.services.UserManager;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB (beanName="userejb")
	private UserManager userManager;
	private User loggedUser;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		try {
//			InitialContext context = new InitialContext();
//
//			userServices = (UserServices) context
//					.lookup("HattariEAR/UserServices/local");
//		} catch (NamingException ex) {
//			ex.printStackTrace();
//		}
		String error = null;
		loggedUser = userManager.login(username,password);
		
		if (loggedUser!=null){
			request.getSession().setAttribute("loggedUser", loggedUser);
			request.getRequestDispatcher("/Index").forward(request, response);
		} else{
			error = "Login failed";
			request.setAttribute("error", error);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

}
