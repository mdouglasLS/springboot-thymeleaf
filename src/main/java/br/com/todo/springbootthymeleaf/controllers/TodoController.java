package br.com.todo.springbootthymeleaf.controllers;

import br.com.todo.springbootthymeleaf.Enum.StatusTodoEnum;
import br.com.todo.springbootthymeleaf.dtos.TodoDto;
import br.com.todo.springbootthymeleaf.models.entities.Todo;
import br.com.todo.springbootthymeleaf.models.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepo;

    @GetMapping("/")
    public String index(Model model) {
        List<Todo> todos = (List<Todo>) this.todoRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("todos", todos);
        model.addAttribute("statusTodo", StatusTodoEnum.values());

        return "home";
    }

    @GetMapping("/new")
    public String newTodo(Model model, TodoDto todoDto) {
        todoDto = new TodoDto();
        model.addAttribute("statusTodo", StatusTodoEnum.values());
        return "new";
    }

    @PostMapping("/create")
    public String createTodo(TodoDto todoDto) {
        Todo todo = todoDto.toTodo();
        todoRepo.save(todo);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        try{
            this.todoRepo.deleteById(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String editTodo(Model model, @PathVariable Integer id, TodoDto todoDto) {
        Optional<Todo> optional = this.todoRepo.findById(id);

        if (optional.isPresent()) {
            Todo todo = optional.get();
            todoDto.fromTodo(todo);

            model.addAttribute("todoId", todo.getId());
            model.addAttribute("statusTodo", StatusTodoEnum.values());
            return "edit";
        }else {
            return "/";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable Integer id, TodoDto todoDto) {
        Optional<Todo> optional = this.todoRepo.findById(id);
        Todo todo = todoDto.updateTodo(optional.get());
        this.todoRepo.save(todo);
        return "redirect:/";
    }

    @GetMapping("/edit-status")
    public String updateTodoStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") String status) {
        Todo todo = this.todoRepo.findById(id).get();
        todo.setStatus(StatusTodoEnum.valueOf(status));

        this.todoRepo.save(todo);

        return "redirect:/";
    }

}
