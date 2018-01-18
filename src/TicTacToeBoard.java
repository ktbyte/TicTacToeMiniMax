import java.util.List;

public interface TicTacToeBoard {
	public int winner();
	public int getCurrentPlayer();
	public TicTacToeBoard apply(TicTacToeMove move);
	public List<TicTacToeMove> moves();
}