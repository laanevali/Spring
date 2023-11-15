package ee.rebecca.materials.controller;

import ee.rebecca.materials.entity.Kommentaar;
import ee.rebecca.materials.repository.KommentaarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class KommentaarController {

    @Autowired
    KommentaarRepository kommentaarRepository;

    @GetMapping("kommentaarid")
    public List<Kommentaar> saaKommentaarid() {
        return kommentaarRepository.findAll();
    }

    @PostMapping("lisa-kommentaar")
    public List<Kommentaar> lisaKommentaar(@RequestBody Kommentaar kommentaar) {
        kommentaarRepository.save(kommentaar);
        return kommentaarRepository.findAll();
    }

    @DeleteMapping("kustuta-kommentaar/{id}")
    public List<Kommentaar> kustutaKommentaar(@PathVariable Long id) {
        kommentaarRepository.deleteById(id);
        return kommentaarRepository.findAll();
    }

    @PutMapping("muuda-kommentaar")
    public List<Kommentaar> muudaKommentaar(@RequestBody Kommentaar Kommentaar) {
        kommentaarRepository.save(Kommentaar);
        return kommentaarRepository.findAll();
    }

    @GetMapping("kommentaar/{id}")
    public Kommentaar saaKommentaar(@PathVariable Long id) {
        return kommentaarRepository.findById(id).get();
    }
}
