import java.util.Scanner;

public class TicTester {
	
	public static int numPlayers; // The number of players
	public static Player[] playerList; // A list containing each player
	public static TicTacToeBoard board; // The board being used for the game
	public static int currentPlayer; // An index tracking the player currently making the move
	public static boolean playAgain = true; // true if the players want to play again at the conclusion of a match, false if not
	public static int numMoves = 0; // A counter keeping track for the number of moves that have been made
	public static int numStalemates = 0; // The number of stalemates (ties)
	
	public static void startGame() { // Starts the game by facilitating each player alternating turns and making moves -- also catches if a win condition or stalemate has been made.
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.lineSeparator());
		
		board.reset();
		numMoves = 0;
		
		System.out.print("Now, who wants to go first?"); // Determines who goes first
		for(int i = 1; i <= numPlayers; i++) {
			System.out.print(" Enter " + i + " for Player " + i + ". ");
		}
		
		currentPlayer = scan.nextInt();
		
		System.out.println("Here's the starting board: "); // Prints the starting, empty board
		board.printAnyBoard();
		
		while(true) { // Loops indefinitely until a win condition or stalemate has been met 
			Player playing = playerList[currentPlayer-1];
			
			System.out.println(playing.getName() + ", it's your turn. Input the x coordinate: "); // Take an x-coordinate
			int x = scan.nextInt();
			 
			System.out.println("Input the y coordinate: "); // Take a y-coordinate
			int y = scan.nextInt();
			
			while(x < 0 || y < 0 || x >= board.length || y >= board.length || board.board[x][y] == 'X' || board.board[x][y] == 'O') { // Error checking to ensure the coordinates don't overlap with existing markers are in the bounds
				System.out.println("Invalid input! Try again.");
				
				System.out.println("Input a new x coordinate: ");
				x = scan.nextInt();
				
				System.out.println("Input a new y coordinate: ");
				y = scan.nextInt();
			}
			
			playing.play(x, y, board); // Calls the play() method in Player.java to place the marker on the board
			numMoves++;
			
			if(board.checkWin(playing, x, y)) { // After each move is made, checks whether a win condition has been met -- if so, break out of the loop
				System.out.println(playing.getName() + " wins!");
				break;
			}
			
			if(numMoves == (board.length * board.length)) { // Checks whether a stalemate has been reached (board is completely full with no win condition met)
				numStalemates++;
				System.out.println("Stalemate!");
				break;
			}
			
			currentPlayer++; // Passes turn to the next player
			
			if(currentPlayer > numPlayers) {
				currentPlayer = 1;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.lineSeparator());
		
		System.out.println("Welcome to Tic-Tac-Toe!");
		
		System.out.println("Please enter the size of the board: "); // Take in a specified size and initialize the board to that size
		int length = scan.nextInt();
		board = new TicTacToeBoard(length);
		
		System.out.println("Enter the number of players: "); // Keep track of the number of players
		numPlayers = scan.nextInt();
		
		playerList = new Player[numPlayers];
		
		for(int i = 0; i < numPlayers; i++) { // Take in credentials for each player and store players in a list
			System.out.println("Please enter player " + (i+1) + "'s name: ");
			String name = scan.next();
			
			System.out.println("Please select X or O:");
			char symbol = scan.next().charAt(0);
			
			while(symbol != 'X' && symbol != 'O') {
				System.out.println("Please try again and select X or O:");
				symbol = scan.next().charAt(0);
			}
			
			playerList[i] = new Player(name, i+1, symbol);
			System.out.println("Player " + (i+1) + ": " + playerList[i].getName() + " is ready to play as " + playerList[i].getSymbol() + "!");
		}
		
		while(playAgain) { // Loops while the players still want to keep playing after each match
			
			startGame();
		 
			System.out.println("Would you like to play again? (Y/N)");
			char response = scan.next().charAt(0);
			
			if((response == 'Y') || (response == 'y')) {
				playAgain = true;
			}
			
			else if((response == 'N') || (response == 'n')) { // If players do NOT want to play again, the loop ends
				playAgain = false;
				System.out.println("Thanks for playing!");
				System.out.println("The final score is the following: ");
				for(int i = 0; i < numPlayers; i++) {
					System.out.println(playerList[i].getName() + " won " + playerList[i].getScore() + " times.");
				}
				System.out.println("There were " + numStalemates + " stalemates.");
			}
		}
		
		scan.close(); // Don't forget to close the scanner!
	}
	
}
