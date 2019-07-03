/**
 * 
 */
package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import model.Deck;
import model.Player;

/**
 * @author Georgiy
 *
 */
public class Session extends JFrame{

	Table table;
	Deck deck;
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	
	public Session(String n1, String n2, String n3, String n4) {
		super("UNO");
		
		deck = new Deck();
		
		p1 = new Player(n1, deck.getFirstHand(), deck);
		p2 = new Player(n2, deck.getFirstHand(), deck);
		p3 = new Player(n3, deck.getFirstHand(), deck);
		p4 = new Player(n4, deck.getFirstHand(), deck);
		
		table = new Table(p1, p2, p3, p4, deck);
		
		getContentPane().add(table);
		table.setLayout(null);
    	getContentPane().setPreferredSize(new Dimension(800, 300));
    	
    	pack();
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
