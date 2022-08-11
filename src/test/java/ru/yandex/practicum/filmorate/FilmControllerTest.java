package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controller.FilmController;
import ru.yandex.practicum.filmorate.model.Film;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.time.LocalDateTime;

public class FilmControllerTest {
    FilmController filmController = new FilmController();

    @Test
    public void shouldNameWasBlank() {
        Film film = Film.builder()
                .name(" ")
                .description("sas")
                .releaseDate(LocalDateTime.now())
                .duration(Duration.ofHours(1))
                .build();

        Assertions.assertEquals(filmController.createFilm(film), film, "ошибка валидации");
    }

    @Test
    public void shouldDescriptionWasOut() {
        Film film = Film.builder()
                .name("jojo")
                .description("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                        "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                        "ssssssssssssssssssssssss")
                .releaseDate(LocalDateTime.now())
                .duration(Duration.ofHours(1))
                .build();

        Assertions.assertEquals(filmController.createFilm(film), film, "ошибка валидации");
    }

    @Test
    public void shouldDateWasBefore() {
        Film film = Film.builder()
                .name("jojo")
                .description("sas")
                .releaseDate(LocalDateTime.of(1895, 12, 27, 23, 59))
                .duration(Duration.ofHours(1))
                .build();

        Assertions.assertEquals(filmController.createFilm(film), film, "ошибка валидации");
    }

    @Test
    public void shouldDurationWasMinus() {
        Film film = Film.builder()
                .name("jojo")
                .description("sas")
                .releaseDate(LocalDateTime.now())
                .duration(Duration.ofHours(-1))
                .build();

        Assertions.assertEquals(filmController.createFilm(film), film, "ошибка валидации");
    }
}
