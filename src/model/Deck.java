/**
 * 
 */
package model;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author Georgiy
 *
 */
public class Deck {
	List<Card> cards;
	Deque<Card> deck;
	Deque<Card> playedCards = new ArrayDeque<Card>();

	ArrayList<Color> colors = new ArrayList<Color>(List.of(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
	
	ArrayList<String> values = new ArrayList<String>(
			List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+2", "Reverse", "Skip"));

	public Deck() {
		cards = new ArrayList<Card>();
		createDeck();
		shuffle();
		deck = new ArrayDeque<Card>(cards);
	}
	
	public void createDeck(){
		for (Color c : colors) {
			for (String v : values) {
				Card card = new Card(c, v, "Normal");
				cards.add(card);
			}
			for (String v : values) {
				if(v != "0") {
					Card card = new Card(c, v, "Normal");
					cards.add(card);
				}
			}

		}
		
		for(int i=0;i<4;i++) {
			Card c1 = new Card(Color.BLACK, "Choose", "Wild");
			Card c2 = new Card(Color.BLACK, "+4", "Wild");
			
			cards.add(c1);
			cards.add(c2);
		}
	}

	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Deque<Card> getDeck(){
		return deck;
	}
	
	public Card getCard(){
		Card c = deck.getFirst();
		deck.remove(c);
		return c;
	}
	
	public Card getFirstCard(){
		Card c = getCard();
		playedCards.addFirst(c);
		return c;
	}
	
	public Card getTopCard() {
		return playedCards.getFirst();
	}
	
	public ArrayList<Card> getFirstHand(){
		ArrayList<Card> firstHand = new ArrayList<Card>();
		for(int i=0;i<7;i++) {
			Card c = deck.getFirst();
			firstHand.add(c);
			deck.remove(c);
		}
		return firstHand;
	}
	
	public void cardPlayed(Card c) {
		playedCards.add(c);
	}
	
	public int getSize() {
		return deck.size();
	}
}
