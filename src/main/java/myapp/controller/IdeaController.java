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
	            return "idea/show";
	        }
			else {
	      // Retreive idea ide in repository
	      Idea ide = (ideaRepository.findById(idea.getId())).get();
	      // Update Idea ide:
				ide.setDescription(idea.getDescription());
				ide.setName(idea.getName());
	      // Save scenario edited:
				ideaRepository.save(ide);
	      // Return to the list of scenarii
	      return "redirect:/idea";
			}
	}
	
	@GetMapping(path= {"idea/delete/{id}"})
	public String delete( Model model, @PathVariable Long id)	{
		ideaRepository.deleteById(id);
		 model.addAttribute("idea", ideaRepository.findById(id));
		return "idea/list";
	}
	
	@PostMapping(path= {"idea/add"})
	public String add(@Valid Idea idea, BindingResult result) {
		if (result.hasErrors()) {
			return "idea/list";
		}
		else {
			Idea i = new Idea();
			i.setName(idea.getName());
			i.setDescription(idea.getDescription());
			ideaRepository.save(i);
			return "redirect:/idea";
		}
	}
	
	@GetMapping(path= {"idea/{id}"})
	public String show( Model model, @PathVariable Long id)	{
		 model.addAttribute("idea", ideaRepository.findById(id));
		return "idea/show";
	}

}
