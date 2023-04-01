package br.com.todo.springbootthymeleaf;

import br.com.todo.springbootthymeleaf.models.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafApplication.class, args);
	}

}
