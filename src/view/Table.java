/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import model.Deck;
import model.Player;

/**
 * @author Georgiy
 *
 */
public class Table extends JPanel{

	private PlayerPanel player;
	private Deck deck;
	private CardView topCard;
	
	private InfoPanel info;
	
	public Table(Player p1, Deck d) {
		setLayout(new BorderLayout(20, 20));
		
		info = new InfoPanel(p1.getName());
		player = new PlayerPanel(p1);
		deck = d;
		
		topCard = new CardView(deck.getCard());
		
		add(player, BorderLayout.SOUTH);
		add(topCard, BorderLayout.NORTH);
		add(info, BorderLayout.CENTER);
	}
}
