package ee.rebecca.materials.repository;


import ee.rebecca.materials.entity.Artikkel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ArtikkelRepository extends JpaRepository<Artikkel,Long> {
}