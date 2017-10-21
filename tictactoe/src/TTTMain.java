import java.awt.event.ActionListener;

// main class, does initial setup of model, view, controller
public class TTTMain {
	public static void main(String[] args){
		TTTC controller = new TTTC();
		ActionListener controller_listener = new ControllerActionListenerAdapter(controller);
		TTTV view = new TTTV(controller_listener);
		TTTM model = new TTTM(view);
		
		controller.setModel(model);
		
		view.gui.setVisible(true);
	}
}
