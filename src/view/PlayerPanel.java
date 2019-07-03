/**
 * 
 */
package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;
import serverController.MyButtonListener;
import serverController.MyCardListener;
import serverController.Rules;
import model.Card;

/**
 * @author Georgiy
 *
 */
public class PlayerPanel extends JPanel {

	public Player player;
	public Table table;
	public InfoPanel info;
	private Rules rules;
	private JPanel pane;
	private JLabel name;
	private JLabel points;
	private JButton sayUNO = new JButton("Say UNO");
	private JButton draw = new JButton("Draw");
	private MyButtonListener unoListener;
	private MyButtonListener drawListener;
	
	private JPanel cards = new JPanel();
	private ArrayList<Card> myDeck;
	private ArrayList<CardView> myDeckV = new ArrayList<CardView>();
	
	public PlayerPanel(Player p, InfoPanel i, Table t, Rules r) {
		rules = r;
		info = i;
		table = t;
		player = p;
		myDeck = player.getCards();
		
		pane = new JPanel();
		pane.setBounds(10, 11, 780, 56);
		name = new JLabel("Name: " + player.getName());
		name.setBounds(10, 21, 130, 14);
		points = new JLabel("Punkte: " + player.getPoints());
		points.setBounds(232, 21, 159, 14);
		pane.setLayout(null);
		
		pane.add(name);
		pane.add(points);
		draw.setBounds(453, 13, 130, 30);
		pane.add(draw);
		sayUNO.setBounds(640, 13, 130, 30);
		pane.add(sayUNO);
		cards.setBounds(10, 66, 780, 83);
		
		cards.setLayout(new FlowLayout());
		for (Card c : myDeck) {
			CardView card = new CardView(c);
			card.addActionListener(new MyCardListener(player, table, this, rules));
			cards.add(card);
			myDeckV.add(card);
		}
		setLayout(null);
		
		unoListener = new MyButtonListener(player, table, this, rules);		
		drawListener = new MyButtonListener(player, table, this, rules);
		
		sayUNO.addActionListener(unoListener);
		draw.addActionListener(drawListener);
		
		add(cards);
		add(pane);
	}
	
	public void rePaint(Player p) {
		for(CardView c : myDeckV) {
			c.setVisible(false);
		}
		
		player = null;
		myDeck = null;
		
		player = p;
		myDeck = player.getCards();
		
		name.setText("Name: " + player.getName());
		points.setText("Punkte: " + player.getPoints());
		
		for (Card c : myDeck) {
			CardView card = new CardView(c);
			card.addActionListener(new MyCardListener(player, table, this));
			myDeckV.add(card);
			cards.add(card);
		}
		
		sayUNO.removeActionListener(unoListener);
		draw.removeActionListener(drawListener);
		
		unoListener = null;
		drawListener = null;

		unoListener = new MyButtonListener(player, table, this);		
		drawListener = new MyButtonListener(player, table, this);
		
		sayUNO.addActionListener(unoListener);
		draw.addActionListener(drawListener);
	}
	
	public void rePaintCards(ArrayList<Card> d) {
		for(CardView cv : myDeckV) {
			int tru = 0;
			for(Card c : d) {
				if(cv.toCard() == c) {
					tru += 1;
				}
			}
			if(tru == 0){
				cv.setVisible(false);				
			}
		}
		
		for(Card c : d) {
			int tru = 0;
			for(CardView cv : myDeckV) {
				if(cv.toCard() == c) {
					tru += 1;
				}
			}
			if(tru == 0){
				CardView card = new CardView(c);
				card.addActionListener(new MyCardListener(player, table, this));
				myDeckV.add(card);
				cards.add(card);
			}
		}
		/*
		myDeck = null;
		myDeck = d;
		
		for (Card c : myDeck) {
			CardView card = new CardView(c);
			card.addActionListener(new MyCardListener(player, table, this));
			myDeckV.add(card);
			cards.add(card);
		}
		*/
	}
}
