package ge.mikhail.todo_list.repository;

import ge.mikhail.todo_list.entity.UserTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserTable, Long> {
}
