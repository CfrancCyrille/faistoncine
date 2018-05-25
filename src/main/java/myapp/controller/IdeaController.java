package myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import myapp.repository.IdeaRepository;
import myapp.repository.ScenarioRepository;

@Controller 
public class IdeaController {
	
	@Autowired
	IdeaRepository ideaRepository;
	
	@GetMapping("idea/list")
	 public String list(Model model) {
	 	model.addAttribute("ideaList", ideaRepository.findAll());
	 	return "idea/list";
	 }
	
	@GetMapping(path= {"scenarii/{id}"})
	public String show( Model model, @PathVariable Long id)	{
		 model.addAttribute("scenario", ideaRepository.findById(id));
		return "scenarii/show";
	}

}
