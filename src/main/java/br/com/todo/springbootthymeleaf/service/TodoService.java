package br.com.todo.springbootthymeleaf.service;

import br.com.todo.springbootthymeleaf.models.entities.Todo;
import br.com.todo.springbootthymeleaf.models.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;

//    public List<Todo> findAll() {
//
//    }
}
