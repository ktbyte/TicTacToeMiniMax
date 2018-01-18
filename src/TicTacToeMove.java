
/**
 * A tic-tac-toe move consists of the placement of a player: +1 for X, -1 for O
 * into a position on a 3 by 3 matrix with 3 rows and 3 columns
 * @param r row, 0 to 2
 * @param c column, 0 to 2
 * @param p player, -1 or +1
 */
public class TicTacToeMove {
	public TicTacToeMove(int r, int c, int p) {
		row = r; 
		col = c;
		player = p;
	}
	int row, col, player;
	public String toString() {
		return (player == 0 ? '.' : player== 1 ? 'X' : 'O') + " to r="+row+" c="+col;
	}
}
