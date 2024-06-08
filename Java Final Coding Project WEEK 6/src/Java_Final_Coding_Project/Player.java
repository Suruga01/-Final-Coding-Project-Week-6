package Java_Final_Coding_Project;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // to hold the cards in the player's hand
    private List<Card> hand = new ArrayList<>();
    // to keep track of the player's score
    private int score = 0;
    // to store the player's name
    private String name;

    // constructor to initialize the player name ******
    public Player(String name) {
        this.name = name;
    }
    //method to print the player's name and the cards in their hand
   /* public void describe() {
        System.out.println("Player " + name + " has the following cards:");       **** not used
        for (Card card : hand) {
            card.describe();
        }
    }*/

    // flip (remove and return) the top card from the player's hand
    public Card flip() {
        return hand.isEmpty() ? null : hand.remove(0);
    }

    // method to draw a card from a deck and add it to the player's hand
    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }

    // mmethod to increment the player's score by 1
    public void incrementScore() {
        score++;
    }

    //method to get the player's score
    public int getScore() {
        return score;
    }

    // method to get the player's name
    public String getName() {
        return name;
    }

}
