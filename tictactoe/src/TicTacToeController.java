// should contain the business logic for tic tac toe
// responds to button events on the view, and manipulates the model in response
public interface TicTacToeController {
	// called in the event that a move occurs
	// should throw a RuntimeException on an illegal move.
	public void moveOccured(TicTacToeMove move);
	
	// resets the model
	public void reset();
	
	public void setModel(TicTacToeModel model);
	
	public String checkWinner();
}
