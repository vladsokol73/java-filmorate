package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controller.UserController;
import ru.yandex.practicum.filmorate.model.User;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class UserControllerTest {
    UserController userController = new UserController();

    @Test
    public void mail() {
        User user = User.builder()
                .id(1)
                .name("jojo")
                .email("sokol@list.ru")
                .login("bebra")
                .birthday(LocalDateTime.of(1999, 9, 21, 0, 0))
                .build();

        Assertions.assertEquals(userController.createUser(user).getEmail(), "sokol@list.ru");
    }

    @Test
    public void login() {
        User user = User.builder()
                .id(1)
                .name("jojo")
                .email("sokol@list.ru")
                .login("bebra")
                .birthday(LocalDateTime.of(1999, 9, 21, 0, 0))
                .build();

        Assertions.assertEquals(userController.createUser(user).getLogin(), "bebra");
    }

    @Test
    public void time() {
        User user = User.builder()
                .id(1)
                .name("jojo")
                .email("sokol@list.ru")
                .login("bebra")
                .birthday(LocalDateTime.now().minusSeconds(30))
                .build();
        Assertions.assertEquals(userController.createUser(user).getBirthday(), LocalDateTime.now().minusSeconds(30));
    }

    @Test
    public void name() {
        User user = User.builder()
                .id(1)
                .name("")
                .email("sokol@list.ru")
                .login("bebra")
                .birthday(LocalDateTime.now().minusSeconds(30))
                .build();
        Assertions.assertEquals(userController.createUser(user).getName(), "bebra");
    }
}
