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
    public void name() {
        Film film = Film.builder()
                .name("bibus")
                .description("sas")
                .releaseDate(LocalDateTime.now())
                .duration(Duration.ofHours(1))
                .build();
        Assertions.assertEquals(film.getName(), "bibus");
    }

    @Test
    public void shouldDescriptionWasOut() {
        Film film = Film.builder()
                .id(1)
                .name("jojo")
                .description("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                        "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                        "sssssssssssssssssssssss")
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
                .releaseDate(LocalDateTime.of(1895, 12, 28, 0, 1))
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
                .duration(Duration.ofHours(1))
                .build();

        Assertions.assertEquals(filmController.createFilm(film), film, "ошибка валидации");
    }
}
