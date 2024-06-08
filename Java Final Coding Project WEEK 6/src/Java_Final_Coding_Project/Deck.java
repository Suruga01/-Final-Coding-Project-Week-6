package Java_Final_Coding_Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    // list to hold all the cards in the deck
    private List<Card> cards = new ArrayList<>();

    // constructor to build the deck when a Deck object is created
    public Deck() {
        buildDeck();
    }

    // method to populate the deck with 52 standard playing cards 
    private void buildDeck() {
        // Arrays to hold the suits and values of the cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"Two", "Three", "Four", "Five", "Six", "Seven",
        		"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

        // loop through each suit
        for (String suit : suits) {
            //loop through each value
            for (int i = 0; i < values.length; i++) {//values.length=13
                //create a card name combining the value and suit 
                String cardName = values[i] + " of " + suit;
                //create a new card with the appropriate value and name, and add it to the deck
                cards.add(new Card(i + 2, cardName));
            }
        }
    }

    // Method to shuffle the deck, randomizing the order of the cards (\OwO/==)
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw (remove and return) the top card from the deck
    public Card draw() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
}
