package Hand;

public class CardSet {
    private Card[] cards;
    private HandValue handValue;

    public CardSet(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return this.cards;
    }
}
