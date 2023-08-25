package ge.mikhail.todo_list.service.impl;

import ge.mikhail.todo_list.dto.request.TodoItemRequest;
import ge.mikhail.todo_list.dto.response.BaseResponse;
import ge.mikhail.todo_list.dto.response.GetAllTodoItemsByUserIdResponse;
import ge.mikhail.todo_list.dto.response.SaveTodoItemResponse;
import ge.mikhail.todo_list.dto.response.TodoItemResponse;
import ge.mikhail.todo_list.entity.TodoItem;
import ge.mikhail.todo_list.enums.ErrorCode;
import ge.mikhail.todo_list.exception.GeneralException;
import ge.mikhail.todo_list.mapper.TodoItemMapper;
import ge.mikhail.todo_list.repository.TodoItemRepository;
import ge.mikhail.todo_list.service.AuthenticationService;
import ge.mikhail.todo_list.service.TodoItemService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;
    private final TodoItemMapper todoItemMapper;
    private final AuthenticationService authenticationService;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository, TodoItemMapper todoItemMapper, AuthenticationService authenticationService) {
        this.todoItemRepository = todoItemRepository;
        this.todoItemMapper = todoItemMapper;
        this.authenticationService = authenticationService;
    }

    @SneakyThrows
    @Override
    public GetAllTodoItemsByUserIdResponse getAllTodoItemsByUserId() {
        Long userId = authenticationService.getUserInfo().getId();
        log.info("Get Todo Items by user id = {}", userId);
        List<TodoItem> todoItems = todoItemRepository.findAllByUserId(userId);
        if (todoItems.isEmpty()) {
            throw new GeneralException(ErrorCode.NOT_FOUND, "TodoItem didn't find by id");
        }
        log.info("Got Todo Item by user id = {}", userId);
        return new GetAllTodoItemsByUserIdResponse(
                todoItems.stream()
                    .map(todoItemMapper::entityToResponse)
                    .collect(Collectors.toList())
        );
    }

    @Override
    public BaseResponse deleteAllTodoItemsByUserId() {
        Long userId = authenticationService.getUserInfo().getId();
        log.info("Delete Todo Items by user id = {}", userId);
        todoItemRepository.deleteAllByUserId(userId);
        log.info("Deleted Todo Items by user id = {}", userId);
        return new BaseResponse();
    }

    @SneakyThrows
    @Override
    public TodoItemResponse getTodoItemById(Long id) {
        log.info("Get Todo Item by id = {}", id);
        TodoItemResponse response = todoItemMapper.entityToResponse(
                todoItemRepository.findById(id)
                        .orElseThrow(() -> new GeneralException(ErrorCode.NOT_FOUND, "TodoItem didn't find by id"))
        );
        log.info("Got Todo Item by id = {}", id);
        return response;
    }

    @Override
    public SaveTodoItemResponse saveTodoItem(TodoItemRequest request) {
        Long userId = authenticationService.getUserInfo().getId();
        log.info("Save Todo Item: request = {}, userId = {}", request.toString(), userId);
        TodoItem todoItem = todoItemRepository.save(todoItemMapper.requestToEntity(request, userId));
        log.info("Saved Todo Item: id = {}", todoItem.getId());
        return new SaveTodoItemResponse(todoItem.getId());
    }

    @Override
    public BaseResponse deleteTodoItemById(Long id) {
        log.info("Delete Todo Item by id = {}", id);
        todoItemRepository.deleteById(id);
        log.info("Deleted Todo Item by id = {}", id);
        return new BaseResponse();
    }

    @SneakyThrows
    @Override
    public BaseResponse completedTodoItem(Long id) {
        log.info("Mark as completed Todo Item by id = {}", id);
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_FOUND, "TodoItem didn't find by id"));
        todoItem.setCompleted(true);
        todoItemRepository.save(todoItem);
        log.info("Marked as completed Todo Item by id = {}", id);
        return new BaseResponse();
    }
}
