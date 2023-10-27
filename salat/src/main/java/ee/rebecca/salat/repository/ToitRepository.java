package ee.rebecca.salat.repository;


import ee.rebecca.salat.entity.Toit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToitRepository extends JpaRepository<Toit, String> {
}
