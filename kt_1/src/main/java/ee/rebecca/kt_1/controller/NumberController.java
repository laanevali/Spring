package ee.rebecca.kt_1.controller;

import ee.rebecca.kt_1.entity.integer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class NumberController {

    List<Integer> integers = new ArrayList<>(Arrays.asList(31,52));

    //funktsioon, mis lisab ühe numbri juurde
    @GetMapping("add/{number}")
    public List<Integer> addNumber(@PathVariable Integer number){
        integers.add(number);
        return integers;
    }

    //funktsioon, mis eemaldab ühe numbri
    @GetMapping("remove/{number}")
    public List<Integer> removeNumber(@PathVariable Integer number){
        integers.remove(number);
        return integers;
    }

    //funktsioon, mis eemaldab kõik numbrid
    @GetMapping("removeAll/{number}")
    public List<Integer> removeAll(){
        integers.removeAll(integers);
        return integers;
    }

}
