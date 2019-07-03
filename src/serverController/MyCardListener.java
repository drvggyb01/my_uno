/**
 * 
 */
package serverController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Player;
import view.CardView;
import view.InfoPanel;
import view.PlayerPanel;
import view.Table;

/**
 * @author Georgiy
 *
 */
public class MyCardListener implements ActionListener {

	Player player;
	Table table;
	PlayerPanel playerP;
	Rules rules;

	public MyCardListener(Player p, Table t, PlayerPanel pp, Rules r) {
		player = p;
		table = t;
		playerP = pp;
		rules = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardView card = (CardView) e.getSource();
		if (player.getTurn()) {
			if (rules.canPlay(player, card, table.getTopCard())) {
				table.setError("");
				table.setMessage(card.colorToString(), card.getValue(), player);
				player.playCard(card);
				table.setTopCard(card);
				player.setHasDrawn(false);
				table.nextPlayer();
			} else {
				table.setError("You can't play this card");
				player.drawCard();
				playerP.rePaintCards(player.getCards());
			}
			table.setRemaining();
		}else {
			table.setError("It's not your turn");
		}
	}

}
