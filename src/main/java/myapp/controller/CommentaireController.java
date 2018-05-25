package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.form.CommentaireForm;
import myapp.model.Commentaire;
import myapp.repository.CommentaireRepository;

@Controller
public class CommentaireController {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@GetMapping("/comment/list")
	public String show(Model model) {
		model.addAttribute("commentaireList", commentaireRepository.findAll());
		model.addAttribute("commentaireForm", new CommentaireForm());
		return "commentaire/add";
	}
	
	@GetMapping("/commentaire/{id}")
	public String show(Model model, @PathVariable Long id) {
			model.addAttribute("commentaire", commentaireRepository.findById(id));
			return "commentaire/show";
	}
	
	@PostMapping("/commentaire/delete")
	public String delete(Long id) {
	      // Retreive scenario s in repository
	      Commentaire c = (commentaireRepository.findById(id)).get();
		  commentaireRepository.delete(c);
	      // Return to the list of comments
	      return "redirect:/comment/list";
	}
	
	@PostMapping("/commentaire/creation")
	public String scenariosAdd(
				@Valid Commentaire commentaire,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "comment/list";
	        }
			else {
	      // Create a new scenario with automatic id generated
				Commentaire c = new Commentaire();
	      // Update scenario s:
				c.setAuteur(commentaire.getAuteur());
				c.setTitre(commentaire.getTitre());
				c.setSur(commentaire.getSur());
				c.setComment(commentaire.getComment());
	      // Save scenario edited:
				commentaireRepository.save(c);
		      // Return to the list of commentary
		      return "redirect:/comment/list";
			}
	}
	@PostMapping("/commentaire/edit")
	public String edit(
				@Valid Commentaire commentaire,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "commentaire/show";
	        }
			else {
	      Commentaire c = (commentaireRepository.findById(commentaire.getId())).get();
	      		c.setAuteur(commentaire.getAuteur());
	      		c.setTitre(commentaire.getTitre());
	      		c.setComment(commentaire.getComment());
	      		c.setSur(commentaire.getSur());
				commentaireRepository.save(c);
	      return "redirect:/comment/list";
			}
	}
	

}
