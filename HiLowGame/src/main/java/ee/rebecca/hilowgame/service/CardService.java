package ee.rebecca.hilowgame.service;

import ee.rebecca.hilowgame.entity.Card;
import ee.rebecca.hilowgame.entity.Deck;
import ee.rebecca.hilowgame.entity.Game;
import ee.rebecca.hilowgame.entity.Player;
import ee.rebecca.hilowgame.model.GuessResponse;
import ee.rebecca.hilowgame.repository.GameRepository;
import ee.rebecca.hilowgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CardService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;

    private int lives=3;
    private Card card;
    private Deck deck;
    private int score;
    private long startTime;
    private Player player;


    public GuessResponse userGuess(String guess) {
        GuessResponse response = new GuessResponse();
        GuessResponse gameOverResponse = getGuessResponse(response);
        if (gameOverResponse != null) return gameOverResponse;
        Card nextCard = deck.dealCard();
        if (nextCard.getValue() < card.getValue() && guess.equals("lower") ||
                nextCard.getValue() == card.getValue() && guess.equals("equal") ||
                nextCard.getValue() > card.getValue() && guess.equals("higher")
        ) {
            score++;
            card = nextCard;
            response.setMessage("Correct");
            response.setScore(score);
            response.setCard(card);
            return response;
        } else {
            card = nextCard;
            response.setMessage("Incorrect");
            response.setScore(score);
            response.setCard(card);
            lives--;

            return response;
        }
    }

    private GuessResponse getGuessResponse(GuessResponse response) {
        if(lives <= 0){
            saveToDatabase();
            response.setMessage("GAME_OVER");
            response.setScore(score);
            response.setCard(null);
            return response;
        }
        return null;
    }

    private void saveToDatabase() {
        if (score > player.getHighScore()){
            player.setHighScore(score);
            playerRepository.save(player);
        }
        Game game = Game.builder()
                .correctAnswers(score)
                .creationDate(new Date())
                .player(player)
                .build();
        gameRepository.save(game);
    }

    public Card startGame(String playerName) {
        lives = 3;
        score = 0;
        player = playerRepository.findById(playerName).orElseGet(() -> {
                    Player newPlayer = new Player(
                            playerName, new Date(), 0);
                    playerRepository.save(newPlayer);
                    return newPlayer;
                }
        );

        startTime = System.currentTimeMillis();
        deck = new Deck();
        deck.shuffle();
        card = deck.dealCard();
        return card;
    }

    public GuessResponse checkIfTimeout() {
        GuessResponse response = new GuessResponse();
        long guessTime = System.currentTimeMillis();
        if (guessTime > startTime + 10000) {
            response.setMessage("TIME_OUT");
            response.setCard(card);
            response.setScore(score);
        }
        startTime = guessTime;
        return response;
    }
}
