package ge.mikhail.todo_list.dto.response;

import lombok.Data;

@Data
public class TodoItemResponse {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String description;
    private final boolean completed;

}
