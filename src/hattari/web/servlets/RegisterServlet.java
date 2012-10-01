package hattari.web.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.user.UserRepository;

import hattari.web.util.Validation;

public class RegisterServlet extends HttpServlet {
	
	@EJB (beanName="UserManagerBean")
	private UserRepository userRepository;
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		Validation validation = new Validation();
		
		boolean usernameTest = validation.textValidation(username);
		boolean passwordTest = validation.textValidation(password);
		boolean firstnameTest = validation.textValidation(firstname);
		boolean lastnameTest = validation.textValidation(lastname);
		boolean emailTest = validation.emailValidation(email);
		
		if (!usernameTest) {
			request.setAttribute("error", "invalid username");
			response.sendRedirect("register.jsp");
		} else if (!passwordTest) {
			request.setAttribute("error", "invalid password");
			response.sendRedirect("register.jsp");
		} else if (!firstnameTest) {
			request.setAttribute("error", "invalid firstname");
			response.sendRedirect("register.jsp");
		} else if (!lastnameTest) {
			request.setAttribute("error", "invalid lastname");
			response.sendRedirect("register.jsp");
		} else if (!emailTest) {
			request.setAttribute("error", "invalid email");
			response.sendRedirect("register.jsp");
		} 

		User user = new User(username, password, firstname, lastname, email);
		userRepository.save(user);
		
		
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}


}
