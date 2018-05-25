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
import myapp.model.Scenario;
import myapp.repository.ScenarioRepository;

@Controller
public class MusicController {

	@Autowired
	ScenarioRepository scenarioRepository;
	
	@GetMapping()
	public String list(Model model) {
		model.addAttribute("musicList", scenarioRepository.findAll());
		model.addAttribute("musicForm", new ScenarioForm());
		return "music/list";
	}
	
	@GetMapping("/music/{id}")
	public String show(Model model, @PathVariable Long id) {
			model.addAttribute("music", scenarioRepository.findById(id));
			return "music/show";
	}
	
	@PostMapping("/music/edit")
	public String edit(
				@Valid Scenario scenario,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "music/show";
	        }
			else {
	      // Retreive scenario s in repository
	      Scenario s = (scenarioRepository.findById(scenario.getId())).get();
	      // Update scenario s:
				s.setDescription(scenario.getDescription());
				s.setName(scenario.getName());
	      // Save scenario edited:
				scenarioRepository.save(s);
	      // Return to the list of music
	      return "redirect:/music";
			}
	}
	
	@PostMapping("/music/add")
	public String scenariosAdd(
				@Valid Scenario scenario,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "music/list";
	        }
			else {
	      // Create a new scenario with automatic id generated
				Scenario s = new Scenario();
	      // Update scenario s:
				s.setName(scenario.getName());
				s.setDescription(scenario.getDescription());
	      // Save scenario edited:
				scenarioRepository.save(s);
		      // Return to the list of scenarii
		      return "redirect:/music";
			}
	}
	
}
