package ge.mikhail.todo_list.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class TodoItem {

    @Id
    private Long id;

    @Column
    private Long userId;

    @Column
    private String title;

    @Column
    private String description;

}
