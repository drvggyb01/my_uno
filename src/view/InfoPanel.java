/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Georgiy
 *
 */
public class InfoPanel extends JPanel{

	private JLabel turn = new JLabel();
	private JLabel error = new JLabel();
	private JLabel remaining = new JLabel();
	
	public InfoPanel(String name) {
		setLayout(new FlowLayout());
		
		error.setForeground(Color.RED);
		turn.setText(name + "'s Zug");
		remaining.setText("Verbleibende Karten: 108");
		
		add(error);
		add(turn);
		add(remaining);
	}
}
