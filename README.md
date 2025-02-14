## Tic Tac Toe and Other Variants (Order and Chaos)
---------------------------------------------------------------------------
Stanley To

## Files
---------------------------------------------------------------------------
GameRules.java is an abstract interface that outlines two methods that must be included in the Board classes: checkWin() which checks whether the board is in a winning state and setBoardSize() which initializes the board to specified dimensions.
Player.java is an object class which represents each player. It keeps track of their name, player ID (e.g. Player 1 or Player 2), symbol (X or O), and score.

TicTacToeBoard.java is an object class which implements GameRules.java and represents the board as a 2D char array. It contains helpful functions for checking or altering the status of the board: reset() empties the board, checkWin() checks whether a win condition has been met, and printAnyBoard() prints the board.
TicTester.java is a class which takes in user input and calls startGame(), a method in the class, in its main function to play Tic-Tac-Toe.

ChaosAndOrderBoard.java is an object class which extends the TicTacToeBoard class. Its size is restricted to 6x6, and it overwrites the checkWin() and its helper functions due to different win conditions.
ChaosTester.java is a class which takes in user input and calls startGame(), a method in the class, in its main function to play Chaos and Order.

## Notes
---------------------------------------------------------------------------
1. The user input allows for more than 2 players for purposes of scalability, but you should enter '2' for the purposes of Tic-Tac-Toe and Order and Chaos.
2. For placing 'X' and 'O' on the board, the console will ask you to enter an x-coordinate then a y-coordinate. The row and column indices start at 0, and the origin is located at the bottom left corner of the grid.
3. For error-checking, the code handles out-of-bounds errors and attempting to place markers on coordinates that already contain a marker. It assumes the correct data type (integers for coordinates, either 'X' or 'O' for chosen symbols).

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "pa1" after unzipping the files
2. Compile all the files
3. Compile and run TicTester.java to play Tic-Tac-Toe
4. Compile and run ChaosTester.java to play Chaos and Order

## Input/Output Example
---------------------------------------------------------------------------
e.g.:
<pre>
Welcome to Tic-Tac-Toe!
Output: Please enter the size of the board: 
Input: 3
Output: Enter the number of players: 
Input: 2
Output: Please enter player 1's name: 
Input: Alex
Output: Please select X or O:
Input: X
Output: Player 1: Alex is ready to play as X!
Output: Please enter player 2's name: 
Input: Bob
Output: Please select X or O:
Input: O
Output: Player 2: Bob is ready to play as O!
Output: Now, who wants to go first? Enter 1 for Player 1.  Enter 2 for Player 2. 1
Output: Here's the starting board: 
+---+---+---+
|   |   |   | 
+---+---+---+
|   |   |   | 
+---+---+---+
|   |   |   | 
+---+---+---+
Output: Alex, it's your turn. Input the x coordinate: 
Input: 0
Output: Input the y coordinate: 
Input: 0
+---+---+---+
|   |   |   | 
+---+---+---+
|   |   |   | 
+---+---+---+
| X |   |   | 
+---+---+---+
Output: Bob, it's your turn. Input the x coordinate: 
Input: 0
Output: Input the y coordinate: 
Input: 1
+---+---+---+
|   |   |   | 
+---+---+---+
| O |   |   | 
+---+---+---+
| X |   |   | 
+---+---+---+
Output: Alex, it's your turn. Input the x coordinate: 
Input: 1
Output: Input the y coordinate: 
Input: 0
+---+---+---+
|   |   |   | 
+---+---+---+
| O |   |   | 
+---+---+---+
| X | X |   | 
+---+---+---+
Output: Bob, it's your turn. Input the x coordinate: 
Input: 1
Output: Input the y coordinate: 
Input: 1
+---+---+---+
|   |   |   | 
+---+---+---+
| O | O |   | 
+---+---+---+
| X | X |   | 
+---+---+---+
Output: Alex, it's your turn. Input the x coordinate: 
Input: 2
Output: Input the y coordinate: 
Input: 0
+---+---+---+
|   |   |   | 
+---+---+---+
| O | O |   | 
+---+---+---+
| X | X | X | 
+---+---+---+
Output: Alex wins!
Output: Would you like to play again? (Y/N)
Input: N
Output: Thanks for playing!
Output: The final score is the following: 
Output: Alex won 1 times.
Output: Bob won 0 times.
Output: There were 0 stalemates.
</pre>
