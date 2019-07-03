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
	public boolean canPlay(Player player, CardView playedCard, Card topCard) {
		
		if(topCard.getColor()==playedCard.toCard().getColor()) {
			return true;
		}
		else if(topCard.getValue()==playedCard.toCard().getValue()) {
			return true;
		}
		else if(playedCard.toCard().getType()=="Wild") {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean canPlay(Player player, Card playedCard, Card topCard) {
		
		if(topCard.getColor()==playedCard.getColor()) {
			return true;
		}
		else if(topCard.getValue()==playedCard.getValue()) {
			return true;
		}
		else if(playedCard.getType()=="Wild") {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean canDraw(Player player, Card topCard) {
		boolean abelToPlay=false;
		for(Card card : player.getCards()) {
			if(canPlay(player, card, topCard)) {
				abelToPlay=true;
			}
		}
		if(player.hasDrawn()==true) {
			abelToPlay=false;
		}
		return abelToPlay;
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
