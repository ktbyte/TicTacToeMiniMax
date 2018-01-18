import java.util.List;

/**
 * An interface needed by an AI to play a game of tic tac toe
 * @author user
 *
 */
public interface TicTacToeBoard {
	
	/**
	 * Returns +1 for X wins, -1 for O wins, and 0 for no winner (draw or game continues)
	 */
	public int winner();
	
	/**
	 * Returns the current player, an int, -1 or +1
	 */
	public int getCurrentPlayer();
	
	/**
	 * Returns a new board, where getCurrentPlayer() is the negative of the prior player,
	 * and having placed an X or O on the board (depending on the value of move)
	 */
	public TicTacToeBoard apply(TicTacToeMove move);
	
	/**
	 * Returns a list of available moves for the current player
	 */
	public List<TicTacToeMove> moves();
}