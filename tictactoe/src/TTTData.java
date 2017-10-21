// encapsulates the data associated with a tictactoe move
// this is an immutable object
public class TTTData {
	private String winner; // 0: no winner; 1: player 1; 2: player 2;
	private int grid[][];
	private int player;
	private int movesleft;
	
	public TTTData(String winner, int grid[][], int player, int movesleft)
	{
		this.winner = winner;
		this.player = player;
		this.movesleft = movesleft;
		this.grid = new int[grid.length][];
		
		for (int i = 0; i < grid.length; i ++){
			this.grid[i] = grid[i].clone();
		}
	}
	
	// return a copy of the grid
	public int[][] getGrid(){
		int[][] tempGrid = new int[grid.length][];
		
		for (int i = 0; i < grid.length; i ++){
			tempGrid[i] = grid[i].clone();
		}
		
		return tempGrid;
	}
	
	public int getPlayer(){
		return player;
	}
	
	public String getWinner(){
		return winner;
	}
	
	public int getMovesleft(){
		return movesleft;
	}
}
