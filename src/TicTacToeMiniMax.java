import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TicTacToeMiniMax {

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
	public static Map<TicTacToeMove,Integer> movesByScore(TicTacToeBoard board) {
		Map<TicTacToeMove,Integer> out = new LinkedHashMap<>();
		for(TicTacToeMove m : board.moves()) {
			TicTacToeBoard nextBoard = board.apply(m);
			int best = bestMove(nextBoard);
			out.put(m, best);
		}
		return out;
	}
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
