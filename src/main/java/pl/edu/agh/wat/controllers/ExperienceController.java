package pl.edu.agh.wat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.agh.wat.domain.model.Experience;
import pl.edu.agh.wat.domain.service.ExperienceService;

import javax.validation.Valid;


@Controller
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public void setExperienceService(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @RequestMapping(value = "/experiences", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("experiences", experienceService.listAllExperiences());
        return "experiences";
    }

    @RequestMapping("experience/{id}")
    public String showExperience(@PathVariable Integer id, Model model) {
        model.addAttribute("experience", experienceService.getExperienceById(id));
        return "show_experience";
    }

    @RequestMapping("experience/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("experience", experienceService.getExperienceById(id));
        return "experience_form";
    }

    @RequestMapping("experience/new")
    public String newExperience(Model model) {
        model.addAttribute("experience", new Experience());
        return "experience_form";
    }

    @RequestMapping(value = "experience", method = RequestMethod.POST)
    public String saveExperience(@Valid Experience experience , BindingResult bindingResult, Model model) {
        if( bindingResult.hasErrors())
        {
            model.addAttribute("experience", experience);
            return "experience_form";
        }

        experienceService.saveExperience(experience);
        return "redirect:/experience/" + experience.getId();
}


    @RequestMapping("experience/delete/{id}")
    public String delete(@PathVariable Integer id) {
        experienceService.deleteExperience(id);
        return "redirect:/experiences";
    }

}