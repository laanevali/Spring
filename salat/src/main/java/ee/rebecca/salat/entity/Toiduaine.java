package ee.rebecca.salat.entity;

import lombok.Getter;


@Getter

public class Toiduaine {
    private String nimetus;
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
