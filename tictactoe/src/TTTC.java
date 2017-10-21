
public class TTTC implements TicTacToeController {
	
	TicTacToeModel model;

	@Override
	public void moveOccured(TicTacToeMove move) {
		this.model.makeMove(move);
		model.setWinner(checkWinner());
	}

	@Override
	public void reset() {
		this.model.resetModel();
	}

	@Override
	public void setModel(TicTacToeModel model) {
		this.model = model;
	}

	@Override
	public String checkWinner()
	{
		String winner = "0";
		int grid[][] = model.getGrid();
		// check verticals
		
		if (grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[0][0] != 0)
		{
			winner = Integer.toString(grid[0][0]);
		}
		
		if (grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[0][1] != 0)
		{
			winner = Integer.toString(grid[0][1]);
		}
		
		if (grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[0][2] != 0)
		{
			winner = Integer.toString(grid[0][2]);
		}
		
		// check horizontals
		
		if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][0] != 0)
		{
			winner = Integer.toString(grid[0][0]);
		}
		
		if (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][0] != 0)
		{
			winner = Integer.toString(grid[1][0]);
		}
		
		if (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][0] != 0)
		{
			winner = Integer.toString(grid[2][0]);
		}
		
		// check diagonal down right
		
		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != 0)
		{
			winner = Integer.toString(grid[0][0]);
		}
		
		// check diagonal down left
		
		if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != 0)
		{
			winner = Integer.toString(grid[2][0]);
		}
		
		return winner;
	}
}
