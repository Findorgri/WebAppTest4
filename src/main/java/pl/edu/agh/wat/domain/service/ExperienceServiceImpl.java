package pl.edu.agh.wat.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.wat.domain.model.Experience;
import pl.edu.agh.wat.domain.repository.ExperienceRepository;



@Service
public class ExperienceServiceImpl implements ExperienceService {
    private ExperienceRepository experienceRepository;

    @Autowired
    public void setExperienceRepository(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Iterable<Experience> listAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperienceById(Integer id) {
        return experienceRepository.findOne(id);
    }

    @Override
    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Integer id) {
        experienceRepository.delete(id);
    }
}