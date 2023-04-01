package br.com.todo.springbootthymeleaf.controllers;

import br.com.todo.springbootthymeleaf.models.entities.Todo;
import br.com.todo.springbootthymeleaf.models.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepo;

    @GetMapping("/todos")
    public String index(Model model) {
        model.addAttribute("title", "Home");

        List<Todo> todos = (List<Todo>) this.todoRepo.findAll();
        model.addAttribute("todos", todos);

        return "todos";
    }

}
