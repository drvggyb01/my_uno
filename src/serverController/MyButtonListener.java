/**
 * 
 */
package serverController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Player;

/**
 * @author Georgiy
 *
 */
public class MyButtonListener implements ActionListener {

	Server server;
	
	public MyButtonListener(Server s) {
		server = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() ==  "Say UNO") {
			if(server.getCurrentPlayer().getDeckSize() == 2) {
				
			} else{
				
			}
		} else if(e.getActionCommand() ==  "Draw") {
			
		}
	}
}
