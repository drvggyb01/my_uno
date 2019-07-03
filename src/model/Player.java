/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Georgiy
 *
 */
public class Player {

	String name;
	ArrayList<Card> myDeck;
	int points;
	
	public Player() {

	}

	public Player(String n, ArrayList<Card> d) {
		name = n;
		myDeck = d;
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
}
