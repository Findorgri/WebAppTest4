package pl.edu.agh.wat.domain.service;

import pl.edu.agh.wat.domain.model.Experience;


public interface ExperienceService {
    Iterable<Experience> listAllExperiences();

    Experience getExperienceById(Integer id);

    Experience saveExperience(Experience experience);

    void deleteExperience(Integer id);
}