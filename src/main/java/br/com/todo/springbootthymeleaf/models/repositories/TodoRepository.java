package br.com.todo.springbootthymeleaf.models.repositories;

import br.com.todo.springbootthymeleaf.models.entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
