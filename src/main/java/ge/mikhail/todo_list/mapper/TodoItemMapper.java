package ge.mikhail.todo_list.mapper;

import ge.mikhail.todo_list.dto.request.TodoItemRequest;
import ge.mikhail.todo_list.dto.response.TodoItemResponse;
import ge.mikhail.todo_list.entity.TodoItem;
import org.springframework.stereotype.Component;

@Component
public class TodoItemMapper {

    public TodoItemResponse entityToResponse(TodoItem entity) {
        return new TodoItemResponse(
                entity.getId(),
                entity.getUserId(),
                entity.getTitle(),
                entity.getDescription()
        );
    }

    public TodoItem requestToEntity(TodoItemRequest request) {
        TodoItem todoItem = new TodoItem();
        todoItem.setUserId(request.getUserId());
        todoItem.setTitle(request.getTitle());
        todoItem.setDescription(request.getDescription());
        return todoItem;
    }
}
