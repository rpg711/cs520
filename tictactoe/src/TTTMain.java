// main class, does initial setup of model, view, controller
public class TTTMain {
	public static void main(String[] args){
		TTTC controller = new TTTC();
		TTTV view = new TTTV(controller);
		TTTM model = new TTTM(view);
		
		controller.setModel(model);
		
		view.gui.setVisible(true);
	}
}
