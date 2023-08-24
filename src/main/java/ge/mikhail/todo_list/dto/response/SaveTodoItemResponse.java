package ge.mikhail.todo_list.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SaveTodoItemResponse extends BaseResponse {
    private final Long id;
}
