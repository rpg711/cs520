import java.awt.event.ActionListener;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class Testcases {    
    @Test
    public void testControllerUpdatePlayer1Wins() {
    	TicTacToeController controller = new TTTC();
		ActionListener controller_listener = new ControllerActionListenerAdapter(controller);
		TicTacToeView view = new TTTV(controller_listener);
		TicTacToeModel model = new TTTM(view);
		
		controller.setModel(model);
		
		controller.moveOccured(new TicTacToeMove(0,0));
		controller.moveOccured(new TicTacToeMove(1,0));
		controller.moveOccured(new TicTacToeMove(0,1));
		controller.moveOccured(new TicTacToeMove(2,0));
		controller.moveOccured(new TicTacToeMove(0,2));
		
		assertEquals(controller.checkWinner(), "1"); 
    }
    
    @Test
    public void testControllerUpdatePlayer2Wins() {
    	TicTacToeController controller = new TTTC();
		ActionListener controller_listener = new ControllerActionListenerAdapter(controller);
		TicTacToeView view = new TTTV(controller_listener);
		TicTacToeModel model = new TTTM(view);
		
		controller.setModel(model);
		
		controller.moveOccured(new TicTacToeMove(1,0));
		controller.moveOccured(new TicTacToeMove(0,0));
		controller.moveOccured(new TicTacToeMove(2,0));
		controller.moveOccured(new TicTacToeMove(0,1));
		controller.moveOccured(new TicTacToeMove(1,1));
		controller.moveOccured(new TicTacToeMove(0,2));
		
		assertEquals(controller.checkWinner(), "2"); 
    }
    
    @Test
    public void testControllerUpdateNobodyWins() {
    	TicTacToeController controller = new TTTC();
		ActionListener controller_listener = new ControllerActionListenerAdapter(controller);
		TicTacToeView view = new TTTV(controller_listener);
		TicTacToeModel model = new TTTM(view);
		
		controller.setModel(model);
		
		controller.moveOccured(new TicTacToeMove(0,0));
		controller.moveOccured(new TicTacToeMove(0,1));
		controller.moveOccured(new TicTacToeMove(0,2));
		controller.moveOccured(new TicTacToeMove(1,1));
		controller.moveOccured(new TicTacToeMove(1,0));
		controller.moveOccured(new TicTacToeMove(1,2));
		controller.moveOccured(new TicTacToeMove(2,0));
		controller.moveOccured(new TicTacToeMove(2,1));
		controller.moveOccured(new TicTacToeMove(2,2));
		
		assertEquals("0", controller.checkWinner()); 
    }
    
    @Test(expected = MoveOccurredException.class)
    public void testControllerMoveOccurredError() {
    	TicTacToeController controller = new TTTC();
		ActionListener controller_listener = new ControllerActionListenerAdapter(controller);
		TicTacToeView view = new TTTV(controller_listener);
		TicTacToeModel model = new TTTM(view);
		
		controller.setModel(model);
		
		controller.moveOccured(new TicTacToeMove(0,0));
		controller.moveOccured(new TicTacToeMove(0,0));
    }
    
    @Test
    public void testModelUpdate() {
		TicTacToeView view = new TTTV(null);
		TicTacToeModel model = new TTTM(view);
		
		int[][] mockgrid = new int[][]{{1,1,1},{2,0,2},{2,0,0}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 3);
		model.setData(d);
		int[][] grid = model.getGrid();
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(grid[i][j], mockgrid[i][j]);
			}
		}
    }
    
    @Test
    public void testModelReset() {
		TicTacToeView view = new TTTV(null);
		TicTacToeModel model = new TTTM(view);
		
		// populate with fake data
		
		int[][] mockgrid = new int[][]{{1,1,1},{2,0,2},{2,0,0}};
		
		TTTData d = new TTTData("1", mockgrid, 1, 3);
		model.setData(d);
		int[][] grid = model.getGrid();
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(grid[i][j], mockgrid[i][j]);
			}
		}
		
		// reset the model
		
		model.resetModel();
		
		grid = model.getGrid();
		
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				assertEquals(grid[i][j], 0);
			}
		}
    }
    
    @Test
    public void testViewUpdate() {
    	
    }
}
