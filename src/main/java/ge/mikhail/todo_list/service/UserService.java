package ge.mikhail.todo_list.service;

import ge.mikhail.todo_list.dto.request.UserRequest;
import ge.mikhail.todo_list.dto.response.SaveUserResponse;

public interface UserService {
    SaveUserResponse saveUser(UserRequest request);
}
