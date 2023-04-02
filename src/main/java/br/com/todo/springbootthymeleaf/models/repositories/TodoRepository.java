package br.com.todo.springbootthymeleaf.models.repositories;

import br.com.todo.springbootthymeleaf.models.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
