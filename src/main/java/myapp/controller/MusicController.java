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
import myapp.model.Music;
import myapp.repository.MusicRepository;

@Controller
public class MusicController {

	@Autowired
	MusicRepository musicRepository;
	
	@GetMapping()
	public String list(Model model) {
		model.addAttribute("musicList", musicRepository.findAll());
		model.addAttribute("musicForm", new ScenarioForm());
		return "music/list";
	}
	
	@GetMapping("/music/{id}")
	public String show(Model model, @PathVariable Long id) {
			model.addAttribute("music", musicRepository.findById(id));
			return "music/show";
	}
	
	@PostMapping("/music/edit")
	public String edit(
				@Valid Music music,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "music/show";
	        }
			else {
	      
	      Music m = (musicRepository.findById(music.getId())).get();
	      
				m.setDescription(music.getDescription());
				m.setName(music.getName());
	      
				musicRepository.save(s);
	      
	      return "redirect:/music";
			}
	}
	
	@PostMapping("/music/add")
	public String scenariosAdd(
				@Valid Music music,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "music/list";
	        }
			else {
	      
				Music s = new Music();
	      
				s.setName(music.getName());
				s.setDescription(music.getDescription());
	      
				musicRepository.save(s);
		      // Return to the list of scenarii
		      return "redirect:/music";
			}
	}
	
}
