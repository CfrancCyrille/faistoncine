package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.form.PersonaForm;
import myapp.model.Persona;
import myapp.repository.PersonaRepository;

@Controller
public class PersonaController {
	@Autowired
	PersonaRepository personaRepository;

	@GetMapping("/persona/list")
	public String list(Model model) {
		model.addAttribute("personaList", personaRepository.findAll());
		model.addAttribute("personaForm", new PersonaForm());
		return "persona/list";
	}
	
	@GetMapping("/persona/{id}")
	public String show(Model model, @PathVariable Long id) {
			model.addAttribute("scenario", personaRepository.findById(id));
			return "persona/show";
	}
	
	@GetMapping("persona/add")
	public String add(Model model) {
		model.addAttribute("personaForm", new PersonaForm());
		return "persona/add";
	}
	
	@GetMapping("persona/{id}")
	public String show(Model model, @PathVariable Long id) {
		model.addAttribute("persona", personaRepository.findById(id));
		return "persona/show";
	}
	
	@PostMapping("/persona/add")
	public String scenariosAdd(
				@Valid Persona persona,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "persona/list";
	        }
			else {
	      // Create a new scenario with automatic id generated
				Persona p = new Persona();
	      // Update persona p:
				p.setFirstname(persona.getFirstname());
				p.setLastname(persona.getLastname());
				p.setPersonality(persona.getPersonality());
				p.setGender(persona.getGender());
	      // Save scenario edited:
				personaRepository.save(p);
		      // Return to the list of persona
		      return "redirect:/persona";
			}
	}
}
