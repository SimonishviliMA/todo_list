package ge.mikhail.todo_list.controller;

import ge.mikhail.todo_list.dto.request.UserRequest;
import ge.mikhail.todo_list.dto.response.SaveUserResponse;
import ge.mikhail.todo_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<SaveUserResponse> saveUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.saveUser(request));
    }
}
