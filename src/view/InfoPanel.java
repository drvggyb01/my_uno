/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;

/**
 * @author Georgiy
 *
 */
public class InfoPanel extends JPanel{

	private JLabel turn = new JLabel();
	private JLabel message = new JLabel();
	private JLabel error = new JLabel();
	private JLabel remaining = new JLabel();
	private JLabel saidUNO = new JLabel();
	
	public InfoPanel(String name) {
		error.setBounds(10, 75, 300, 14);
		
		error.setForeground(Color.RED);
		turn.setBounds(10, 28, 300, 14);
		turn.setText(name + "'s Turn");
		remaining.setBounds(10, 42, 300, 14);
		remaining.setText("Cards left: 80");
		setLayout(null);
		add(error);
		add(turn);
		add(remaining);
		message.setLocation(10, 14);
		message.setSize(300, 14);
		add(message);
		saidUNO.setLocation(10, 0);
		saidUNO.setSize(300, 14);
		add(saidUNO);
	}
	
	public void setError(String e) {
		error.setText(e);
	}
	
	public void setTurn(String t) {
		turn.setText(t + "'s Turn");
	}
	
	public void setMessage(String c, String v, Player p) {
		message.setText(p.getName() + " played " + c + " " + v);
	}
	
	public void setSaidUNO(Player p) {
		message.setText(p.getName() + " said UNO");
	}
	
	public void setRemaining(int r) {
		remaining.setText("Cards left: " + r);
	}
	
}
