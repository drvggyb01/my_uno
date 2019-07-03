/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;
import serverController.MyButtonListener;
import model.Card;

/**
 * @author Georgiy
 *
 */
public class PlayerPanel extends JPanel{

	private JPanel pane;
	private JLabel name;
	private JLabel points;
	private JButton sayUNO = new JButton("Say UNO");
	private JButton draw = new JButton("Draw");
	
	private JPanel cards = new JPanel();
	private ArrayList<Card> myDeck;
	
	public PlayerPanel(Player p) {
		pane = new JPanel();
		name = new JLabel("Name " + p.getName());
		points = new JLabel("Punkte " + p.getPoints());
		myDeck = p.getCards();

		setLayout(new BorderLayout(20, 20));
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		pane.add(name);
		pane.add(points);
		pane.add(draw);
		pane.add(sayUNO);

		cards.setLayout(new FlowLayout());
		for (Card c : myDeck) {
			CardView card = new CardView(c);
			cards.add(card);
		}
		
		//sayUNO.addActionListener(new MyButtonListener());
		//draw.addActionListener(new MyButtonListener());
		
		add(cards, BorderLayout.EAST);
		add(pane, BorderLayout.WEST);
	}
}
