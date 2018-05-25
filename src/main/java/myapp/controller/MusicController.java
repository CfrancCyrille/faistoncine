package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import myapp.form.MusicForm;
import myapp.model.Music;
import myapp.repository.MusicRepository;

@Controller
public class MusicController {

	@Autowired
	MusicRepository musicRepository;
	
	@GetMapping("/music/list")
	public String list(Model model) {
		model.addAttribute("musicList", musicRepository.findAll());
		model.addAttribute("musicForm", new MusicForm());
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
			// Retreive music m in repository
				Music m = (musicRepository.findById(music.getId())).get();
			// Update music m:   
				m.setTitle(music.getTitle());
				m.setAuthor(music.getAuthor());
				m.setInterpreter(music.getInterpreter());
			// Save music edited:
				musicRepository.save(m);
			// Return to the list of music
	      return "redirect:/music/list";
			}
	}
	
	@PostMapping("/music/add")
	public String musicsAdd(
				@Valid Music music,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "music/list";
	        }
			else {
			// Create a new music with automatic id generated
				Music m = new Music();
			// Update scenario s:
				m.setTitle(music.getTitle());
				m.setAuthor(music.getAuthor());
				m.setInterpreter(music.getInterpreter());
			// Save music edited:
				musicRepository.save(m);
		    // Return to the list of music
		      return "redirect:/music/list";
			}
	}
	
	@GetMapping("/music/delete/{id}")
	public String musicsDelete(@Valid Music music, @PathVariable Long id, BindingResult result) {
		if (result.hasErrors()) {
            return "music/delete";
        }
		else {
			// Retreive music m in repository
			Music m = (musicRepository.findById(music.getId())).get();
			// Delete music edited:
			musicRepository.delete(m);
			return "redirect:/music/list";
		}
	}
	
	
}
