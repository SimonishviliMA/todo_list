package ge.mikhail.todo_list.mapper;

import ge.mikhail.todo_list.dto.request.UserRequest;
import ge.mikhail.todo_list.dto.response.UserResponse;
import ge.mikhail.todo_list.entity.UserTable;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse entityToResponse(UserTable entity) {
        return new UserResponse(
                entity.getId(),
                entity.getUsername()
        );
    }

    public UserTable requestToEntity(UserRequest request) {
        UserTable user = new UserTable();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }
}
