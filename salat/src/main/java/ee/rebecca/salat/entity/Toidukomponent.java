package ee.rebecca.salat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Toidukomponent {
    @Id
    private int id;
    @ManyToOne
    private Toiduaine toiduaine;
    private int kogus;
}
