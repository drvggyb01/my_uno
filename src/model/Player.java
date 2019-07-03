/**
 * 
 */
package model;

import java.util.ArrayList;

import view.CardView;
import view.PlayerPanel;

/**
 * @author Georgiy
 *
 */
public class Player {

	String name;
	ArrayList<Card> myDeck;
	Deck deck;
	int points;
	boolean myTurn = false;
	boolean saidUNO = false;
	boolean hasDrawn = false;
	
	public Player() {

	}

	public Player(String n, ArrayList<Card> d, Deck de) {
		name = n;
		myDeck = d;
		deck = de; 
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getDeckSize() {
		return myDeck.size();
	}
	
	public ArrayList<Card> getCards() {
		return myDeck;
	}
	
	public boolean canPlay(CardView c) {
		if(deck.getTopCard().getColor() == c.getColor() || deck.getTopCard().getValue() == c.getValue() || c.getType() == "Wild") {
			return true;
		}else {
			return false;
		}
	}

	public boolean cantPlay() {
		int playableCards = 0;
		for(Card c : myDeck) {
			if(deck.getTopCard().getColor() == c.getColor() || deck.getTopCard().getValue() == c.getValue() || c.getType() == "Wild") {
				playableCards += 1;
			}
		}
		if(playableCards == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean hasCards() {
		if (myDeck.size() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean hasDrawn() {
		return hasDrawn;
	}
	
	public void setHasDrawn(boolean h) {
		hasDrawn = h;
	}
	
	public boolean canSayUNO() {
		if (myDeck.size() == 2 || myDeck.size() == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void sayUNO() {
		saidUNO = true;
	}
	
	public void drawCard() {
		myDeck.add(deck.getCard());
	}
	
	public void playCard(CardView c) {
		deck.cardPlayed(c.toCard());
		myDeck.remove(c.toCard());
	}
	
	public void setTurn(boolean t) {
		myTurn = t;
	}
	
	public boolean getTurn() {
		return myTurn;
	}
}
