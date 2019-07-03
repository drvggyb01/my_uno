/**
 * 
 */
package model;

import java.awt.Color;

/**
 * @author Georgiy
 *
 */
public class Card {

	private Color color;
	private String value;
	private String type;

	public Card() {
	}

	public Card(Color c, String v, String t) {
		color = c;
		value = v;
		type = t;
	}

	public Color getColor() {
		return color;
	}

	public String getValue() {
		return value;
	}

	public String getType() {
		return type;
	}
}
