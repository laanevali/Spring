package ee.rebecca.materials.repository;


import ee.rebecca.materials.entity.Aadress;
import ee.rebecca.materials.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutorRepository extends JpaRepository<Autor,String> {
}