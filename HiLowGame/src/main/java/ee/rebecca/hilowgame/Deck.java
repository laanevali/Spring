package ee.rebecca.hilowgame;
import java.util.ArrayList;

public class Deck {

    private final Card[] deck;
    private int cardsUsed;


    public Deck(){
        deck = new Card[52];
        for (Suits suit : Suits.values()){
            for (Ranks rank: Ranks.values()){
                for(int i=0; i<3; i++){
                    deck[i++] = new Card(rank, suit);
                }
            }
        }
        cardsUsed = 0;
    }

    //SHUFFLE



    public void shuffle(){
        Card tempDeck;
        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);

            tempDeck = deck[i];
            deck[i] = deck[index];
            deck[index] = tempDeck;
        }
    }

    public Card dealCard(){
        return deck[cardsUsed++];
    }
}
