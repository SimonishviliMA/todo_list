package ge.mikhail.todo_list.service;

import ge.mikhail.todo_list.dto.request.TodoItemRequest;
import ge.mikhail.todo_list.dto.response.BaseResponse;
import ge.mikhail.todo_list.dto.response.GetAllTodoItemsByUserIdResponse;
import ge.mikhail.todo_list.dto.response.SaveTodoItemResponse;
import ge.mikhail.todo_list.dto.response.TodoItemResponse;

public interface TodoItemService {

    GetAllTodoItemsByUserIdResponse getAllTodoItemsByUserId(Long id);

    BaseResponse deleteAllTodoItemsByUserId(Long userId);

    TodoItemResponse getTodoItemById(Long id);

    SaveTodoItemResponse saveTodoItem(TodoItemRequest request);

    BaseResponse deleteTodoItemById(Long id);

    BaseResponse completedTodoItem(Long id);
}
