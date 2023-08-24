package ge.mikhail.todo_list.controller;

import ge.mikhail.todo_list.dto.request.TodoItemRequest;
import ge.mikhail.todo_list.dto.response.BaseResponse;
import ge.mikhail.todo_list.dto.response.GetAllTodoItemsByUserIdResponse;
import ge.mikhail.todo_list.dto.response.SaveTodoItemResponse;
import ge.mikhail.todo_list.dto.response.TodoItemResponse;
import ge.mikhail.todo_list.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo-item")
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }


    @PostMapping
    public ResponseEntity<SaveTodoItemResponse> saveTodoItem(@RequestBody TodoItemRequest request) {
        return ResponseEntity.ok(todoItemService.saveTodoItem(request));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> completedTodoItem(@RequestParam("id") Long id) {
        return ResponseEntity.ok(todoItemService.completedTodoItem(id));
    }

    @GetMapping
    public ResponseEntity<TodoItemResponse> getTodoItemById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(todoItemService.getTodoItemById(id));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> deleteTodoItemById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(todoItemService.deleteTodoItemById(id));
    }

    @GetMapping("/user")
    public ResponseEntity<GetAllTodoItemsByUserIdResponse> getAllTodoItemsByUserId() {
        return ResponseEntity.ok(todoItemService.getAllTodoItemsByUserId());
    }

    @DeleteMapping("/user")
    public ResponseEntity<BaseResponse> deleteAllTodoItemsByUserId() {
        return ResponseEntity.ok(todoItemService.deleteAllTodoItemsByUserId());
    }
}
