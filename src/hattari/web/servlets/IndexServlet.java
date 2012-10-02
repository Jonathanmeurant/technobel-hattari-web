package hattari.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.entity.User;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");
		
		if(loggedUser!=null) {
			request.getRequestDispatcher("/accueil.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
