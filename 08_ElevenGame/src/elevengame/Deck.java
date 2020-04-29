package elevengame;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Represents a deck //balicek karet
 * @author janvit
 */
public class Deck {
    //do not have to change during the game, deckSize can simulate removing the cards
    private List<Card> deckCards; 
    private int deckSize; //actual deck size
    
    public Deck(String[] symbols, String[] values, int[] nPoints) {
        deckCards = new ArrayList<>();
        generateAllCards(symbols, values, nPoints);
        shuffle();
    }
    
    /**
     * Generate List of all cards e.g. using DataStore class with arrays of symbols, values, nPoints
     */
    private void generateAllCards(String[] symbols, String[] values, int[] nPoints) {
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < values.length; j++) {
                deckCards.add(new Card(symbols[i], values[j], nPoints[j]));
            }
        }
        deckSize = deckCards.size();
    }
    
    /**
     * Shuffle list of cards
     * An algorithm to permute an array.
     */
    private void shuffle() {
        for (int i = 0; i < deckCards.size(); i++) {
            int index = deckCards.size()*(int)(Math.random());
            Collections.swap(deckCards, i, index);
        }
    }
    
    /**
     * Deal one card
     * Get the card at deckSize-1 index and decrement deckSize by one 
     * @return the dealt card, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() {
        if (deckSize <= 0) return null;
        deckSize--;
        return deckCards.get(deckSize);
    }

    public int getDeckSize() {
        return deckSize;
    }

    public boolean isEmpty() {
        return (deckSize <= 0);
    }
}