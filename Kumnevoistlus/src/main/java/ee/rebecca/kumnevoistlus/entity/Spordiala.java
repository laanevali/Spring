package ee.rebecca.kumnevoistlus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity

public class Spordiala {
    @Id
    private String spordiala;
    @OneToMany
    private List<Sportlane> sportlased;
}
