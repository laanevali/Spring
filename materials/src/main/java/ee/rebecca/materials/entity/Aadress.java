package ee.rebecca.materials.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aadress {
    @Id
    private Long id;

    private String linn;

    private String tanav;

    private String majanumber;

    private String postiindeks;

}