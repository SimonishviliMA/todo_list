package ge.mikhail.todo_list.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class GetAllTodoItemsByUserIdResponse extends BaseResponse {

    private final List<TodoItemResponse> todoItems;

}
