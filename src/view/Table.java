/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

import model.Card;
import model.Deck;
import model.Player;

/**
 * @author Georgiy
 *
 */
public class Table extends JPanel {

	private PlayerPanel playerV;

	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;

	private Deck deck;
	public Card topCard;
	public CardView topCardV;
	public JPanel decks = new JPanel();

	private InfoPanel info;

	public Table(Player p1, Player p2, Player p3, Player p4, Deck d) {
		player1 = p1;
		player2 = p2;
		player3 = p3;
		player4 = p4;

		info = new InfoPanel(player1.getName());
		info.setBounds(10, 11, 320, 100);

		playerV = new PlayerPanel(player1, info, this);
		playerV.setBounds(10, 122, 780, 160);

		deck = d;
		player1.setTurn(true);

		topCard = deck.getFirstCard();
		topCardV = new CardView(topCard);
		topCardV.setBounds(10, 11, 50, 75);
		topCardV.setEnabled(false);
		setLayout(null);
		decks.setBounds(340, 11, 450, 100);
		decks.setLayout(null);

		decks.add(topCardV);
		add(playerV);
		add(decks);
		add(info);
	}

	public void setError(String e) {
		info.setError(e);
	}

	public void setInfo(String i) {
		info.setError(i);
	}

	public void setMessage(String c, String v, Player p) {
		info.setMessage(c, v, p);
	}

	public void setSaidUNO(Player p) {
		info.setSaidUNO(p);
	}

	public void setTopCard(CardView c) {
		topCardV.updateCardView(c.toCard());
	}

	public Card getTopCard() {
		return topCard;
	}

	public void setRemaining() {
		info.setRemaining(deck.getSize());
	}
	
	public void nextPlayer() {
		if (player1.getTurn()) {
			player1.setTurn(false);
			player2.setTurn(true);

			info.setTurn(player2.getName());
			playerV.rePaint(player2);
		} else if (player2.getTurn()) {
			player2.setTurn(false);
			player3.setTurn(true);

			info.setTurn(player3.getName());
			playerV.rePaint(player3);
		} else if (player3.getTurn()) {
			player3.setTurn(false);
			player4.setTurn(true);

			info.setTurn(player4.getName());
			playerV.rePaint(player4);
		} else if (player4.getTurn()) {
			player4.setTurn(false);
			player1.setTurn(true);

			info.setTurn(player1.getName());
			playerV.rePaint(player1);
		}
	}
}
