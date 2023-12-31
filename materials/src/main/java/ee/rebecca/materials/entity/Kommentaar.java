package ee.rebecca.materials.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kommentaar {
    @Id
    private Long id;
    private Date kuupaev;
    private String sisu;
    @ManyToOne
    private Artikkel artikkel;
}