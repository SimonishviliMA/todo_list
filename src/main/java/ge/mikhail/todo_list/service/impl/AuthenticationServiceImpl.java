package ge.mikhail.todo_list.service.impl;

import ge.mikhail.todo_list.dto.UserDto;
import ge.mikhail.todo_list.service.AuthenticationService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @SneakyThrows
    @Override
    public UserDto getUserInfo() {
        log.info("Get User info");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
        Long id = userDetails.getAttribute("id");
        String login = userDetails.getAttribute("login");
        log.info("Got user info: id = {}; login = {}", id, login);
        return new UserDto(id, login);
    }
}
