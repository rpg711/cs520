import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TTTV implements TicTacToeView {
	
	private int player;
    private int movesLeft;
    
    
	public JFrame gui = new JFrame("Tic Tac Toe");
    public JButton[][] blocks = new JButton[3][3];
    public JButton reset = new JButton("Reset");
    public JTextArea playerturn= new JTextArea();

	
	public TTTV(TicTacToeController controller){
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);
        
        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.reset();
            }
        });
        
        for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	int move_x = -1;
                    	int move_y = -1;
                    	
                    	for (int i = 0; i < blocks.length; i++){
                    		for(int j = 0; j < blocks[0].length; j++){
                    			if (e.getSource() == blocks[i][j])
                    			{
                    				move_x = i;
                    				move_y = j;
                    				break;
                    			}
                    		}
                    	}
                    	
                        controller.moveOccured(new TicTacToeMove(move_x, move_y));
                    }
                });
            }
        }
	}

	@Override
	public void update(TTTData data) {
		movesLeft = data.getMovesleft();
		player = data.getPlayer();
		
		// populate new data
		for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
            	if (data.getGrid()[row][column] == 1)
            	{
            		blocks[row][column].setText("X");
            		blocks[row][column].setEnabled(false);
            	}
            	else if (data.getGrid()[row][column] == 2)
            	{
            		blocks[row][column].setText("Y");
            		blocks[row][column].setEnabled(false);
            	}
            }
        }
		
		// set the turn if no winner
		if(data.getWinner().equals("0")){
			if (movesLeft % 2 == 1){
				playerturn.setText("'X': Player 1");
			} else
			{
				playerturn.setText("'O': Player 2");
			}
		}
		else if(data.getWinner().equals("1")){
			playerturn.setText("Player 1 wins!");
		}
		else if (data.getWinner().equals("2")){
			playerturn.setText("Player 2 wins!");
		}
		
		// no winner and no moves left
		if(data.getWinner().equals("0") && movesLeft == 0)
		{
			playerturn.setText("Game ends in a draw");
		}
	}

}