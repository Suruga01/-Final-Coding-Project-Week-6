package Week_06_Lab;

import java.util.Scanner;

public class Week06TicTacToeLab {
	static String winner = "";
	static String player = "";

	//
	// Error Checking:
	//			Validate that input is a valid Square Number in the gameBoard (1-9)
	// 
	private static boolean checkInput(String readInput) {
		String[] validInput = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (String letter : validInput) {
			if (readInput.equals(letter)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// Open a Scanner to read User Input to Play the Game
				Scanner in = new Scanner(System.in);
				GameBoard gameBoard = new GameBoard();
				// Initialize the gameBoard, AND the necessary variables.
				gameBoard.initialize();
				int squareNumber;
				int allSquares = 1;
				player = "X";
				
				// Print out Game Information & the initial game board
				System.out.println();
				System.out.println("-------------------------");
				System.out.println(" Welcome to Tic Tac Toe!");
				System.out.println("    First Turn:  X ");
				System.out.println("-------------------------");
				System.out.println();
				
				// Print out the gameBoard
				gameBoard.display();
				
				// Game Loop -- keeps running until a winner or draw is declared!
				while (winner.equals("") && (allSquares <= 9)) {
					// To enter the X Or O at the exact place on gameBoard.
					System.out.println(player + "'s turn -- enter a number designating the square to place an " + player + " in:");
					String readInput = in.nextLine();
					if (checkInput(readInput)) {
						squareNumber = Integer.valueOf(readInput);
						if (squareNumber > 0 && squareNumber <= 9) {			
							if (gameBoard.ifValidSetSquare(squareNumber, readInput, player)) {
								if (player.equals("X")) {
									player = "O";
								} else {
									player = "X";
								}	
								allSquares++;
								gameBoard.display();
								winner = gameBoard.checkWinStatus();
							} else {
								System.out.println("Square has already been filled.");
							}
						}
					} else {
						System.out.println("Invalid input.");
					}
				} 
				
				// Print End Of Game Message!
				System.out.println();
				System.out.println("-------------------------");
				System.out.println("  Game Over:");
				if (winner.equals("draw")) {
					System.out.println("  This game is a " + winner + "!");
				} else {
					System.out.println("              " + winner + " wins!");
				}
				System.out.println("-------------------------");

				// Close the Scanner once the game is done!
				in.close();
			}

	}


