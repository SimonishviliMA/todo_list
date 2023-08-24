package ge.mikhail.todo_list.service.impl;

import ge.mikhail.todo_list.dto.UserDto;
import ge.mikhail.todo_list.service.AuthenticationService;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @SneakyThrows
    @Override
    public UserDto getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
        Long id = userDetails.getAttribute("id");
        String login = userDetails.getAttribute("login");
        return new UserDto(id, login);
    }
}
