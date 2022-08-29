package ru.yandex.practicum.filmorate.validate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUserDataTest {
    static User user = new User(1L, "email@yandex.ru", "name", "login"
            , LocalDate.of(1994, 10, 1));

    @AfterEach
    public void user() {
        user = new User(1L, "email@yandex.ru", "name", "login"
                , LocalDate.of(1994, 10, 1));
    }

    @Test
    public void correctAllData() {
        assertTrue(new UserDataValidate(user).checkAllData());
    }

    @Test
    public void incorrectEmail() {
        user.setEmail("emailyandex.ru");
        assertFalse(new UserDataValidate(user).checkAllData());
    }

    @Test
    public void incorrectLogin() {
        user.setLogin("log in");
        assertFalse(new UserDataValidate(user).checkAllData());
    }

    @Test
    public void incorrectBirthday() {
        user.setBirthday(LocalDate.of(2025, 10, 1));
        assertFalse(new UserDataValidate(user).checkAllData());
    }
}