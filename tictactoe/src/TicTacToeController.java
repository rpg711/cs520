// should contain the business logic can interact with
public interface TicTacToeController {
	// called in the event that a move occurs
	public void moveOccured(TicTacToeMove move);
	
	// resets the model
	public void reset();
	
	public void setModel(TicTacToeModel model);
	
	public String checkWinner();
}
