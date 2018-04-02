package guru.springframework.repository;

import guru.springframework.domain.UnityOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnityOfMeasureRepository extends CrudRepository<UnityOfMeasure, Long> {

    Optional<UnityOfMeasure> findByDescription(String description);
}
