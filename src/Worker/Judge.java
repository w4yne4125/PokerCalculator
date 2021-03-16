package Worker;

import Hand.Card;
import Hand.HandValue;
import Hand.SetValue;

import java.util.Arrays;
import java.util.Collections;

public class Judge {
    private boolean isRoyalFlush(Card[] cards) {
        if (cards[4].value == 14 &&
            cards[3].value == 13 &&
            cards[2].value == 12 &&
            cards[1].value == 11 &&
            cards[0].value == 10 &&
            cards[4].suit == cards[3].suit &&
            cards[4].suit == cards[2].suit &&
            cards[4].suit == cards[1].suit &&
            cards[4].suit == cards[0].suit) {
            return true;
        }
        return false;
    }

    private HandValue buildRoyalFlush(Card[] cards) {
        return new HandValue(SetValue.ROYAL_FLUSH, new int[]{});
    }

    private boolean isStraightFlush(Card[] cards) {
        return isFlush(cards) && isStraight(cards);
    }

    private HandValue buildStraightFlush(Card[] cards) {
        int topCard;
        if (cards[0].value == 2 && cards[4].value == 14) {
            topCard = 5;
        } else {
            topCard = cards[4].value;
        }
        return new HandValue(SetValue.STRAIGHT_FLUSH, new int[]{topCard});
    }

    private boolean isFourOfAKind(Card[] cards) {
        if (cards[4].value == cards[3].value &&
            cards[4].value == cards[2].value &&
            cards[4].value == cards[1].value ) {
            return true;
        }
        if (cards[0].value == cards[3].value &&
            cards[0].value == cards[2].value &&
            cards[0].value == cards[1].value ) {
            return true;
        }
        return false;
    }

    private HandValue buildFourOfAKind(Card[] cards) {
        int topCard;
        if (cards[0].value == cards[1].value ) {
            topCard = cards[0].value;
        } else {
            topCard = cards[4].value;
        }
        return new HandValue(SetValue.FOUR_OF_A_KIND, new int[]{topCard});
    }

    private boolean isFullHouse(Card[] cards) {
        if (cards[4].value == cards[3].value &&
            cards[4].value == cards[2].value &&
            cards[1].value == cards[0].value ) {
            return true;
        }
        if (cards[4].value == cards[3].value &&
            cards[0].value == cards[2].value &&
            cards[0].value == cards[1].value ) {
            return true;
        }
        return false;
    }

    private HandValue buildFullHouse(Card[] cards) {
        int topCard;
        int kickCard;
        if (cards[1].value == cards[2].value ) {
            topCard = cards[0].value;
            kickCard = cards[4].value;
        } else {
            topCard = cards[4].value;
            kickCard = cards[0].value;
        }
        return new HandValue(SetValue.FULL_HOUSE, new int[]{topCard, kickCard});
    }

    private boolean isFlush(Card[] cards) {
        if (cards[4].suit == cards[3].suit &&
            cards[4].suit == cards[2].suit &&
            cards[4].suit == cards[1].suit &&
            cards[4].suit == cards[0].suit) {
            return true;
        }
        return false;
    }

    private HandValue buildFlush(Card[] cards) {
        return new HandValue(SetValue.FLUSH,
                new int[]{cards[4].value, cards[3].value, cards[2].value, cards[1].value, cards[0].value});
    }

