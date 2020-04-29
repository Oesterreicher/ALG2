package elevengame;

/**
 * Represents the table with cards to play and a deck
 * @author janvit
 */
public class Board implements BoardInterface {
    private Card[] cards;
    private Deck deck;
    
    public Board() {
        deck = new Deck(DataStore.loadSymbols(), DataStore.loadValues(), DataStore.loadNPoints());
        cards = new Card[DataStore.getNCards()];
        for (int i = 0; i < nCards(); i++) cards[i] = deck.deal();
    }
    
    @Override
    public String gameName() {
        return "Hra jedenactka";
    }
    
    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }
    
    @Override
    public String getCardDescriptionAt(int index) {
        if (cards[index] == null) {
            return " ";
        }
        return cards[index].getSymbol() + "-" + cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        int zeroes = 0;
        for (int i = 0; i < nCards(); i++) {
            if (cards[i] != null && cards[i].getnPoints() == 0) zeroes++;
        }
        if (zeroes >= 3) return true;
        for (int i = 0; i < nCards() - 1; i++) {
            for (int j = i + 1; j < nCards(); j++) {
                if (cards[i] != null && cards[j] != null && cards[i].getnPoints() + cards[j].getnPoints() == 11) return true;
            }
        }
        return false;
    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        int sum = 0;
        for (int i = 0; i < iSelectedCards.length; i++) {
            sum += cards[iSelectedCards[i]].getnPoints();
        }
        if (sum == 11 || sum == 0) {
            for (int i = 0; i < iSelectedCards.length; i++) {
                cards[iSelectedCards[i]] = deck.deal();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isWon() {
        return (getDeckSize() == 0 && nCards() == 0);
    }
}