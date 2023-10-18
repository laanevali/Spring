package ee.rebecca.salat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class Toit {
    private String nimetus;
    private List<Toidukomponent> toidukomponendid;
    public double saaValgud(){
        double valgud = 0;
        for (Toidukomponent t: this.getToidukomponendid()){
            valgud += t.getKogus() * t.getToiduaine().getValgud() / 100;
        }
        return valgud;
    }
    public double saaRasvad(){
        double rasvad = 0;
        for (Toidukomponent t: this.getToidukomponendid()){
            rasvad += t.getKogus() * t.getToiduaine().getRasvad() / 100;
        }
        return rasvad;
    }
    public double saaSysivesikud(){
        double sysivesikud = 0;
        for (Toidukomponent t: this.getToidukomponendid()){
            sysivesikud += t.getKogus() * t.getToiduaine().getSysivesikud() / 100;
        }
        return sysivesikud;
    }
}