    private boolean isStraight(Card[] cards) {
        if (cards[4].value == 14 &&
            cards[3].value == 5 &&
            cards[2].value == 4 &&
            cards[1].value == 3 &&
            cards[0].value == 2) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (cards[i].value + 1 != cards[i+1].value) {
                return false;
            }
        }
        return true;
    }

    private HandValue buildStraight(Card[] cards) {
        int topCard;
        if (cards[4].value == 14 && cards[0].value == 5) {
            topCard = 5;
        } else {
            topCard = cards[4].value;
        }
        return new HandValue(SetValue.STRAIGHT, new int[]{topCard});
    }

    private boolean isThreeOfAKind(Card[] cards) {
        if (cards[4].value == cards[3].value &&
            cards[4].value == cards[2].value ) {
            return true;
        }
        if (cards[3].value == cards[2].value &&
            cards[3].value == cards[1].value) {
            return true;
        }
        if (cards[2].value == cards[1].value &&
            cards[2].value == cards[0].value) {
            return true;
        }
        return false;
    }

    private HandValue buildThreeOfAKind(Card[] cards) {
        int topCard = 0, kick1 = 0, kick2 = 0;
        if (cards[4].value == cards[3].value &&
                cards[4].value == cards[2].value ) {
            topCard = cards[4].value;
            kick1 = cards[1].value;
            kick2 = cards[0].value;
        } else if (cards[3].value == cards[2].value &&
                cards[3].value == cards[1].value) {
            topCard = cards[3].value;
            kick1 = cards[4].value;
            kick2 = cards[0].value;
        } else if (cards[2].value == cards[1].value &&
                cards[2].value == cards[0].value) {
            topCard = cards[2].value;
            kick1 = cards[4].value;
            kick2 = cards[3].value;
        }
        return new HandValue(SetValue.THREE_OF_A_KIND, new int[]{topCard, kick1, kick2});
    }

    private boolean isTwoPairs(Card[] cards) {
        if (cards[3].value == cards[2].value &&
            cards[1].value == cards[0].value ) {
            return true;
        }
        if (cards[4].value == cards[3].value &&
            cards[1].value == cards[0].value) {
            return true;
        }
        if (cards[4].value == cards[3].value &&
            cards[2].value == cards[1].value) {
            return true;
        }
        return false;
    }

    private HandValue buildTwoPairs(Card[] cards) {
        int top1 = 0, top2 = 0, kick = 0;
        if (cards[3].value == cards[2].value &&
                cards[1].value == cards[0].value ) {
            top1 = cards[3].value;
            top2 = cards[1].value;
            kick = cards[4].value;
        }
        if (cards[4].value == cards[3].value &&
                cards[1].value == cards[0].value) {
            top1 = cards[4].value;
            top2 = cards[1].value;
            kick = cards[2].value;
        }
        if (cards[4].value == cards[3].value &&
                cards[2].value == cards[1].value) {
            top1 = cards[4].value;
            top2 = cards[2].value;
            kick = cards[0].value;
        }
        return new HandValue(SetValue.TWO_PAIRS, new int[]{top1, top2, kick});
    }

    private boolean isPair(Card[] cards) {
        for (int i = 0; i < 4; i++) {
            if (cards[i].value == cards[i+1].value) {
                return true;
            }
        }
        return false;
    }

    private HandValue buildPair(Card[] cards) {
        int topCard = 0, kick1 = 0, kick2 = 0, kick3 = 0;
        if (cards[4].value == cards[3].value ) {
            topCard = cards[4].value;
            kick1 = cards[2].value;
            kick2 = cards[1].value;
            kick3 = cards[0].value;
        } else if (cards[3].value == cards[2].value ) {
            topCard = cards[3].value;
            kick1 = cards[4].value;
            kick2 = cards[1].value;
            kick3 = cards[0].value;
        } else if (cards[2].value == cards[1].value ) {
            topCard = cards[2].value;
            kick1 = cards[4].value;
            kick2 = cards[3].value;
            kick3 = cards[0].value;
        } else {
            topCard = cards[1].value;
            kick1 = cards[4].value;
            kick2 = cards[3].value;
            kick3 = cards[2].value;
        }

        return new HandValue(SetValue.PAIR, new int[]{topCard, kick1, kick2, kick3});
    }

    private HandValue buildHighCards(Card[] cards) {
        return new HandValue(SetValue.HIGH_CARD,
                new int[]{cards[4].value, cards[3].value, cards[2].value, cards[1].value, cards[0].value});
    }

    public HandValue judgeHandValue(Card[] cards) {
        Arrays.sort(cards);
        if (isRoyalFlush(cards)) {
            return buildRoyalFlush(cards);
        } else if (isStraightFlush(cards)) {
            return buildStraightFlush(cards);
        } else if (isFourOfAKind(cards)) {
            return buildFourOfAKind(cards);
        } else if (isFullHouse(cards)) {
            return buildFullHouse(cards);
        } else if (isFlush(cards)) {
            return buildFlush(cards);
        } else if (isStraight(cards)) {
            return buildStraight(cards);
        } else if (isThreeOfAKind(cards)) {
            return buildThreeOfAKind(cards);
        } else if (isTwoPairs(cards)) {
            return buildTwoPairs(cards);
        } else if (isPair(cards)) {
            return buildPair(cards);
        }
        return buildHighCards(cards);
    }
}
