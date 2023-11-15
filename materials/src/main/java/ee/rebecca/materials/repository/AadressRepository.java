package ee.rebecca.materials.repository;


import ee.rebecca.materials.entity.Aadress;
import ee.rebecca.materials.entity.Kommentaar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AadressRepository extends JpaRepository<Aadress,Long> {
}