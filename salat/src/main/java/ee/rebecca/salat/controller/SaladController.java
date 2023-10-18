package ee.rebecca.salat.controller;

import ee.rebecca.salat.entity.Toiduaine;
import ee.rebecca.salat.entity.Toidukomponent;
import ee.rebecca.salat.entity.Toit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
//localhost:8080/lisa-toiduaine?nimetus=kartul&valgud=4&rasvad=2&sysivesikud=12
@RestController
// StudyController PersonController RoomController
public class SaladController {
    List<Toiduaine> toiduained = new ArrayList<>();

    @GetMapping("lisa-toiduaine") // localhost:8080/lisa-toiduaine
    public List<Toiduaine> lisaToiduaine(
            @RequestParam String nimetus,
            @RequestParam double valgud,
            @RequestParam double rasvad,
            @RequestParam double sysivesikud
    ) throws Exception {
        Toiduaine toiduaine = new Toiduaine(nimetus, valgud, rasvad, sysivesikud);
        toiduained.add(toiduaine);
        System.out.println("Toiduaine lisatud!");
        return toiduained;
    }

    List<Toidukomponent> toidukomponendid = new ArrayList<>();

    @GetMapping("lisa-toidukomponent")
    public List<Toidukomponent> lisaToidukomponent(
            @RequestParam String toiduaineNimetus,
            @RequestParam int kogus
    ) throws Exception {
        // lähen otsin toiduaineNimetuse alusel toiduainete listist õige üles
        Toiduaine toiduaine = null;
        for (Toiduaine t: toiduained){
            if (t.getNimetus().equals(toiduaineNimetus)) {
                toiduaine = t;
                break;
            }
        }
        if(toiduaine == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }
        Toidukomponent toidukomponent = new Toidukomponent(toidukomponendid.size()+1, toiduaine, kogus);
        toidukomponendid.add(toidukomponent);
        return toidukomponendid;
    }

    @GetMapping("saa-toidukomponendi-rasvad1/{id}")
    public double saaToidukompunendiRasvad1(@PathVariable int id) throws Exception {
        Toidukomponent toidukomponent = null;
        for (Toidukomponent t: toidukomponendid){
            if (t.getId() == id) {
                toidukomponent = t;
                break;
            }
        }
        if(toidukomponent == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }
        return toidukomponent.getKogus() * toidukomponent.getToiduaine().getRasvad() / 100;
    }
    @GetMapping("saa-toidukomponendi-rasvad2/")
    public double saaToidukompunendiRasvad2(@RequestParam String toiduaineNimetus,
                                            @RequestParam int kogus
    ) throws Exception {
        Toiduaine toiduaine = null;
        for (Toiduaine t: toiduained){
            if (t.getNimetus().equals(toiduaineNimetus)) {
                toiduaine = t;
                break;
            }
        }
        if(toiduaine == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }

        return kogus * toiduaine.getRasvad() / 100;
    }
    List<Toit> toidud = new ArrayList<>();
    @GetMapping("lisa-toit")
    public List<Toit> lisaToit(
            @RequestParam String nimetus,
            @RequestParam int[] toidukomponentideIds
    ) {
        List<Toidukomponent> toiduosad = new ArrayList<>();
        for (int id: toidukomponentideIds){
            for (Toidukomponent t: toidukomponendid){
                if (id == t.getId()){
                    toiduosad.add(t);
                }
            }
        }
        Toit toit = new Toit(nimetus,toiduosad);
        toidud.add(toit);
        return toidud;
    }

    @GetMapping("saa-toidu-valgud")
    public double saaToiduValgud (
            @RequestParam String nimetus
    ) throws Exception {
        Toit toit = null;
        for (Toit t: toidud){
            if (t.getNimetus().equals(nimetus)) {
                toit = t;
                break;
            }
        }
        if(toit == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }
        return toit.saaValgud();
    }
    @GetMapping("saa-toidu-rasvad")
    public double saaToiduRasvad (
            @RequestParam String nimetus
    ) throws Exception {
        Toit toit = null;
        for (Toit t: toidud){
            if (t.getNimetus().equals(nimetus)) {
                toit = t;
                break;
            }
        }
        if(toit == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }
        return toit.saaRasvad();
    }
    @GetMapping("saa-toidu-sysivesikud")
    public double saaToiduSysivesikud (
            @RequestParam String nimetus
    ) throws Exception {
        Toit toit = null;
        for (Toit t: toidud){
            if (t.getNimetus().equals(nimetus)) {
                toit = t;
                break;
            }
        }
        if(toit == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }
        return toit.saaSysivesikud();
    }
    @GetMapping("saa-toiduaine")
    public Toiduaine saaToiduaine (@RequestParam String nimetus) throws Exception {
        Toiduaine toiduaine = null;
        for (Toiduaine t: toiduained){
            if (t.getNimetus().equals(toiduaineNimetus)) {
                toiduaine = t;
                break;
            }
        }
        if(toiduaine == null) {
            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
        }
        Toidukomponent toidukomponent = new Toidukomponent(toidukomponendid.size()+1, toiduaine, kogus);
        toidukomponendid.add(toidukomponent);
        return toidukomponendid;


    }
}

