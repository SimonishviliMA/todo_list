package ge.mikhail.todo_list.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "TODO_ITEM",
            joinColumns = @JoinColumn(name = "userId")
    )
    private List<TodoItem> todoItems = new ArrayList<>();
}
