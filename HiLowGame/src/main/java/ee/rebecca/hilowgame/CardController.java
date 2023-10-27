package ee.rebecca.hilowgame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CardController {
    private Card card;
    private Deck deck;

    public CardController(){
        deck = new Deck();
        deck.shuffle();
    }
   @GetMapping("/start")
    public String getCard(){
       Card currentCard;

       currentCard = deck.dealCard();

       return "The card from the deck is " + currentCard;
   }
}

