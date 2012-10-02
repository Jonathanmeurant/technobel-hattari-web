package hattari.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.datamodel.GameState;
import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.character.CharacterRepository;
import be.technobel.domain.repository.interfaces.user.UserRepository;
import be.technobel.services.interfaces.ActionGameInterface;
import be.technobel.domain.entity.Character;

/**
 * Servlet implementation class TestGame
 */
public class TestGame extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
	@EJB (beanName="actionGame")
	private ActionGameInterface  actionGame;
	
	@EJB
	private UserRepository UserRepository;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter	out= response.getWriter();
		
		List<User> users=UserRepository.findAll();
		actionGame.intializeGame(users);
		GameState gameState=actionGame.getGamestate();	
		User user=gameState.getUser().get((gameState.getCurrentPlayer()));
		out.println("<h1> currentPlayer"+user.getFirstName()+"</h1>");
		for (Character character:gameState.getSuspects()){
			out.println("<h1>character supect "+character.getNumber()+"</h1>");	
		}
		out.println("<h1> victimr"+gameState.getVictim().getNumber()+"</h1>");
		
		out.println("<h1> last selectid"+gameState.getLastSelectedCharacter().getNumber()+"</h1>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
