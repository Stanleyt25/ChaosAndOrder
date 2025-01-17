public class Player {
	private String name; // The name of the player
	private int playerID; // The ID of the player (e.g. player 1, player 2)
	private char symbol; // The chosen symbol (e.g. 'X' or 'O')
	private int score; // The number of wins the player has
	
	public Player(String n, int ID, char s) { // Constructor for player
		this.name = n;
		this.playerID = ID;
		this.symbol = s;
		this.score = 0;
	}
	
	public String getName() { // Access method for name
		return name;
	}
	
	public int getPlayerID() { // Access method for ID
		return playerID;
	}
	
	public char getSymbol() { // Access method for symbol 
		return symbol;
	}
	
	public int getScore() { // Access method for score
		return score;
	}
	
	public void incrementScore() { // Edit method, increments score (+1)
		score++;
	}
	
	public void setSymbol(char c) { // Edit method, sets symbol as specified char 
		this.symbol = c;
	}
	
	public void play(int x, int y, TicTacToeBoard board) { // INPUT: x-coordinate, y-coordinate, board, OUTPUT: populates specified coordinates with specified character and prints the board onto the console
		board.board[x][y] = symbol;
		board.printAnyBoard();
	}
}
