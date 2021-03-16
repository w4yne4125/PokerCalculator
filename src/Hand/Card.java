package Hand;

public class Card implements Comparable<Card> {
    public int value; // Card.Card Value from 2 - 14
    public Suit suit;

    public String toString() {
        String str = "";
        str += suit.toString();
        str += "_";
        if (value == 14) {
            str += 'A';
        } else if (value == 13) {
            str += 'K';
        } else if (value == 12) {
            str += 'Q';
        } else if (value == 11) {
            str += 'J';
        } else if (value == 10) {
            str += 'T';
        } else {
            str += String.valueOf(value);
        }
        return str;
    }

    public Card(int ordinal) {
        Suit suit = null;
        int value;
        switch (ordinal / 13) {
            case 0:
                suit = Suit.CLUB;
                break;
            case 1:
                suit = Suit.DIAMOND;
                break;
            case 2:
                suit = Suit.HEART;
                break;
            case 3:
                suit = Suit.SPACE;
                break;
        }
        value = ordinal % 13;
        if (value == 0) {
            value = 14;
        } else {
            value += 1;
        }
        this.value = value;
        this.suit = suit;
    }

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getOrdinal() {
        int ordinal = 0;
        if (value != 14) {
            ordinal += value-1;
        }
        switch (suit) {
            case CLUB:
                break;
            case DIAMOND:
                ordinal += 13;
                break;
            case HEART:
                ordinal += 26;
                break;
            case SPACE:
                ordinal += 39;
                break;
        }
        return ordinal;
    }


    @Override
    public int compareTo(Card o) {
        if (this.value > o.value) {
            return 1;
        } else if (this.value < o.value) {
            return -1;
        }
        return 0;
    }
}
