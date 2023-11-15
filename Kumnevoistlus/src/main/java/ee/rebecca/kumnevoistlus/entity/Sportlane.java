package ee.rebecca.kumnevoistlus.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder

public class Sportlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nimi;
    private String riik;
    private int vanus;
    @OneToOne
    private SportlaseTulemus sportlaseTulemus;

}
