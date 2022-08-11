package ru.yandex.practicum.filmorate.model;

import java.time.Duration;
import java.time.LocalDateTime;

@lombok.Data
@lombok.Builder
public class Film {
    protected int id;
    protected String name;
    protected String description;
    protected LocalDateTime releaseDate;
    protected Duration duration;
}