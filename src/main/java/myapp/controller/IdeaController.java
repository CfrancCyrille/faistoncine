package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.model.Idea;
import myapp.model.Scenario;
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
	
	
	@PostMapping("/idea/edit")
	public String edit(
				@Valid Idea idea,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "scenarii/show";
	        }
			else {
	      // Retreive idea ide in repository
	      Idea ide = (ideaRepository.findById(idea.getId())).get();
	      // Update scenario s:
				ide.setDescription(idea.getDescription());
				ide.setName(idea.getName());
	      // Save scenario edited:
				ideaRepository.save(ide);
	      // Return to the list of scenarii
	      return "redirect:/scenarii";
			}
	}
	
	@GetMapping(path= {"idea/delete/{id}"})
	public String delete( Model model, @PathVariable Long id)	{
		ideaRepository.deleteById(id);
		 model.addAttribute("scenario", ideaRepository.findById(id));
		return "idea/list";
	}

}
