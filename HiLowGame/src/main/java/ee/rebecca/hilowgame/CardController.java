package ee.rebecca.hilowgame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;

@RestController
public class CardController {
    private Card baseCard;
    private Deck deck;
    private Timer timer;
    private boolean roundInProgress;

    public CardController() {
        deck = new Deck();
        timer = new Timer();
    }
    private void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endRound(); // End the round when the timer reaches zero
            }
        }, 10000); // 10 seconds timer
    }

    @GetMapping("/startRound")
    public void startRound() {
        if (!deck.isEmpty()) {
            baseCard = deck.drawCard();
            roundInProgress = true;
            sendStartRoundRequest(baseCard.toString()); // Send StartRoundRequest to the client
            startTimer();
        } else {
            // Handle the case when the deck is empty (game over, reshuffle, etc.)
        }
    }


    @GetMapping("/playerAction")
    public void playerAction(@RequestParam String action) {
        if (roundInProgress) {
            // Check player action and compare with base card rank
            boolean playerWin;
            if ("H".equalsIgnoreCase(action)) {
                playerWin = isHigher(deck.drawCard());
            } else if ("L".equalsIgnoreCase(action)) {
                playerWin = isLower(deck.drawCard());
            } else if ("E".equalsIgnoreCase(action)) {
                playerWin = isEqual(deck.drawCard());
            } else {
                // Invalid action, handle accordingly
                return;
            }

            roundInProgress = false;
            endRound();
            sendFinishRoundRequest(playerWin); // Send FinishRoundRequest to the client with win result
            baseCard = deck.drawCard(); // Set new base card for the next round
        }
    }

    private void endRound() {
        timer.cancel(); // Cancel the timer when the round ends
        timer.purge();
    }

    private boolean isHigher(Card card) {
        return card.getValue() > baseCard.getValue();
    }

    private boolean isLower(Card card) {
        return card.getValue() < baseCard.getValue();
    }

    private boolean isEqual(Card card) {
        return card.getValue() == baseCard.getValue();
    }

    // Methods to send requests to the client (not implemented here)
    private void sendStartRoundRequest(Card baseCard) {
        // Logic to send StartRoundRequest to the client
    }

    private void sendFinishRoundRequest(boolean playerWin) {
        // Logic to send FinishRoundRequest to the client with win result
    }
}

