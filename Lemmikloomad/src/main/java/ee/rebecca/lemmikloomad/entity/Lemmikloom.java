package ee.rebecca.lemmikloomad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder

public class Lemmikloom {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String nimetus;
    private double kaal;
}
