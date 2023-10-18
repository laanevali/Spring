package ee.rebecca.hilowgame;

enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        // Cards from TWO to TEN have the same value as their rank
        if (rank == Rank.ACE || rank == Rank.KING || rank == Rank.QUEEN || rank == Rank.JACK) {
            return 10;
        }
        return rank.ordinal() + 2;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}