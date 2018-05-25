package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.model.User;
import myapp.repository.UserRepository;

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public String show(Model model, @PathVariable Long id) {
			model.addAttribute("users", userRepository.findAll());
			return "user/listUser";
	}
	
	@PostMapping("/users/edit")
	public String Useredit(
				@Valid User user,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "users/show";
	        }
			else {
	      User s = (userRepository.findById(user.getId())).get();
				s.setId(user.getId());
				s.setFirstname(user.getFirstname());
				s.setLastname(user.getLastname());
				s.setUsername(user.getUsername());
				s.setPassword(user.getPassword());				
				userRepository.save(s);
	      return "redirect:/users";
			}
	}
}
