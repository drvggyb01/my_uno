/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import model.Card;

/**
 * @author Georgiy
 *
 */
public class CardView extends JButton {

	private Color color;
	private String value;
	private String type;

	public CardView(Card c){
		color = c.getColor();
		value = c.getValue();
		type = c.getType();
		
		if(value == "Reverse") {
			setText("R");
		}else if(value == "Skip"){
			setText("S");
		}else if(value == "Choose"){
			setText("C");
		}else {
			setText(value);
		}
		setLayout(new BorderLayout(20, 20));
		setBackground(color);
		if(color == Color.YELLOW || color == Color.GREEN) {
			setForeground(Color.BLACK);
		}else {
			setForeground(Color.WHITE);
		}
    	setPreferredSize(new Dimension(50, 75));
	}
}
