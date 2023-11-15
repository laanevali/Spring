package ee.rebecca.kumnevoistlus.controller;

import ee.rebecca.kumnevoistlus.entity.AlaTulemus;
import ee.rebecca.kumnevoistlus.entity.Spordiala;
import ee.rebecca.kumnevoistlus.entity.Sportlane;
import ee.rebecca.kumnevoistlus.entity.SportlaseTulemus;
import ee.rebecca.kumnevoistlus.repository.AlaTulemusRepository;
import ee.rebecca.kumnevoistlus.repository.SpordialaRepository;
import ee.rebecca.kumnevoistlus.repository.SportlaneRepository;
import ee.rebecca.kumnevoistlus.repository.SportlaseTulemusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KumnevoistlusController {
    @Autowired
    SportlaneRepository sportlaneRepository;
    @Autowired
    SpordialaRepository spordialaRepository;
    @Autowired
    AlaTulemusRepository alaTulemusRepository;
    @Autowired
    SportlaseTulemusRepository sportlaseTulemusRepository;

    // http://localhost:8080/lisa-sportlane?nimi=Jaan&riik=eesti&vanus=25
    @GetMapping("lisa-sportlane")
    public List<Sportlane> lisaSportlane(
            @RequestParam("nimi") String nimi,
            @RequestParam("riik") String riik,
            @RequestParam("vanus") int vanus){
        Sportlane sportlane = Sportlane.builder()
                .nimi(nimi)
                .riik(riik)
                .vanus(vanus)
                .build();
        sportlaneRepository.save(sportlane);
        System.out.println(sportlane);
        return sportlaneRepository.findAll();
    }
    @GetMapping ("100-jooks")
    public List<Sportlane> SadaJooksTulemus(
            @RequestParam String nimi,
            @RequestParam double sadaJooksTulemus){
        Sportlane leitudSportlane = sportlaneRepository.findById(nimi).get();
        //////


        return sportlaneRepository.findAll();
    }
}
