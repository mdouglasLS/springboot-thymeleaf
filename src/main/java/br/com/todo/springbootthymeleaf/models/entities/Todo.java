package br.com.todo.springbootthymeleaf.models.entities;

import br.com.todo.springbootthymeleaf.Enum.StatusTodoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusTodoEnum status;

    public Todo (String title, String description) {
        this.title = title;
        this.description = description;
        this.status = StatusTodoEnum.ANDAMENTO;
    }

    public Todo (String title, String description, StatusTodoEnum status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
