import java.awt.event.ActionListener;

// main class, does initial setup of model, view, controller
public class TTTMain {
	public static void main(String[] args){
		TicTacToeController controller = new TTTC();
		ActionListener controller_listener = new ControllerActionListenerAdapter(controller);
		TicTacToeView view = new TTTV(controller_listener);
		TicTacToeModel model = new TTTM(view);
		
		controller.setModel(model);
	}
}
