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
import be.technobel.domain.entity.Character;

/**
 * Servlet implementation class GameAction
 * 
 * @author Andr� LAGUERRE URL : http://<baseURL>/gameaction methode : POST
 */
public class GameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GameLoop gameloop;		//memorisation des parametres du jeu
	String gameAction;		//A retourner dans TOUTES les requetes
	String username;
	User userLogged;
	User user;
	String userIP;
	GameState gameState;
	Character character;
	Character suspect;
	int currentPlayer;

	int i; // un compteur quelconque...
	
	@EJB
	private UserRepository userRep;
	@EJB(beanName = "actionGame")
	private ActionGameInterface actionGameRep;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("**GameAction (GET)");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*******GameAction (POST)");
		
		System.out.println("*******get gameLoop");
		gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

		if (gameloop == null) {
			System.out.println("*******Create New gameLoop");
			// No Gameloop exists, Create It.
			gameloop = new GameLoop();
		}

		System.out.println("******R�cup�ration Param gameAction");
		gameAction = request.getParameter("gameAction");
		// si game Action n'est pas pass� en Param, il est pass� en Attribut.
		if (gameAction == null) {
			System.out.println("******R�cup�ration Attribut gameAction");
			gameAction = (String) request.getAttribute("gameAction");
		}

		System.out.println("******R�cup�ration Session userLogged");
		// R�cup�rer le username pass� en session
		userLogged = (User) request.getSession().getAttribute("loggedUser");
		username = userLogged.getUsername();
		System.out.println("******R�cup�ration username "+username);

		// R�cup�rer le User de la DB.
		//user = userRep.findByUsername(username);
		user = userLogged;
		userIP = request.getRemoteAddr();
		System.out.println("******R�cup�ration adressIP"+ userIP);

		System.out.println(userIP + " username : " + username);
		System.out.println(userIP + " gameAction : " + gameAction);

		switch (gameAction) {
		case "joinGame":
			System.out.println(userIP + " joinGame");
			// R�cup�rer le nombre de joueurs dans la partie.
			int nbrPlayer = gameloop.getNbrPlayer();
			
			System.out.println("******R�cup�ration nbrPlayer "+ userIP+" "+nbrPlayer);

			if (nbrPlayer < gameloop.getNbrMaxPlayer()) {
				// Le nombre Max de joueurs n'est pas atteint

				// V�rifier si le user est d�j� dans la Liste
				if (!gameloop.isUserInList(userIP)) {
					System.out.println("******R�cup�ration User NOT in List "+ userIP);
					// on incr�ment le nombre de joueurs
					nbrPlayer++;
					gameloop.setNbrPlayer(nbrPlayer);

					// Cr�ation du Userconnecte�
					ConnectedUser connectedUser = new ConnectedUser(user);
					//connectedUser = (ConnectedUser) user;
					// R�cup�ration AdresseIP
					connectedUser.setUserIP(request.getRemoteAddr());
					connectedUser.setLogged(true);
					connectedUser.setPlaying(false);
					connectedUser.setWaitingInit(false);
					connectedUser.setWaitingTurnClue(false);

					gameloop.addConnectedUser(connectedUser);

					if (nbrPlayer == gameloop.getNbrMaxPlayer()) {
						System.out.println("******nbrPlayer "+nbrPlayer+" == MaxPlayer"+gameloop.getNbrMaxPlayer()+" "+ userIP);
						gameloop.setPoolPlayerFull(true);
						request.setAttribute("poolPlayerFull", true);
						
						System.out.println("******R�cup�ration poolFull "+ userIP);
						
					} else {
						System.out.println("******nbrPlayer "+nbrPlayer+" !== MaxPlayer"+gameloop.getNbrMaxPlayer()+" "+ userIP);
						gameloop.setPoolPlayerFull(false);
						request.setAttribute("poolPlayerFull", true);
						System.out.println("******R�cup�ration poolFull "+ userIP);
					}
						
				} else {
					// Le playser n'est pas dans la liste, on n'a rien ajout�
					// donc le Pool n'a pas chang�.
					System.out.println("******R�cup�ration User in List "+ userIP);
					request.setAttribute("poolPlayerFull", false);
					System.out.println("******R�cup�ration NOT poolFull "+ userIP);
				}
			} else {
				// Le nombre max de player est atteint
				System.out.println("******nbrPlayer "+nbrPlayer+" < MaxPlayer"+gameloop.getNbrMaxPlayer()+" "+ userIP);
				if (!gameloop.isPoolPlayerFull()) {
					gameloop.setPoolPlayerFull(true);
					request.setAttribute("poolPlayerFull", true);
					System.out.println("******R�cup�ration poolFull "+ userIP);
				}
			}

			// Setting parameters for next action
			request.setAttribute("gameState", null);
			request.setAttribute("gameInitialized", false);
			request.setAttribute("isTurnClue", false);
			request.setAttribute("isOnFirstPlay", false);
			request.setAttribute("gameAction", "waitinit");
			System.out.println("******gameAction sent waitinit "+ userIP);
			getServletContext().setAttribute("gameloop", gameloop);

			
			System.out.println("******Forward attente.jsp"+ userIP);
			request.getRequestDispatcher("attente.jsp").forward(request,
					response);
			break;

		case "waitinit":
			System.out.println(userIP + " ENTER In waitinit");
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

			if (gameloop.isPoolPlayerFull()) {
				System.out.println("******waitint poolFull "+ userIP);
				// Setting parameters for next action
				request.setAttribute("poolPlayerFull", true);
				request.setAttribute("gameAction", "initGame");
				request.setAttribute("gameState", null);
				request.setAttribute("gameInitialized", false);
				request.setAttribute("isTurnClue", false);
				request.setAttribute("isOnFirstPlay", false);
				
				getServletContext().setAttribute("gameloop", gameloop);
				
				System.out.println("******sent initGame to attente.jsp + initGame"+ userIP);
				
				request.getRequestDispatcher("attente.jsp").forward(request,
						response);
			} else {
				// Setting parameters for next action
				System.out.println("******waitint NOT poolFull "+ userIP);
				request.setAttribute("poolPlayerFull", false);
				request.setAttribute("gameAction", "waitinit");
				request.setAttribute("gameState", null);
				request.setAttribute("gameInitialized", false);
				request.setAttribute("isTurnClue", false);
				request.setAttribute("isOnFirstPlay", false);
				
				getServletContext().setAttribute("gameloop", gameloop);
				
				System.out.println("******sent waitint to attente.jsp "+ userIP);
				
				request.getRequestDispatcher("attente.jsp").forward(request,
						response);
			}

			break;

		case "initGame":
			System.out.println(userIP + "****************** initGame");
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

			if (!gameloop.isInitialized()) {
				// reconstitution de la liste des user
				List<User> userListe = new ArrayList<User>();
				for (User user : gameloop.getConnectedUsers()) {
					userListe.add(user);
				}

				// initialisation du Jeu
				actionGameRep.intializeGame(userListe);

				gameloop.setInitialized(true);
				
				gameState = actionGameRep.getGamestate();
			}

			synchronized (gameState) {
				request.setAttribute("gameState", gameState);
				System.out.println("******  gameState Victim " + gameState);
			}
			
			System.out.println("******  gameState Victim " );
			
			
			// Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", false);
			request.setAttribute("isOnFirstPlay", false);
			request.setAttribute("gameAction", "waitturn");

			getServletContext().setAttribute("gameloop", gameloop);
			
			System.out.println("******  plateau.jsp "+ userIP);

			request.getRequestDispatcher("plateau.jsp").forward(request,response);
			break;

		case "waitturn":
			System.out.println(userIP + " waittrun");
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

			int nbrWaitToTurnClue = gameloop.getNbrWaitToTurnClue();

			if (nbrWaitToTurnClue < gameloop.getNbrMaxPlayer()) {
				// Le nombre de joueurs en attente est inf�rieur au nombre Max
				// de joueurs, on attend encore des joueur � venir en attente.
				if (!gameloop.isUserWaitingTurn(userIP)) {
					// Le user n'est pas encore en attente, l'ajouter dans la
					// liste
					gameloop.addUserListIpWaitTurn(userIP);
					// Incr�menter le noimbre de joueurs en attente
					nbrWaitToTurnClue++;
					gameloop.setNbrWaitToTurnClue(nbrWaitToTurnClue);

					if (nbrWaitToTurnClue == gameloop.getNbrMaxPlayer()) {
						// Tous les joueurs sont en attente !
						request.setAttribute("gameAction", "turnClue");
					} else {
						// tous ne sont pas encore en attente
						request.setAttribute("gameAction", "waitturn");
					}
				} else {
					// Le joueur est d�j� en attente mais tous les joueurs ne
					// sont pas encore en attente non plus
					request.setAttribute("gameAction", "waitturn");
				}
			} else {
				// Tous les joureurs sont en attente !
				request.setAttribute("gameAction", "turnClue");
			}

			// r�cup�ration du GameState
			gameState = actionGameRep.getGamestate();

			// Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", false);
			request.setAttribute("isOnFirstPlay", false);

			getServletContext().setAttribute("gameloop", gameloop);
			request.getRequestDispatcher("plateau.jsp").forward(request,
					response);
			break;

		case "turnClue":
			System.out.println(userIP + " turnclue");
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

			if (!gameloop.isTurnClue()) {
				// Le turnclue n'as pas encore �t� enregistr� !

				actionGameRep.turnClue();
				gameloop.setTurnClue(true);
			}

			// r�cup�ration du GameState
			gameState = actionGameRep.getGamestate();

			// initialisation du Premier Joeur.
			currentPlayer = 1;
			gameloop.setCurrentPlayer(currentPlayer);

			// Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", true);
			request.setAttribute("isOnFirstPlay", false);
			request.setAttribute("gameAction", "firstPlay");
			request.setAttribute("currentPlayer", currentPlayer);
			request.setAttribute("currentPlayerIP", gameloop.getConnectedUsers().get(currentPlayer).getUserIP());

			getServletContext().setAttribute("gameloop", gameloop);

			request.getRequestDispatcher("plateau.jsp").forward(request,
					response);
			break;

		case "waitEndTurnClue":
			System.out.println(userIP + " waitTurnClue");
			// TODO : when all players has clicked they have view the "witness"
			break;

		case "firstPlay":
			System.out.println(userIP + " firstPlay");
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

			// R�cup�ration du current player
			currentPlayer = gameloop.getCurrentPlayer();

			gameState = actionGameRep.getGamestate();

			// V�rification du current player en fonction de l'adresse IP
			if (userIP.equals(gameloop.getConnectedUsers().get(currentPlayer)
					.getUserIP())) {
				if (!gameloop.isOnFirstPlayer()) {
					// La Methode FirstPlayer n'as pas �t� invoqu�e
					gameloop.getConnectedUsers().get(currentPlayer).setPlaying(true);
					
					// r�cup�rer le "character"
					character = (Character) request.getAttribute("character");
					
					// D�clarer le Joueur
					gameState.setCurrentPlayer(currentPlayer);
					actionGameRep.setGamestate(gameState);
					
					// Invocation de la m�thode
					actionGameRep.firstPlayer(character);
					

					gameloop.setOnFirstPlayer(true);

					request.setAttribute("gameAction", "accuse");
				} else {
					request.setAttribute("gameAction", "accuse");
				}
			} else {
				request.setAttribute("gameAction", "firstPlay");
			}

			gameState = actionGameRep.getGamestate();

			// TODO : Non firstPlayer pass to accusation

			// Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", true);
			request.setAttribute("isOnFirstPlay", true);

			request.setAttribute("currentPlayer", currentPlayer);
			request.setAttribute("currentPlayerIP", gameloop
					.getConnectedUsers().get(currentPlayer).getUserIP());

			getServletContext().setAttribute("gameloop", gameloop);
			request.getRequestDispatcher("plateau.jsp").forward(request,
					response);
			break;

		case "accuse":
			System.out.println(userIP + " accuse");
			gameloop = (GameLoop) getServletContext().getAttribute("gameloop");

			// R�cup�ration du current player
			currentPlayer = gameloop.getCurrentPlayer();

			gameState = actionGameRep.getGamestate();

			// V�rification du current player en fonction de l'adresse IP
			if (userIP.equals(gameloop.getConnectedUsers().get(currentPlayer).getUserIP())) {
				
				//qui joue maintenant
				int lastPlayer = currentPlayer--;
				if(lastPlayer == 0) {
					lastPlayer = gameloop.getNbrMaxPlayer();
				}
				gameloop.getConnectedUsers().get(lastPlayer).setPlaying(true);
				gameloop.getConnectedUsers().get(currentPlayer).setPlaying(true);
				
				// R�cup�rer le suspect
				suspect = (Character) request.getAttribute("character");

				// D�clarer le Joueur
				gameState.setCurrentPlayer(currentPlayer);
				actionGameRep.setGamestate(gameState);
				
				// invoquer la m�thode
				actionGameRep.accusation(suspect);

				currentPlayer++;
				if (currentPlayer > gameloop.getNbrMaxPlayer()) {
					currentPlayer = 1;
				}

				gameloop.setCurrentPlayer(currentPlayer);
			}

			// Setting parameters for next action
			request.setAttribute("poolPlayerFull", true);
			request.setAttribute("gameState", gameState);
			request.setAttribute("gameInitialized", true);
			request.setAttribute("isTurnClue", true);
			request.setAttribute("isOnFirstPlay", true);
			request.setAttribute("gameAction", "accuse");
			request.setAttribute("currentPlayer", currentPlayer);
			request.setAttribute("currentPlayerIP", gameloop
					.getConnectedUsers().get(currentPlayer).getUserIP());
			getServletContext().setAttribute("gameloop", gameloop);
			request.getRequestDispatcher("plateau.jsp").forward(request,
					response);
			break;

		case "endRound":

			break;

		case "newRound":

			break;

		default:
			break;
		}

	}

}
