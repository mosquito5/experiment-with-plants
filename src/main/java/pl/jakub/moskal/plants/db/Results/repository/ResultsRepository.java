package pl.jakub.moskal.plants.db.Results.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.moskal.plants.db.Results.model.Results;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
}
