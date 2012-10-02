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
	
	@EJB
	private UserRepository userRepository;
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
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
		
		System.out.println(usernameTest);
		System.out.println(passwordTest);
		System.out.println(firstnameTest);
		System.out.println(lastnameTest);
		System.out.println(emailTest);
		
		if (!usernameTest) {
			System.out.println("________________ ERROR 1__________________");
			request.setAttribute("error", "invalid username");
			response.sendRedirect("register.jsp");
		} else if (!passwordTest) {
			System.out.println("________________ ERROR 2_________________");
			request.setAttribute("error", "invalid password");
			response.sendRedirect("register.jsp");
		} else if (!firstnameTest) {
			System.out.println("________________ ERROR 3__________________");
			request.setAttribute("error", "invalid firstname");
			response.sendRedirect("register.jsp");
		} else if (!lastnameTest) {
			System.out.println("________________ ERROR 4__________________");
			request.setAttribute("error", "invalid lastname");
			response.sendRedirect("register.jsp");
		} else if (!emailTest) {
			System.out.println("________________ ERROR 5__________________");
			request.setAttribute("error", "invalid email");
			response.sendRedirect("register.jsp");
		} 

		User user = new User(username, password, firstname, lastname, email);
		user.setAvatar(image);
		userRepository.save(user);
		
		System.out.println("END SAVE");
		
		request.getRequestDispatcher("/Index").forward(request,response);
	}


}
