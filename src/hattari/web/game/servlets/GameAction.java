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
	String username;
	User user;
	String userIP;
	GameState gameState;
	
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
				username = request.getParameter("username");
				
				//Récupérer le nombre de joueurs dans la partie.
				int nbrPlayer = gameloop.getNbrPlayer();
				
				
				if(nbrPlayer < gameloop.getNbrMaxPlayer()) {
					//Le nombre Max de joueurs n'est pas atteint,
					
					//Récupérer le User de la DB.
					user = userRep.findByUsername(username);
					userIP = request.getRemoteAddr();
					
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
			
			getServletContext().setAttribute("gameloop", gameloop);
			
			request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
			break;
			
		case "initGame" :
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
			
			if(!gameloop.isInitialized()) {
				//reconstitution de la liste des user
				List<User> userListe = new ArrayList<User>();
				for(User user : gameloop.getConnectedUsers()) {
					userListe.add(user);
				}
				
				//initialisation du Jeu
				actionGameRep.intializeGame(userListe);
				
				gameloop.setInitialized(true);
			}
			
			//récupération du GameState
			gameState = actionGameRep.getGamestate();
			
			//Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", false);
			request.setAttribute("gameAction", "waitturn");
			
			getServletContext().setAttribute("gameloop", gameloop);
			
			request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
			break;
			
		case "waitturn" :
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
			
			//Récupérer le username passé en parametre
			username = request.getParameter("username");
			
			//Récupérer le User de la DB.
			user = userRep.findByUsername(username);
			userIP = request.getRemoteAddr();
			
			int nbrWaitToTurnClue = gameloop.getNbrWaitToTurnClue();
			
			if(nbrWaitToTurnClue < gameloop.getNbrMaxPlayer()){
				//Le nombre de joueurs en attente est inférieur au nombre Max de joueurs, on attend encore des joueur à venir en attente.
				if(!gameloop.isUserWaitingTurn(userIP)) {
					//Le user n'est pas encore en attente, l'ajouter dans la liste
					gameloop.addUserListIpWaitTurn(userIP);
					//Incrémenter le noimbre de joueurs en attente
					gameloop.setNbrWaitToTurnClue(nbrWaitToTurnClue++);
					
					if(nbrWaitToTurnClue == gameloop.getNbrMaxPlayer()) {
						//Tous les joueurs sont en attente !
						request.setAttribute("gameAction", "turnclue");
					} else {
						//tous ne sont pas encore en attente
						request.setAttribute("gameAction", "waitturn");
					}
				} else {
					//Le joueur est déjà en attente mais tous les joueurs ne sont pas encore en attente non plus
					request.setAttribute("gameAction", "waitturn");
				}
			} else {
				//Tous les joureurs sont en attente !
				request.setAttribute("gameAction", "turnclue");
			}
			
			//récupération du GameState
			gameState = actionGameRep.getGamestate();
			
			//Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", false);
			
			getServletContext().setAttribute("gameloop", gameloop);
			request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
			break;
			
		case "turnClue":
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
			
			if(!gameloop.isTurnClue()) {
				//Le turnclue n'as pas encore été enregistré !
				
				actionGameRep.turnClue();
				gameloop.setTurnClue(true);
			}
			
			//récupération du GameState
			gameState = actionGameRep.getGamestate();
			
			//Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", true);
			request.setAttribute("gameAction", "firstPlayer");
			
			getServletContext().setAttribute("gameloop", gameloop);
			
			request.getRequestDispatcher("waitingtostartgame.jsp").forward(request, response);
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
