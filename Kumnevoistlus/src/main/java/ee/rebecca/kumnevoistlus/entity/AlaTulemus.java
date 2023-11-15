package ee.rebecca.kumnevoistlus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class AlaTulemus {
    @Id
    private Long id;
    private double sadaJooksTulemus;
    private double kaugusTulemus;
    private double kuulTulemus;
    private double korgusTulemus;
    private double neliSadaJooksTulemus;
    private double tokkeJooksTulemus;
    private double kettaTulemus;
    private double teivasTulemus;
    private double odaTulemus;
    private double poolteistTuhatJooksTulemus;
}
