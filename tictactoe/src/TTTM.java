// models a 3x3 tictactoe grid game
public class TTTM implements TicTacToeModel {
	private int grid[][]; // 0 : no move; 1: player 1; 2: player 2;
	private int player;
	private TicTacToeView view;
	private String winner = "0";
	
	public TTTM()
	{
		resetModel();
	}

	@Override
	public void makeMove(TicTacToeMove move) {
		grid[move.getX()][move.getY()] = player;
		
		if (player == 1)
			player = 2;
		else
			player = 1;
	}
	
	public int movesLeft(){
		int temp = this.grid.length * this.grid[0].length;
		for (int i = 0; i < grid.length; i ++)
		{
			for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j] != 0)
					temp --;
			}
		}
		
		return temp;
	}
	
	private void updateView()
	{
		TTTData data = new TTTData(this.winner, this.grid, this.player, movesLeft());
		
		view.update(data);
	}

	@Override
	public void resetModel() {
		this.grid = new int[3][3];
		
		for (int i = 0; i < grid.length; i ++){
			for (int j = 0; j < grid[i].length; j++){
				grid[i][j] = 0;
			}
		}
		
		this.player = 1; // player 1 moves first
		
		updateView();
	}
	
	
	public int[][] getGrid(){
		return grid;
	}

	@Override
	public void setView(TicTacToeView view) {
		this.view = view;
		updateView();
	}

	@Override
	public void setData(TTTData data) {
		this.grid = data.getGrid();
		this.player = data.getPlayer();
		updateView();
	}
	
	@Override
	public void setWinner(String winner) {
		this.winner = winner;
		updateView();
	}

}
