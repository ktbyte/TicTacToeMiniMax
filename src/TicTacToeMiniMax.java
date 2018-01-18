import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Assumes that there is a TicTacToeBoard which represents players as +1 for X and -1 for O.
 * This performes recursive descent minimax through an exhaustive search of the entire game tree.
 */
public class TicTacToeMiniMax {

	/**
	 * This method returns whether the current player given a board configuration can win or lose.
	 * For example, if the current player is +1, for X, then this will return -1 if X cannot
	 * possibly win given perfect play by O; 0 for if the best X can do is Tie, and +1 if X can force
	 * a win no matter what O does. Similarly, if current player is -1 for O, then +1 means O is
	 * unable to win, 0 is O can force a Tie, and -1 means O can guarantee a win
	 * @return The best possible outcome for the current player, -1 for O winning, +1 for X winning
	 */
	public static int bestMove(TicTacToeBoard board) { //like winner(), but if there is no winner, then computes winner for children. Returns null if already has a winner
		if(board.winner() != 0) return board.winner();
		List<TicTacToeMove> moves = board.moves();
		if(moves.size() == 0) return 0;
		int out = -board.getCurrentPlayer();//assume 
		for(TicTacToeMove m : moves) {
			TicTacToeBoard nextBoard = board.apply(m);
			int cur = bestMove(nextBoard);  //
			if(cur == board.getCurrentPlayer()) return board.getCurrentPlayer();
			if(Math.abs(cur - board.getCurrentPlayer()) < Math.abs(out - board.getCurrentPlayer())) out = cur;
		}
		return out; //either can win
	}
	
	/**
	 * This method returns the scores of applying different moves on a board given the current
	 * player is trying to perform Mini-Max. In other words, it will return a hashmap of size
	 * equal to the number of possible moves, with -1, 0, or +1 as the values (corresponding
	 * to the return values of int bestMove(TicTacToeBoard board)
	 */
	public static Map<TicTacToeMove,Integer> movesByScore(TicTacToeBoard board) {
		Map<TicTacToeMove,Integer> out = new LinkedHashMap<>();
		for(TicTacToeMove m : board.moves()) {
			TicTacToeBoard nextBoard = board.apply(m);
			int best = bestMove(nextBoard);
			out.put(m, best);
		}
		return out;
	}
	
	/**
	 * This convenience method loops through the moves on a board and returns the move
	 * with the best score for the current player
	 */
	public static TicTacToeMove getBestMove(TicTacToeBoard board) {
		int score = -board.getCurrentPlayer();
		TicTacToeMove best = null;
		for(Entry<TicTacToeMove,Integer> m : movesByScore(board).entrySet()) {
//			System.out.println("If we move "+m.getKey().toString()+", the winner will be "+numToXO(m.getValue()));
			if(best == null || Math.abs(m.getValue() - board.getCurrentPlayer()) < Math.abs(score - board.getCurrentPlayer())) {
				score = m.getValue();
				best = m.getKey();
			}
		}
//		System.out.println("AI determines best move is "+best.toString()+" with winner "+score);
		return best;
	}
	
}
