/**
 * 
 */
package serverController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Card;
import model.Player;
import view.CardView;
import view.InfoPanel;
import view.PlayerPanel;
import view.Table;

/**
 * @author Georgiy
 *
 */
public class MyButtonListener implements ActionListener {

	Player player;
	Table table;
	PlayerPanel playerP;
	Rules rules;

	public MyButtonListener(Player p, Table t, PlayerPanel pp, Rules r) {
		player = p;
		table = t;
		playerP = pp;
		rules = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Card card = table.getTopCard();
		if (player.getTurn()) {
			if (e.getActionCommand() == "Say UNO") {
				if (rules.canSayUNO(player)) {
					table.setError("");
					player.sayUNO();
					table.setSaidUNO(player);
				} else {
					table.setError("You have more than 2 Cards");
					player.drawCard();
					player.drawCard();
					table.nextPlayer();
				}
			} else if (e.getActionCommand() == "Draw") {
				if (rules.canDraw()) {
					table.setError("");
					player.drawCard();
					player.setHasDrawn(true);
					playerP.rePaintCards(player.getCards());
				} else if (!player.cantPlay()) {
					table.setError("You can play a card");
					player.drawCard();
					player.setHasDrawn(false);
					table.nextPlayer();
				} else {
					table.setError("You have drawn a card already");
				}
			}
			table.setRemaining();
		} else {
			table.setError("It's not your turn");
		}
	}
}
