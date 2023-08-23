package ge.mikhail.todo_list.controller;

import ge.mikhail.todo_list.dto.response.TodoItemResponse;
import ge.mikhail.todo_list.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo-item")
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public ResponseEntity<List<TodoItemResponse>> getTodoItems(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(todoItemService.getAllTodoItemsByUserId(userId));
    }
}
