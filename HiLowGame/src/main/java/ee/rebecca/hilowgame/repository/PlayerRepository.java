package ee.rebecca.hilowgame.repository;

import ee.rebecca.hilowgame.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, String> {
    List<Player> findAllByOrderByHighScoreDesc();
}
