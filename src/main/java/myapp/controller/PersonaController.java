package myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import myapp.form.PersonaForm;
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
}
