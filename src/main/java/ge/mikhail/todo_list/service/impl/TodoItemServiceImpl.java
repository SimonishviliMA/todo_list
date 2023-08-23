package ge.mikhail.todo_list.service.impl;

import ge.mikhail.todo_list.dto.response.TodoItemResponse;
import ge.mikhail.todo_list.entity.TodoItem;
import ge.mikhail.todo_list.mapper.TodoItemMapper;
import ge.mikhail.todo_list.repository.TodoItemRepository;
import ge.mikhail.todo_list.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;
    private final TodoItemMapper todoItemMapper;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository, TodoItemMapper todoItemMapper) {
        this.todoItemRepository = todoItemRepository;
        this.todoItemMapper = todoItemMapper;
    }

    @Override
    public List<TodoItemResponse> getAllTodoItemsByUserId(Long userId) {
        List<TodoItem> todoItems = todoItemRepository.findAllByUserId(userId);
        return todoItems.stream()
                .map(todoItemMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
