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
