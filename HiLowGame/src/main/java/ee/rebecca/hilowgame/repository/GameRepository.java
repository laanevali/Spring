package ee.rebecca.hilowgame.repository;

import ee.rebecca.hilowgame.entity.Game;
import ee.rebecca.hilowgame.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByOrderByCorrectAnswersDesc();
    List<Game> findAllByPlayer(Player player);
    List<Game> findAllByPlayerOrderByCorrectAnswersDesc(Player player);
    List<Game> findAllByCorrectAnswersGreaterThan(int correctAnswer);
    Game findFirstByOrderByCorrectAnswersDesc();
    List<Game> findTopByOrderByCorrectAnswersDesc();
}

