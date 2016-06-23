package pl.edu.agh.wat.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.wat.domain.model.Experience;

public interface ExperienceRepository extends CrudRepository<Experience, Integer>{
}