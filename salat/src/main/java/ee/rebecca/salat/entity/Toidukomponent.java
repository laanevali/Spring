package ee.rebecca.salat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Toidukomponent {
    private int id;
    private Toiduaine toiduaine;
    private int kogus;
}
