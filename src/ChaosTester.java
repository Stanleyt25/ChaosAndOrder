import java.util.Scanner;

public class ChaosTester extends TicTester {
	
	public static ChaosAndOrderBoard board;
	
	public static void startGame() { // Starts the game by facilitating each player alternating turns and making moves -- also catches if a win condition or stalemate has been made.
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.lineSeparator());
		
		board.reset();
		numMoves = 0;
		
		System.out.println("Order goes first."); // As per the rules, Order goes first
		currentPlayer = 1;
		
		System.out.println("Here's the starting board: ");
		board.printAnyBoard();
		
		while(true) { // Loops indefinitely until a win condition has been met (Order win)  or the board has been completely filled with more 5+ in a row (Chaos win)
			Player playing = playerList[currentPlayer];
			
			System.out.println("Please select X or O:"); // Order and Chaos can choose either symbol to place on the board
			char symbol = scan.next().charAt(0);
			
			while(symbol != 'X' && symbol != 'O') { // Error checking to ensure either 'X' or 'O' is chosen the symbol
				System.out.println("Please try again and select X or O:");
				symbol = scan.next().charAt(0);
			}
			
			playing.setSymbol(symbol);
			
			System.out.println(playing.getName() + ", it's your turn. Input the x coordinate: ");
			int x = scan.nextInt();
			
			System.out.println("Input the y coordinate: ");
			int y = scan.nextInt();
			
			while(x < 0 || y < 0 || x >= board.length || y >= board.length || board.board[x][y] == 'X' || board.board[x][y] == 'O') { // Simple error checking to catch if coordinates override existing symbols or are out-of-bounds
				System.out.println("Invalid input! Try again.");
				
				System.out.println("Input a new x coordinate: "); // Take in an x-coordinate from the user
				x = scan.nextInt();
				
				System.out.println("Input a new y coordinate: "); // Take in a y-coordinate from the user
				y = scan.nextInt();
			}
			
			playing.play(x, y, board); // Places the symbol on the specified coordinates onto the board
			numMoves++; // Don't forget to increment the number of moves
			
			if(board.checkWin(playing, x, y)) { // After each move, check whether a win-condition has been met for Order (5 or more in a row/column/diagonal), if so, break out of the loop
				System.out.println("Order wins!");
				playerList[1].incrementScore();
				break;
			}
			
			if(numMoves == (board.length * board.length)) {; // If the board has been completely filled after 36 moves and no win conditions have been met for Order, Chaos wins!
				System.out.println("Chaos wins!");
				playerList[0].incrementScore();
				break;
			}
			
			currentPlayer++; // Pass the turn to the next player
			
			if(currentPlayer > 1) {
				currentPlayer = 0;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.lineSeparator());
		
		System.out.println("Welcome to Chaos and Order!");
		
		board = new ChaosAndOrderBoard(); 
		numPlayers = 2;
		playerList = new Player[numPlayers];
		

		System.out.println("Please enter Player 1, Chaos's, name:"); // Player 1 will always be Chaos
		String name = scan.next();
			
		playerList[0] = new Player(name, 1, 'X');
		System.out.println("Player 1: " + playerList[0].getName() + " is ready to play as Chaos!");
		
		System.out.println("Please enter Player 2, Order's, name:"); // Player 2 will always be Order
		name = scan.next();
			
		playerList[1] = new Player(name, 2, 'O');
		System.out.println("Player 2: " + playerList[0].getName() + " is ready to play as Order!");
		
		while(playAgain) {
			
			startGame();
		 
			System.out.println("Would you like to play again? (Y/N)");
			char response = scan.next().charAt(0);
			
			if((response == 'Y') || (response == 'y')) { // If players want to play again, the loop calling startGame() keeps running until they change their mind
				playAgain = true;
			}
			
			else if((response == 'N') || (response == 'n')) { // If players don't wanna play again, the loop calling startGame() ends and we're done!
				playAgain = false;
				System.out.println("Thanks for playing!");
				System.out.println("The final score is the following: ");
				for(int i = 0; i < numPlayers; i++) {
					System.out.println(playerList[i].getName() + " won " + playerList[i].getScore() + " times.");
				}
			}
		}
		
		scan.close(); // Don't forget to close the scanner!
	}
	
}
