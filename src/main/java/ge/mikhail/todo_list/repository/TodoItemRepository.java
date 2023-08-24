package ge.mikhail.todo_list.repository;

import ge.mikhail.todo_list.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
    List<TodoItem> findAllByUserId(Long userId);

    void deleteAllByUserId(Long userId);
}
