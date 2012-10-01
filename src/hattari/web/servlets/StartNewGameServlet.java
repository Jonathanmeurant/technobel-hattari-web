package hattari.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.entity.User;


public class StartNewGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");
		
		if (loggedUser!=null){
			doPost(request,response);
		} else {
			String error = "Vous devez être connecté pour accéder à cette page";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");
		
		if (loggedUser==null){
			String error = "Vous devez être connecté pour accéder à cette page";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		request.getSession().setAttribute("username", loggedUser.getUsername());
		request.getRequestDispatcher("/UserHasLogged").forward(request, response);
	}

}
