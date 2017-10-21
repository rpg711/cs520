// encapsulates a move made in the game by a player
public class TicTacToeMove {
	private int x;
	private int y;
	
	public TicTacToeMove(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
