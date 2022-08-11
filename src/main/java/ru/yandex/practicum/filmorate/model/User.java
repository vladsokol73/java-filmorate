package ru.yandex.practicum.filmorate.model;

import java.time.LocalDateTime;

@lombok.Data
@lombok.Builder
public class User {
    protected int id;
    protected String email;
    protected String login;
    protected String name;
    protected LocalDateTime birthday;

    public User() {

    }
}
