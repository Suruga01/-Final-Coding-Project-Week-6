package Java_Final_Coding_Project;

import java.util.Scanner;

public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
        //enter the names of the players
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();

        //Create a new deck of cards and two players with the entered names
        Deck deck = new Deck();
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        //****Shuffle the deck to randomize the order of the cards
        deck.shuffle();

        //* Draw 52 cards, alternating between the two players *
        //For loop to run 52 times (one for each card in a standard deck)
        for (int i = 0; i < 52; i++) {
            // If 'i' is even, player 1 draws a card
            if (i % 2 == 0) {
                player1.draw(deck);
            } else {// If 'i' is odd, player 2 draws a card
                player2.draw(deck);
            }
        }

        // So, each player flips 26 cards and the values are compared
        // For loop will run 26 times (half the deck, since each player has 26 cards)
        for (int i = 0; i < 26; i++) {
            //each player flips the top card from their hand
            Card card1 = player1.flip();
            Card card2 = player2.flip();

            // Check if both players have cards to flip
            if (card1 != null && card2 != null) {
                // Compare the values of the two cards
                if (card1.getValue() > card2.getValue()) {
                    //Player 1 wins the round if their card's value is higher
                    player1.incrementScore();
                    System.out.println(player1.getName() + " wins this round with " + card1.getName() + " against " + card2.getName());
                } else if (card2.getValue() > card1.getValue()) {
                    //Player 2 wins the round 
                    player2.incrementScore();
                    System.out.println(player2.getName() + " wins this round with " + card2.getName() + " against " + card1.getName());
                } else {
                    //The round is a tie if both cards have the same value
                    System.out.println("Round is a tie with " + card1.getName() + " and " + card2.getName());
                }
            } /*else {
                System.out.println("No more cards to flip");                   no se necesita ahora      
            }*/
        }

        //compare the final scores and print the result
        System.out.println("Final score: " + "\n" + player1.getName() + " - " + player1.getScore() + 
        		"\n" + player2.getName() + " - " + player2.getScore());
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
        

	}           //THE END

}
