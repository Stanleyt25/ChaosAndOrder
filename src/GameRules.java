
public abstract interface GameRules {
	public abstract boolean checkWin(Player player, int x, int y); // Return true if win, return false if no win condition has been met yet
	public abstract void setBoardSize(int n, int m); // Sets the board size to a specified dimension
}
