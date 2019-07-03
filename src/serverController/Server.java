/**
 * 
 */
package serverController;

import model.Player;
import view.InfoPanel;

/**
 * @author Georgiy
 *
 */
public class Server {

	Player currentPlayer;
	InfoPanel info;
	
	public Server() {
		
	}
	
	public void setCurrentPlayer(Player p){
		currentPlayer = p;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
}
