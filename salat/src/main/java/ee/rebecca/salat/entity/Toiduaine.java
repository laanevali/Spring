package ee.rebecca.salat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity // <--- tekib andmebaasi selle classi nimetusega tabel
@NoArgsConstructor
public class Toiduaine {
    @Id
    private String nimetus; // primaarvõti ehk selle abil kustutame ja muudame
    private double valgud;
    private double rasvad;
    private double sysivesikud;

    public Toiduaine(String nimetus, double valgud, double rasvad, double sysivesikud) throws Exception {
        if (valgud + rasvad + sysivesikud > 100){
            throw new Exception("Protsent kokku ei saa ületada 100!");
        }
        this.nimetus = nimetus;
        this.valgud = valgud;
        this.rasvad = rasvad;
        this.sysivesikud = sysivesikud;
    }

}
