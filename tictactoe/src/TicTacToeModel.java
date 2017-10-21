// model associations:
// player 1: x
// player 2: y
// winner 1: x
// winner 0: none
// winner 2: y
public interface TicTacToeModel {
	
	// make a move.
	// setWinner() must be subsequently called with the relevant winner(if any) to update the view
	public void makeMove(TicTacToeMove move);
	
	// reset model to default
	public void resetModel();
	
	public int[][] getGrid();
	
	// this method sets the current winner and updates the view
	public void setWinner(String winner);
	
	// sets the data associated with this model, to support loading data from other sources.
	public void setData(TTTData data);
	
	public int movesLeft();
}
