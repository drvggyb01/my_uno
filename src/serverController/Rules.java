/**
 * 
 */
package serverController;

import model.*;
import view.*;

/**Manages all the gamerules in one object
 * @author Georgiy
 *
 */
public class Rules {
	
	private int pluscounter=0;
	
	
	public Rules() {
		
	}
	/*
	 * Checks if the player can make a valid play
	 * @param player, topCard, playedCard
	 * @return if the player can play
	 */
	public boolean canPlay(Player player, CardView playedCard, CardView topCard) {
		
		if(topCard.toCard().getColor()==playedCard.toCard().getColor()) {
			return true;
		}
		else if(topCard.toCard().getValue()==playedCard.toCard().getValue()) {
			return true;
		}
		else if(playedCard.toCard().getType()=="Wild") {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean canDraw(Player player, CardView playedCard, CardView topCard) {
		if(!canPlay(player,playedCard, topCard)&&player.hasDrawn()==false) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean canSayUno(Player player) {
		if(player.canSayUNO()) {
			return true;
		}
		else {
			return false;
		}
	}

	
}
