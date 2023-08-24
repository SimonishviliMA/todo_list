package ge.mikhail.todo_list.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean completed;

}
