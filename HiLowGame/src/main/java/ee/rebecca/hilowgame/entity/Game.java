package ee.rebecca.hilowgame.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int correctAnswers;
    private Date creationDate;
    private long duration;
    @ManyToOne
    private Player player;
}
