package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controller.UserController;
import ru.yandex.practicum.filmorate.model.User;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class UserControllerTest {
    UserController userController = new UserController();

    @Test
    public void shouldMailWasBlank() {
        User user = User.builder()
                .name("jojo")
                .email("")
                .login("bebra")
                .birthday(LocalDateTime.of(1999, 9, 21, 0, 0))
                .build();

        Assertions.assertEquals(userController.createUser(user), user, "ошибка валидации");
    }

    @Test
    public void shouldMailWasIncorrect() {
        User user = User.builder()
                .name("jojo")
                .email("bober")
                .login("bebra")
                .birthday(LocalDateTime.of(1999, 9, 21, 0, 0))
                .build();

        Assertions.assertEquals(userController.createUser(user), user, "ошибка валидации");
    }

    @Test
    public void shouldLoginWasIncorrect() {
        User user = User.builder()
                .name("jojo")
                .email("bsbs@list.ru")
                .login("asdd dd")
                .birthday(LocalDateTime.of(1999, 9, 21, 0, 0))
                .build();

        Assertions.assertEquals(userController.createUser(user), user, "ошибка валидации");
    }

    @Test
    public void shouldLoginWasBlank() {
        User user = User.builder()
                .name("jojo")
                .email("bsbs@list.ru")
                .login("")
                .birthday(LocalDateTime.of(1999, 9, 21, 0, 0))
                .build();

        Assertions.assertEquals(userController.createUser(user), user, "ошибка валидации");
    }

    @Test
    public void shouldTimeWasFuture() {
        User user = User.builder()
                .name("")
                .email("bsbs@list.ru")
                .login("bebra")
                .birthday(LocalDateTime.of(2025, 9, 21, 0, 0))
                .build();
        userController.createUser(user);
        Assertions.assertEquals(userController.createUser(user), user, "ошибка валидации");
    }

}
