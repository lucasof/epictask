package br.com.fiap.epictask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("users");
		List<User> users = userRepository.findAll();
		modelView.addObject("users", users);
		return modelView;
	}
	
	@RequestMapping("/user/new")
	public String create(User user) {
		return "user-form";
	}
	
	@PostMapping("/user")
	public String save(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user-form";
		}
		userRepository.save(user);
		return "users";
	}
}
