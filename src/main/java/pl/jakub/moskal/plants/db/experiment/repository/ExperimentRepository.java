package pl.jakub.moskal.plants.db.experiment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.moskal.plants.db.experiment.model.Experiment;

import java.util.Optional;

@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {
   Optional<Experiment> getByExperimentName(String name);

}
