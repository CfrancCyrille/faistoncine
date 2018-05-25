package myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import myapp.repository.PersonaRepository;

public class PersonaController {
	@Autowired
	PersonaRepository personaRepository;

	@GetMapping()
	public String list(Model model) {
		model.addAttribute("scenarioList", personaRepository.findAll());
		return "persona/list";
	}
}
