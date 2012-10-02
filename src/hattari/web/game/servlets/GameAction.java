package hattari.web.game.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.datamodel.ConnectedUser;
import be.technobel.domain.datamodel.GameLoop;
import be.technobel.domain.datamodel.GameState;
import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.user.UserRepository;
import be.technobel.services.interfaces.ActionGameInterface;

/**
 * Servlet implementation class GameAction
 * @author André LAGUERRE
 * URL : http://<baseURL>/gameaction
 * methode : POST
 */
public class GameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GameLoop gameloop;
	int i; //un compteur quelconque...
	
	@EJB
	private UserRepository userRep;
	@EJB(beanName="actionGame")
	private ActionGameInterface actionGameRep;
       
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
					//Le nombre Max de joueurs n'est pas atteint,
					
					//Récupérer le User de la DB.
					User user = userRep.findByUsername(username);
					String userIP = request.getRemoteAddr();
					
					//Vérifier si le user est déjà dans la Liste
					if(!gameloop.isUserInList(userIP)) {
						//on incrément le nombre de joueurs
						gameloop.setNbrPlayer(nbrPlayer++);				
						
						//Création du Userconnecteé
						ConnectedUser connectedUser = new ConnectedUser();
						connectedUser = (ConnectedUser) user;
						//Récupération AdresseIP
						connectedUser.setUserIP(request.getRemoteAddr());
						connectedUser.setLogged(true);
						connectedUser.setPlaying(false);
						connectedUser.setWaitingInit(false);
						connectedUser.setWaitingTurnClue(false);
						
						gameloop.addConnectedUser(connectedUser);			
						
						if(nbrPlayer == gameloop.getNbrMaxPlayer()) {
							gameloop.setPoolPlayerFull(true);
							request.setAttribute("poolPlayerFull", true);
						}
					} else {
						//Le playser n'est pas dans la liste, on n'a rien ajouté donc le Pool n'a pas changé.
						request.setAttribute("poolPlayerFull", false);
					}
				} else {
					//Le nombre max de player est atteint
					if(!gameloop.isPoolPlayerFull()) {
						gameloop.setPoolPlayerFull(true);
						request.setAttribute("poolPlayerFull", true);
					}
				}
				
				//Setting parameters for next action
				request.setAttribute("gameState", null);
				request.setAttribute("gameInitialized", false);
				request.setAttribute("isTurnClue", false);
				request.setAttribute("gameAction", "waitinit");
				getServletContext().setAttribute("gameloop", gameloop);
				
				request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
			break;
			
		case "waitinit" :
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
			
			if(gameloop.isPoolPlayerFull()) {
				//Setting parameters for next action
				request.setAttribute("poolPlayerFull", true);
				request.setAttribute("gameAction", "initGame");
				request.setAttribute("gameState", null);
				request.setAttribute("gameInitialized", false);
				request.setAttribute("isTurnClue", false);
			} else {
				//Setting parameters for next action
				request.setAttribute("poolPlayerFull", false);
				request.setAttribute("gameAction", "waitinit");
				request.setAttribute("gameState", null);
				request.setAttribute("gameInitialized", false);
				request.setAttribute("isTurnClue", false);
			}
			
			request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
			break;
			
		case "initGame" :
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
			List<User> userListe = new ArrayList<User>();
			for(User user : gameloop.getConnectedUsers()) {
				userListe.add(user);
			}
			actionGameRep.intializeGame(userListe);
			GameState gameState = actionGameRep.getGamestate();
			
			gameloop.setInitialized(true);
			
			//Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", false);
			request.setAttribute("gameAction", "waitturn");
			break;
			
		case "waitturn" :
			
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
