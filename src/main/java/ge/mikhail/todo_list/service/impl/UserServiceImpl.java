package ge.mikhail.todo_list.service.impl;

import ge.mikhail.todo_list.dto.request.UserRequest;
import ge.mikhail.todo_list.dto.response.SaveUserResponse;
import ge.mikhail.todo_list.entity.UserTable;
import ge.mikhail.todo_list.mapper.UserMapper;
import ge.mikhail.todo_list.repository.UserRepository;
import ge.mikhail.todo_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public SaveUserResponse saveUser(UserRequest request) {
        UserTable user = userRepository.save(
                userMapper.requestToEntity(request)
        );
        return new SaveUserResponse(user.getId());
    }
}
