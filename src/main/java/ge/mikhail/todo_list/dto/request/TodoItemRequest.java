package ge.mikhail.todo_list.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TodoItemRequest {
    private final String title;
    private final String description;
}
