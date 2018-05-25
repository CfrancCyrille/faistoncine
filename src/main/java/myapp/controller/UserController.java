package myapp.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import myapp.form.UserForm;
import myapp.model.User;
import myapp.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	public String home(Model model) {
		return "redirect:/user/list";
	}

	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("userForm", new UserForm());
		return "user/list";
	}

	@GetMapping("/user/new")
	public String newUser(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "user/add";
	}

	@PostMapping("/user/add")
	public String add(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/user/list";
		} else {
			User u = new User();
			u.setFirstname(user.getFirstname())
			.setLastname(user.getLastname())
			.setUsername(user.getUsername())
			.setPassword(user.getPassword());
			userRepository.save(u);
			return "redirect:/user/list";
		}
	}

	@GetMapping("/user/{id}")
	public String show(Model model, @PathVariable Long id) {
		model.addAttribute("userForm", userRepository.findById(id));
		return "user/edit";
	}

	@PostMapping("/user/edit")
	public String edit(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/list";
		} else {
			User u = (userRepository.findById(user.getId())).get();
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			userRepository.save(u);
			return "redirect:/user/list";
		}
	}

	@GetMapping("/user/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		User userToDelete = (userRepository.findById(id)).get();
		userRepository.delete(userToDelete);
		return "redirect:/user/list";
	}
}
