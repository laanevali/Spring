package ee.rebecca.hilowgame.controller;

import ee.rebecca.hilowgame.entity.Game;
import ee.rebecca.hilowgame.entity.Player;
import ee.rebecca.hilowgame.repository.GameRepository;
import ee.rebecca.hilowgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;
    @GetMapping("all-players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    @GetMapping("all-games")
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }
    @GetMapping("all-games-by-points")
    public List<Game> getAllGamesByPoints(){
        return gameRepository.findAllByOrderByCorrectAnswersDesc();
    }
    @GetMapping("all-players-by-points")
    public List<Player> getAllPlayersByPoints(){
        return playerRepository.findAllByOrderByHighScoreDesc();
    }
    @GetMapping("all-games-by-player")
    public List<Game> getAllGamesByPlayer(@RequestParam String playerName){
        Player player = playerRepository.findById(playerName).orElseThrow();
        return gameRepository.findAllByPlayer(player);
    }
    @GetMapping("all-games-by-player-order")
    public List<Game> getAllGamesByPlayerOrder(@RequestParam String playerName){
        Player player = playerRepository.findById(playerName).orElseThrow();
        return gameRepository.findAllByPlayerOrderByCorrectAnswersDesc(player);
    }
    @GetMapping("all-games-by-score")
    public List<Game> getAllGamesByPlayerOrder(){
        return gameRepository.findAllByCorrectAnswersGreaterThan(2);
    }

    @GetMapping("top-game")
    public Game getTopGame(){
        return gameRepository.findFirstByOrderByCorrectAnswersDesc();
    }

}
