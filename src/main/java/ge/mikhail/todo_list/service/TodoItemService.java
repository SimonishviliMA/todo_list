package ge.mikhail.todo_list.service;

import ge.mikhail.todo_list.dto.response.TodoItemResponse;

import java.util.List;

public interface TodoItemService {

    List<TodoItemResponse> getAllTodoItemsByUserId(Long id);
}
