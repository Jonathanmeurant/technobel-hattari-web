package hattari.web.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.user.UserRepository;
import be.technobel.services.interfaces.UserManager;

import hattari.web.util.Validation;

public class RegisterServlet extends HttpServlet {
	
	@EJB (beanName="UserManagerBean")
	private UserManager userManager;
	@EJB (beanName="UserRepositoryBean")
	private UserRepository userRepository;
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		User user; 
		User loggedUser = (User)request.getSession().getAttribute("loggedUser");
		String username=null;
		
		if (loggedUser!=null) {
			username = loggedUser.getUsername();
		} else {
			username = request.getParameter("username");
		}

		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String image = request.getParameter("image");
		
		Validation validation = new Validation();
		
		boolean usernameTest = validation.textValidation(username);
		boolean passwordTest = validation.textValidation(password);
		boolean firstnameTest = validation.textValidation(firstname);
		boolean lastnameTest = validation.textValidation(lastname);
		boolean emailTest = validation.emailValidation(email);
		
		if (!usernameTest) {
			request.setAttribute("error", "invalid username");
			request.getRequestDispatcher("register.jsp").forward(request,response);
			return;
		} else if (!passwordTest) {
			request.setAttribute("error", "invalid password");
			request.getRequestDispatcher("register.jsp").forward(request,response);
			return;
		} else if (!firstnameTest) {
			request.setAttribute("error", "invalid firstname");
			request.getRequestDispatcher("register.jsp").forward(request,response);
			return;
		} else if (!lastnameTest) {
			request.setAttribute("error", "invalid lastname");
			request.getRequestDispatcher("register.jsp").forward(request,response);
			return;
		} else if (!emailTest) {
			request.setAttribute("error", "invalid email");
			request.getRequestDispatcher("register.jsp").forward(request,response);
			return;
		} 
		
		if(loggedUser!=null){
			loggedUser.setPassword(password);
			loggedUser.setFirstName(firstname);
			loggedUser.setLastName(lastname);
			loggedUser.setEmail(email);
			loggedUser.setAvatar(image);
			userRepository.save(loggedUser);
			
		} else {
			user = new User(username, password, firstname, lastname, email);
			user.setAvatar(image);
			userManager.register(user);
		}
		
		
		
		
		
		request.getRequestDispatcher("/Index").forward(request,response);
	}


}
