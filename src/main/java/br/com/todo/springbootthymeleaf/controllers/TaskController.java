package br.com.todo.springbootthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello CARAI!");
        return "hello";
    }

}
