package hattari.web.game.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.datamodel.ConnectedUser;
import be.technobel.domain.datamodel.GameLoop;
import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.user.UserRepository;

/**
 * Servlet implementation class GameAction
 * @author André LAGUERRE
 * URL : http://<baseURL>/gameaction
 * methode : POST
 */
public class GameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GameLoop gameloop;
	
	@EJB
	private UserRepository userRep;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
		
		if(gameloop == null) {
			//No Gameloop exists, Create It.
			gameloop = new GameLoop();
		}
		
		String gameAction = request.getParameter("gameAction");
		
		switch (gameAction) {
		case "login":
				//Récupérer le username passé en parametre
				String username = request.getParameter("username");
				
				//Récupérer le nombre de joueurs dans la partie.
				int nbrPlayer = gameloop.getNbrPlayer();
				
				
				if(nbrPlayer < gameloop.getNbrMaxPlayer()) {
					//Le nombre Max de joueurs n'est pas atteint, on incrément ce nombre
					gameloop.setNbrPlayer(nbrPlayer++);
					
					//Récupérer le User de la DB.
					User user = userRep.findByUsername(username);
					
					//Création du Userconnecteé
					ConnectedUser connectedUser = (ConnectedUser) user;
					//Récupération AdresseIP
					connectedUser.setUserIP(request.getRemoteAddr());
					connectedUser.setLogged(true);
					connectedUser.setPlaying(false);
					
					gameloop.addConnectedUser(connectedUser);			
					
					if(nbrPlayer == gameloop.getNbrMaxPlayer()) {
						gameloop.setPoolPlayerFull(true);
					}
				} else {
					if(!gameloop.isPoolPlayerFull()) {
						gameloop.setPoolPlayerFull(true);
					}
				}
				
				getServletContext().setAttribute("gameloop", gameloop);
				
				request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
			break;
			
		case "initGame":
			
			break;
			
		case "turnClue":
			
			break;
			
		case "firstPlay":
			
			break;
			
		case "accuse":
			
			break;	

		default:
			break;
		}
		
	}

}
