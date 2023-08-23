package ge.mikhail.todo_list.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TodoItemRequest {
    private final Long userId;
    private final String title;
    private final String description;
}
