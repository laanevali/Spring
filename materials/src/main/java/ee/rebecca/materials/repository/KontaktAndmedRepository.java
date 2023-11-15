package ee.rebecca.materials.repository;


import ee.rebecca.materials.entity.Aadress;
import ee.rebecca.materials.entity.KontaktAndmed;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KontaktAndmedRepository extends JpaRepository<KontaktAndmed,Long> {
}