package ee.rebecca.salat.controller;

import ee.rebecca.salat.entity.Toiduaine;
import ee.rebecca.salat.entity.Toidukomponent;
import ee.rebecca.salat.entity.Toit;
import ee.rebecca.salat.repository.ToiduaineRepository;
import ee.rebecca.salat.repository.ToidukomponentRepository;
import ee.rebecca.salat.repository.ToitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
//localhost:8080/lisa-toiduaine?nimetus=kartul&valgud=4&rasvad=2&sysivesikud=12
@RestController
// StudyController PersonController RoomController
public class SaladController {
    @Autowired
    ToiduaineRepository toiduaineRepository;
    //LISTI ASEMEL ANDMEBAAS
    //List<Toiduaine> toiduained = new ArrayList<>();
    @Autowired
    ToidukomponentRepository toidukomponentRepository;
    @Autowired
    ToitRepository toitRepository;
    @PostMapping("lisa-toiduaine") // localhost:8080/lisa-toiduaine
    public List<Toiduaine> lisaToiduaine(
            @RequestParam String nimetus,
            @RequestParam double valgud,
            @RequestParam double rasvad,
            @RequestParam double sysivesikud
    ) throws Exception {
        Toiduaine toiduaine = new Toiduaine(nimetus, valgud, rasvad, sysivesikud);
        //toiduained.add(toiduaine);
        toiduaineRepository.save(toiduaine);
        System.out.println("Toiduaine lisatud!");
        return toiduaineRepository.findAll();
    }



    @PostMapping("lisa-toidukomponent")
    public List<Toidukomponent> lisaToidukomponent(
            @RequestParam String toiduaineNimetus,
            @RequestParam int kogus
    ) throws Exception {
        // lähen otsin toiduaineNimetuse alusel toiduainete listist õige üles
//        Toiduaine toiduaine = null;
//        for (Toiduaine t: toiduained){
//            if (t.getNimetus().equals(toiduaineNimetus)) {
//                toiduaine = t;
//                break;
//            }
//        }
//        if(toiduaine == null) {
//            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
//        }
        Toiduaine toiduaine = toiduaineRepository.findById(toiduaineNimetus).get();
                                                            // TODO: muuta id
        Toidukomponent toidukomponent = new Toidukomponent(1, toiduaine, kogus);
        toidukomponentRepository.save(toidukomponent);
        return toidukomponentRepository.findAll();
    }

    @GetMapping("saa-toidukomponendi-rasvad1/{id}")
    public double saaToidukompunendiRasvad1(@PathVariable int id) throws Exception {
//        Toidukomponent toidukomponent = null;
//        for (Toidukomponent t: toidukomponendid){
//            if (t.getId() == id) {
//                toidukomponent = t;
//                break;
//            }
//        }
//        if(toidukomponent == null) {
//            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
//        }
        Toidukomponent toidukomponent = toidukomponentRepository.findById(id).get();
        return toidukomponent.getKogus() * toidukomponent.getToiduaine().getRasvad() / 100;
    }
    @GetMapping("saa-toidukomponendi-rasvad2/")
    public double saaToidukompunendiRasvad2(@RequestParam String toiduaineNimetus,
                                            @RequestParam int kogus
    ) throws Exception {
//        Toiduaine toiduaine = null;
//        for (Toiduaine t: toiduained){
//            if (t.getNimetus().equals(toiduaineNimetus)) {
//                toiduaine = t;
//                break;
//            }
//        }
//        if(toiduaine == null) {
//            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
//        }
        Toiduaine toiduaine = toiduaineRepository.findById(toiduaineNimetus).get();
        return kogus * toiduaine.getRasvad() / 100;
    }
//    List<Toit> toidud = new ArrayList<>();
    @PostMapping("lisa-toit")
    public List<Toit> lisaToit(
            @RequestParam String nimetus,
            @RequestParam Integer[] toidukomponentideIds
    ) {
//        List<Toidukomponent> toiduosad = new ArrayList<>();
//        for (int id: toidukomponentideIds){
//            for (Toidukomponent t: toidukomponendid){
//                if (id == t.getId()){
//                    toiduosad.add(t);
//                }
//            }
//        }
        List<Toidukomponent> toiduosad = toidukomponentRepository.findAllById(List.of(toidukomponentideIds));
                Toit toit = new Toit(nimetus,toiduosad);
//        toidud.add(toit);
        toitRepository.save(toit);
        return toidud;
    }

    @GetMapping("saa-toidu-valgud")
    public double saaToiduValgud (
            @RequestParam String nimetus
    ) throws Exception {
//        Toit toit = null;
//        for (Toit t: toidud){
//            if (t.getNimetus().equals(nimetus)) {
//                toit = t;
//                break;
//            }
//        }
//        if(toit == null) {
//            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
//        }
        Toit toit = toitRepository.findById(nimetus).get();
        return toit.saaValgud();
    }
    @GetMapping("saa-toidu-rasvad")
    public double saaToiduRasvad (
            @RequestParam String nimetus
    ) throws Exception {
//        Toit toit = null;
//        for (Toit t: toidud){
//            if (t.getNimetus().equals(nimetus)) {
//                toit = t;
//                break;
//            }
//        }
//        if(toit == null) {
//            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
//        }
        Toit toit = toitRepository.findById(rasvad).get();
        return toit.saaRasvad();
    }
    @GetMapping("saa-toidu-sysivesikud")
    public double saaToiduSysivesikud (
            @RequestParam String nimetus
    ) throws Exception {
//        Toit toit = null;
//        for (Toit t: toidud){
//            if (t.getNimetus().equals(nimetus)) {
//                toit = t;
//                break;
//            }
//        }
//        if(toit == null) {
//            throw new Exception("Sellise nimetusega toiduainet ei eksisteeri!");
//        }
        Toit toit = toitRepository.findById(nimetus).get();
        return toit.saaSysivesikud();
    }

}

