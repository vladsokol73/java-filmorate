package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
public class UserController {
    protected HashMap<Integer, User> users;
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user) {
        if (user.getEmail().isBlank() || user.getEmail().contains("@") != true || user.getLogin().isBlank() ||
                user.getLogin().contains(" ") || user.getBirthday().isAfter(LocalDateTime.now())) {
            throw new ValidationException("ошибка валидации");
        } else {
            if (user.getName().isBlank()) {
                user.setName(user.getLogin());
            }
            users.put(user.getId(), user);
            log.debug("Добавили юзера" + user);
        }
        return user;
    }

    @PostMapping(value = "/user-update")
    public User updateUser(@RequestBody User user) {
        if (user != null) {
            users.put(user.getId(), user);
            log.debug("Обновили юзера" + user);
        }
        return user;
    }

    @GetMapping("/users")
    public HashMap getAllUsers() {
        return users;
    }
}