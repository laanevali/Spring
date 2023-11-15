package ee.rebecca.lemmikloomad.service;

import ee.rebecca.lemmikloomad.entity.Lemmikloom;
import ee.rebecca.lemmikloomad.entity.Omanik;
import ee.rebecca.lemmikloomad.repository.OmanikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // on loodud new LemmikloomService() Springi poolt
public class LemmikloomService {
    @Autowired
    OmanikRepository omanikRepository;

    public Lemmikloom getLemmikloom(String kumbaPidi, String omanikuNimi){
        Omanik omanik = omanikRepository.findById(omanikuNimi).get();
        List<Lemmikloom> lemmikloomad = omanik.getLemmikloomad();
        Lemmikloom lemmikloom = omanik.getLemmikloomad().get(0);
        for (Lemmikloom l:lemmikloomad){
            if (lemmikloom.getKaal() < l.getKaal()){
                lemmikloom = l;
            }
        }
        return lemmikloom;
    }
}
