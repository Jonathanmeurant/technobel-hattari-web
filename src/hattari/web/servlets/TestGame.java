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
import be.technobel.domain.entity.Chips;
import be.technobel.domain.entity.User;
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
        
        @EJB (beanName="UserRepositoryBean")
        private UserRepository UserRepository;
        
        
        
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 
                response.setContentType("text/html");
                PrintWriter   out= response.getWriter();
                GameState gameState=actionGame.getGamestate();  
           
                List<User> users=UserRepository.findAll();
                out.println("user  +++++"+users);
                out.println("<h1>+++++++++++++++++++++intializeGame+++++++++++++++++++++++++</h1>");
                actionGame.intializeGame(users);
                gameState=actionGame.getGamestate();
                this.aff(out, users,gameState);
                out.println("<h1>+++++++++++++++++++++turnClue()+++++++++++++++++++++++++</h1>");
                actionGame.turnClue();
                gameState=actionGame.getGamestate();
                this.aff(out, users,gameState);
                out.println("<h1>+++++++++++++++++++++firstPlayer()+++++++++++++++++++++++++</h1>");
                actionGame.firstPlayer(gameState.getSuspects().get(1));
                gameState=actionGame.getGamestate();
                out.println("<h1>+++++++++++++++++++++firstPlayer()+++++++++++++++++++++++++</h1>");
                actionGame.accusation(gameState.getSuspects().get(2));
                gameState=actionGame.getGamestate();
                
                this.aff(out, users,gameState);
                
                
                
                
        }

        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	  
        	  
        }
        
        
       public void aff(PrintWriter out, List<User> users, GameState gameState) {
           
           
    	   
           User user=gameState.getUser().get((gameState.getCurrentPlayer()));
           out.println("<h1> currentPlayer"+user.getFirstName()+"</h1>");
         
           for (Character character:gameState.getSuspects()){
                   out.println("<h1>character supect "+character.getNumber()+"</h1>");     
           }
           out.println("<h1> victimr"+gameState.getVictim().getNumber()+"</h1>");
           
           for (User ouser:users){
           	 out.println("<h1>user "+ouser.getFirstName() +" characht "+ouser.getClue().getNumber()+"</h1>");	
        	 out.println("<h1>user jeton "+ouser.getFirstName() +"</h1>");
        	 for (Chips chip:ouser.getChips()){
        		 out.println("<h1>user jeton "+chip.getName()+" reverse "+chip.getReversed()+"</h1>"+chip);
        		 
        	 }
           }
           
           System.out.println("LastSelectedCharacter "+gameState.getLastSelectedCharacter());
           out.println("<h1>LastSelectedCharacter "+gameState.getLastSelectedCharacter()+"</h1>");
         
           
		
       } 
        
}