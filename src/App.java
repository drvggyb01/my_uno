/**
 * 
 */

import javax.swing.JOptionPane;

import view.StartGUI;

/**
 * @author Georgiy
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] options = new String[] {"PC", "Andere Spieler", "Abbrechen"};
		int response = JOptionPane.showOptionDialog(null, "Gegen wen möchten Sie spielen?", "Auswahl",
    	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    	        null, options, options[0]);

		if(response != 2 && response != -1) {
			StartGUI start = new StartGUI(response);
			start.setVisible(true);
		}
	}

}
