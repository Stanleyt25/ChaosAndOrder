public class TicTacToeBoard implements GameRules {
	
	public char[][] board; // Represents the board as a 2D char array, will contain the X's and O's
	public int length; // The length of the board, as the Tic-Tac-Toe board is n x n
	
	public TicTacToeBoard() { // Constructor #1: Board size defaults to 3x3
		setBoardSize(3, 3);
		length = 3;
	}
	
	public TicTacToeBoard(int a) { // Constructor #2: Board size can be set to any length n to an n x n grid
		setBoardSize(a, a);
		length = a;
	}
	
	public TicTacToeBoard(int a, int b) { // Constructor #3: While the constructor takes two dimensions, they must be equal to enforce a square grid
		if(a != b) {
			System.out.println("Error: Please try again and provide two equal integer values, as the board must be n x n.");
		}
		setBoardSize(a, b);
		length = a;
	}
	
	public void reset() { // Clears the board, called each time the users decide they want to play again once a match has finished
		setBoardSize(board.length, board.length);
	}
	
	public boolean checkRow(char c, int row) { // INPUT: a player's symbol and a row index, OUTPUT: true if a row (of a specified index) has all matching symbols and false otherwise
		boolean temp = true;
		for(int i = 0; i < board.length; i++) {
			if(board[row][i] != c) {
				temp = false;
			}
		}
		return temp;
	}
	
	public boolean checkColumn(char c, int col) { // INPUT: a player's symbol and a column index, OUTPUT: true if a column (of a specified index) has all matching symbols and false otherwise
		boolean temp = true;
		for(int i = 0; i < board.length; i++) {
			if(board[i][col] != c) {
				temp = false;
			}
		}
		return temp;
	}
	
	public boolean checkDiagonals(char c) { // INPUT: a player's symbol, OUTPUT: true if the diagonals of the grid have matching symbols
		boolean temp1 = true; // Tracks top left to bottom right diagonal
		boolean temp2 = true; // Tracks bottom left to top right diagonal
		for(int i = 0; i < board.length; i++) {
			if(board[i][i] != c ) {
				temp2 = false;
			}
			if(board[i][board.length-1-i] != c) {
				temp1 = false;
			}
		}
		return temp1 || temp2;
	}
	
	public boolean checkWin(Player player, int x, int y) { // INPUT: a player, an x-coordinate, and a y-coordinate, OUTPUT: calls the three check helper methods above and returns true if any of the win conditions have been met
		char s = player.getSymbol();
		boolean temp = (checkRow(s, x) || checkColumn(s, y) || checkDiagonals(s));
		if(temp) {
			player.incrementScore();
		}
		
		return temp;
	}
	
	public void printAnyBoard() { // Prints the board's current state in the console
		for(int i = board.length-1; i >= 0; i--) {
			System.out.print("+");
			for(int j = 0; j < board.length; j++) {
				System.out.print("---+");
			}
			System.out.println();
			System.out.print("| ");
			for(int k = 0; k < board.length; k++) {
				if(board[k][i] == 0) {
					System.out.print("  | ");
				}
				else {
					System.out.print(board[k][i] + " | ");
				}
			}
			System.out.println();
		}
		System.out.print("+");
		for(int k = 0; k < board.length; k++) {
			System.out.print("---+"); 	
		}
		System.out.println();
	}
	
	public void setBoardSize(int n, int m) { // INPUT: length (n) and width (m), sets the board size to n x m
		board = new char[n][m];
	}
}
