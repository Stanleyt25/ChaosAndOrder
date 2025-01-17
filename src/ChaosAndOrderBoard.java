
public class ChaosAndOrderBoard extends TicTacToeBoard {
	
	public ChaosAndOrderBoard() { // Constrcutor #1: Sets the board size to 6x6 as per rules of Chaos and Order
		setBoardSize(6, 6);
		length = 6;
	}
	
	public boolean checkRow(char c, int row) { // INPUT: a player's symbol and a row index, OUTPUT: true if a row (of a specified index) has 5 or more consecutive matching symbols and false otherwise
		int inARow = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[row][i] == c) {
				inARow++;
				if(inARow >= 5) {
					break;
				}
			}
			else {
				inARow = 0;
			}
		}
		return (inARow >= 5);
	}
	
	public boolean checkColumn(char c, int col) { // INPUT: a player's symbol and a column index, OUTPUT: true if a column (of a specified index) has 5 or more consecutive matching symbols and false otherwise
		int inAColumn = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[i][col] == c) {
				inAColumn++;
				if(inAColumn >= 5) {
					break;
				}
			}
			else {
				inAColumn = 0;
			}
		}
		return (inAColumn >=5);
	}
	
	public boolean checkDiagonals(char c) { // INPUT: a player's symbol, OUTPUT: true any diagonal has 5 or more consecutive matching symbols and false otherwise
		int inADiag1 = 0;
		int inADiag2 = 0;
		int inADiag3 = 0;
		int inADiag4 = 0;
		int inADiag5 = 0;
		int inADiag6 = 0;
		
		for(int i = 0; i < board.length; i++) {
			if(board[i][i] == c) {
				inADiag1++;
				if(inADiag1 >= 5) {
					break;
				}
			}
			else {
				inADiag1 = 0;
			}	
			if(board[i][board.length-1-i] == c) {
				inADiag2++;
				if(inADiag2 >= 5) {
					break;
				}
			}
			else {
				inADiag2 = 0;
			}
		}
		
		for(int i = 0; i < board.length-1; i++) {
			if(board[i][i+1] == c) {
				inADiag3++;
				if(inADiag3 >= 5) {
					break;
				}
			}
			else {
				inADiag3 = 0;
			}
			if(board[i+1][i] == c) {
				inADiag4++;
				if(inADiag4 >= 5) {
					break;
				}
			}
			else {
				inADiag4 = 0;
			}
			if(board[i][board.length-2-i] == c) {
				inADiag5++;
				if(inADiag5 >= 5) {
					break;
				}
			}
			else {
				inADiag5 = 0;
			}
			if(board[i+1][board.length-1-i] == c) {
				inADiag6++;
				if(inADiag6 >= 5) {
					break;
				}
			}
			else {
				inADiag6 = 0;
			}
		}
		return (inADiag1 >= 5 || inADiag2 >= 5 || inADiag3 >= 5 || inADiag4 >= 5 || inADiag5 >= 5 || inADiag6 >= 5);
	}
	
	public boolean checkWin(Player player, int x, int y) { // INPUT: a player, an x-coordinate, and a y-coordinate, OUTPUT: calls the three check helper methods above and returns true if any of the win conditions have been met
		char s = player.getSymbol();
		return (checkRow(s, x) || checkColumn(s, y) || checkDiagonals(s));
	}
}
