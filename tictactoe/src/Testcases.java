import java.awt.event.ActionListener;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class Testcases {    
	public class MockModel implements TicTacToeModel
	{
		private int grid [][];
		public MockModel(int[][] grid)
		{
			this.grid = grid;
		}
		
		@Override
		public void makeMove(TicTacToeMove move) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resetModel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int[][] getGrid() {
			return grid;
		}

		@Override
		public void setWinner(String winner) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setData(TTTData data) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int movesLeft() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	public class MockView implements TicTacToeView
	{

		@Override
		public void update(TTTData data) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
    @Test
    public void testControllerUpdatePlayer1Wins() {
    	TTTC controller = new TTTC();
    	
    	int[][] grid = new int[][] {{1,1,1},{0,2,2},{0,0,0}};
    	
		TicTacToeModel model = new MockModel(grid);
		
		controller.setModel(model);
		
		assertEquals("1", controller.checkWinner()); 
    }
    
    @Test
    public void testControllerUpdatePlayer2Wins() {
TTTC controller = new TTTC();
    	
    	int[][] grid = new int[][] {{1,1,0},{2,2,2},{1,0,0}};
    	
		TicTacToeModel model = new MockModel(grid);
		
		controller.setModel(model);
		
		assertEquals("2", controller.checkWinner()); 
    }
    
    @Test
    public void testControllerUpdateNobodyWins() {
    	TTTC controller = new TTTC();
    	
    	int[][] grid = new int[][] {{1,2,1},{2,2,1},{1,1,2}};
    	
		TicTacToeModel model = new MockModel(grid);
		
		controller.setModel(model);
		
		assertEquals("0", controller.checkWinner()); 
    }
    
    @Test(expected = MoveOccurredException.class)
    public void testControllerMoveOccurredError() {
    	TTTC controller = new TTTC();
    	
    	int[][] grid = new int[][] {{1,0,0},{0,0,0},{0,0,0}};
    	
		TicTacToeModel model = new MockModel(grid);
		
		controller.setModel(model);
		
		controller.moveOccured(new TicTacToeMove(0,0));
    }
    
    @Test
    public void testModelUpdate() {
		TicTacToeView view = new MockView();
		TTTM model = new TTTM(view);
		
		int[][] mockgrid = new int[][]{{1,1,1},{2,0,2},{2,0,0}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 3);
		model.setData(d);
		int[][] grid = model.getGrid();
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(mockgrid[i][j], grid[i][j]);
			}
		}
    }
    
    @Test
    public void testModelReset() {
    	TicTacToeView view = new MockView();
		TTTM model = new TTTM(view);
		
		// populate with fake data
		
		int[][] mockgrid = new int[][]{{1,1,1},{2,0,2},{2,0,0}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 3);
		model.setData(d);
		int[][] grid = model.getGrid();
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(mockgrid[i][j], grid[i][j]);
			}
		}
		
		// reset the model
		
		model.resetModel();
		
		grid = model.getGrid();
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(0, grid[i][j]);
			}
		}
    }
    
    @Test
    public void testViewUpdateNegative() {
    	// see if view works with bad data
    	int[][] mockgrid = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 3);
		
		TTTV view = new TTTV(null);
		
		view.update(d);
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(view.blocks[i][j].getText(), "X");
			}
		}
		
		assertEquals("Player 1 wins!", view.playerturn.getText());
    }
    
    @Test
    public void testViewUpdateSimple() {
    	// see if view works with regular data
    	int[][] mockgrid = new int[][]{{1,1,1},{0,2,2},{0,0,0}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 4);
		
		TTTV view = new TTTV(null);
		
		view.update(d);
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				switch(mockgrid[i][j]){
				case 0:
					assertEquals("", view.blocks[i][j].getText());
					break;
				case 1:
					assertEquals("X", view.blocks[i][j].getText());
					break;
				case 2:
					assertEquals("O", view.blocks[i][j].getText());
					break;
				}
				
			}
		}
		
		assertEquals("Player 1 wins!", view.playerturn.getText());
    }
    
    @Test
    public void testViewReset() {
    	// populate with some data
    	int[][] mockgrid = new int[][]{{1,1,1},{0,2,2},{0,0,0}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 4);
		
		TTTV view = new TTTV(null);
		
		view.update(d);
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				switch(mockgrid[i][j]){
				case 0:
					assertEquals("", view.blocks[i][j].getText());
					break;
				case 1:
					assertEquals("X", view.blocks[i][j].getText());
					break;
				case 2:
					assertEquals("O", view.blocks[i][j].getText());
					break;
				}
				
			}
		}
		
		assertEquals("Player 1 wins!", view.playerturn.getText());
		
		mockgrid = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
		d = new TTTData("0", mockgrid, 1, 9);
		
		view.update(d);
		
		assertEquals("Player 1 to play 'X'", view.playerturn.getText());
    }
}
