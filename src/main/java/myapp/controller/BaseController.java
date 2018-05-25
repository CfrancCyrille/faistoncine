package myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping(path= {"/", "/home"})
    public String home() {
        return "home";
    }
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/hello")
    public String hello() {
        return "hello";
    }
	
	@GetMapping("/error")
    public String error() {
        return "error";
    }
	
}
