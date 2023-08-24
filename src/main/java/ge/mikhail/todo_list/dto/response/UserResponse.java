package ge.mikhail.todo_list.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserResponse {
    private final Long id;
    private final String username;
}
