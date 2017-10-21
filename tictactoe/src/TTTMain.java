// main class, does initial setup of model, view, controller
public class TTTMain {
	public static void main(String[] args){
		TTTC controller = new TTTC();
		TTTV view = new TTTV(controller);
		TTTM model = new TTTM();
		
		controller.setModel(model);
		model.setView(view);
		
		view.gui.setVisible(true);
	}
}
