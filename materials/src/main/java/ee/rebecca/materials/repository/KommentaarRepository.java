package ee.rebecca.materials.repository;


import ee.rebecca.materials.entity.Artikkel;
import ee.rebecca.materials.entity.Kommentaar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KommentaarRepository extends JpaRepository<Kommentaar,Long> {
}