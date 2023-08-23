package ge.mikhail.todo_list.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class User {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "TODO_ITEM")
    private List<TodoItem> todoItems = new ArrayList<>();
}
