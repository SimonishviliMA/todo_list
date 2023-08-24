package ge.mikhail.todo_list.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequest {

    private final String username;
    //TODO encrypted
    private final String password;
}
