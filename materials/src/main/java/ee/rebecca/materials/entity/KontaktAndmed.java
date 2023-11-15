package ee.rebecca.materials.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KontaktAndmed {
    @Id
    private Long id;

    @OneToMany
    private List<Aadress> aadress;

    private String telefoninumber;
}
