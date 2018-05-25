package myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import myapp.model.User;
import myapp.repository.UserRepository;

public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public String show(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "user/listUser";
	}

	@GetMapping("/users/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		User userToDelete = (userRepository.findById(id)).get();
		userRepository.delete(userToDelete);
		return "user/listUser";
	}
}
