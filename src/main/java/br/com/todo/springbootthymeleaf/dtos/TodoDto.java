package br.com.todo.springbootthymeleaf.dtos;

import br.com.todo.springbootthymeleaf.Enum.StatusTodoEnum;
import br.com.todo.springbootthymeleaf.models.entities.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
    private String title;
    private String description;
    private StatusTodoEnum status;

    public Todo toTodo() {
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setDescription(this.description);
        todo.setStatus(this.status);

        return todo;
    }

    public void fromTodo(Todo todo) {
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.status = todo.getStatus();
    }

    public Todo updateTodo(Todo todo) {
        todo.setTitle(this.title);
        todo.setDescription(this.description);
        todo.setStatus(this.status);

        return todo;
    }
}
