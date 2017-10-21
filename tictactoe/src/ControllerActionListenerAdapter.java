import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerActionListenerAdapter implements ActionListener{

	TicTacToeController controller;
	
	public ControllerActionListenerAdapter(TicTacToeController controller)
	{
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("reset"))
			controller.reset();
		else if (e.getActionCommand().contains("make_move"))
		{
			String cmd = e.getActionCommand();
			String tokens[] = cmd.split(",");
			controller.moveOccured(new TicTacToeMove(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
		}
		
	}

}
