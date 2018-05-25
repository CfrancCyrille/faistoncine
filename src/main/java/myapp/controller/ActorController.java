package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.form.ScenarioForm;
import myapp.model.Actor;
import myapp.repository.ActorRepository;

@Controller
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/actor")
    public String list(Model model) {
        model.addAttribute("actorList", actorRepository.findAll());
        model.addAttribute("actorForm", new ScenarioForm());
        return "actor/list";
    }

    @GetMapping("/actor/{id}")
    public String show(Model model, @PathVariable Long id) {
        model.addAttribute("actor", actorRepository.findById(id));
        return "actor/show";
    }

    @PostMapping("/actor/edit")
    public String edit(
            @Valid Actor actor,
            BindingResult result) {
        if (result.hasErrors()) {
            return "actor/show";
        } else {
            // Retreive scenario s in repository
            Actor s = (actorRepository.findById(actor.getIdActor())).get();
            // Update scenario s:
            s.setActorName(actor.getActorName());
            s.setActorSurname(actor.getActorSurname());
            s.setActorCountry(actor.getActorCountry());
            s.setActorAge(actor.getActorAge());
            // Save scenario edited:
// Save scenario edited:
            actorRepository.save(s);
            // Return to the list of scenarii
            return "redirect:/actor";
        }
    }

    @PostMapping("/actor/add")
    public String scenariosAdd(
            @Valid Actor actor,
            BindingResult result) {
        if (result.hasErrors()) {
            return "actor/list";
        } else {
            // Create a new scenario with automatic id generated
            Actor s = new Actor();
            // Update scenario s:
            s.setActorName(actor.getActorName());
            s.setActorSurname(actor.getActorSurname());
            s.setActorCountry(actor.getActorCountry());
            s.setActorAge(actor.getActorAge());
            // Save scenario edited:
            actorRepository.save(s);
            // Return to the list of scenarii
            return "redirect:/actor";
        }
    }
}
