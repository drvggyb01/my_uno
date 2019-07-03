/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Georgiy
 *
 */
public class StartGUI extends JFrame{
	JPanel players = new JPanel();
    JLabel player1;
    JLabel player2;
    JLabel player3;
    JLabel player4;
    JTextField nameP1 = new JTextField();
    JTextField nameP2 = new JTextField();
    JTextField nameP3 = new JTextField();
    JTextField nameP4 = new JTextField();
   
    JPanel btnP = new JPanel();
    JLabel error = new JLabel("Geben Sie alle Namen ein!");
    JButton btn = new JButton("Enter");
    
    public StartGUI(int gamemode){      
    	super("Namen");
    	
    	players.setLayout(new GridLayout(4, 2));
    	btnP.setLayout(new BoxLayout(btnP, BoxLayout.Y_AXIS));
    	
    	if(gamemode == 0) {
    		nameP2.setText("PC 1");
    		nameP3.setText("PC 2");
    		nameP4.setText("PC 3");
    	}else {
    		player2 = new JLabel("Name Spieler 2");
        	player3 = new JLabel("Name Spieler 3");
        	player4 = new JLabel("Name Spieler 4");
    	}
    	player1 = new JLabel("Name Spieler 1");
    	
    	error.setForeground(Color.RED);
    	error.setVisible(false);
    	
    	btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(nameP1.getText().isEmpty()) {
					error.setVisible(true);
				}else if(gamemode == 1 && (nameP2.getText().isEmpty() || nameP3.getText().isEmpty() || nameP4.getText().isEmpty())){
					error.setVisible(true);
				}else {
					startSession();
				}
				
			}
    	});

    	players.add(player1);
    	players.add(nameP1);
    	
    	if(gamemode == 0) {
    	}else {
        	players.add(player2);
        	players.add(nameP2);
        	players.add(player3);
        	players.add(nameP3);
        	players.add(player4);
        	players.add(nameP4);
    	}
    	btnP.add(error);
    	btnP.add(btn);
    	
    	getContentPane().add(players, BorderLayout.CENTER);
    	getContentPane().add(btnP, BorderLayout.SOUTH);
    	getContentPane().setPreferredSize(new Dimension(400, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	pack();
        setResizable(false);
    }
    
    private void startSession() {	
    	setVisible(false);
    	Session s = new Session(nameP1.getText(), nameP2.getText(), nameP3.getText(), nameP4.getText());	
    	dispose();
    }
}
