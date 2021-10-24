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

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;

@Controller
public class TaskController {
	
	//Injeção de Dependência - Como a classe depende de uma outra, ela será inicializada na instancia
	@Autowired
	//No spring ele usa repository em vez de DAO;
	private TaskRepository repository;
	
//	@ResponseBody
	@GetMapping("/task")
	public ModelAndView index() {
		//recebe a view que será lançada ModelAndView(viewName);
		ModelAndView modelView = new ModelAndView("tasks");
		//retorna o objeto 'Task'
		List<Task> tasks = repository.findAll();
		//adiciona o objeto na view com o nome (String, Obj);
		modelView.addObject("tasks", tasks);
		return modelView;
	}
	
	@RequestMapping("/task/new")
	public String create(Task task) {
		return "task-form";
	}
	
	@PostMapping("/task")
	public String save(@Valid Task task, BindingResult result) {
		if(result.hasErrors()) {
			return "task-form";
		}
		
		//Spring Data JPA
		repository.save(task);
//		
//		repository.findByTitle("comer algúem");
//		System.out.println(task);
		
		
		return "tasks";
	}
}
