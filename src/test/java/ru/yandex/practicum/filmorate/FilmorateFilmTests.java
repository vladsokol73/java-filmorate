package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.controller.FilmController;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmorateFilmTests {

    @Autowired
    private FilmController filmController;

    @BeforeEach
    public void clearDB() {
        filmController.deleteFilms();
    }



    @Test
    public void filmControllerInvalidNameTest() {
        Film film = new Film(1L, "", "desc Example", LocalDate.of(2000, 1, 1)
                , 100, 0L);

        assertThrows(RuntimeException.class, () -> filmController.createFilm(film));
        film.setName(null);
        assertThrows(NullPointerException.class, () -> filmController.createFilm(film));
    }

    @Test
    public void filmControllerInvalidLengthDescriptionTest() {
        String s = "";
        for (int i = 0; i < 41; i++) {
            s += "desc ";
        }
        Film film = new Film(1L, "Example", s, LocalDate.of(2000, 1, 1)
                , 100, 0L);

        assertThrows(RuntimeException.class, () -> filmController.createFilm(film));
    }

    @Test
    public void filmControllerInvalidDateReleaseTest() {
        Film film = new Film(1L, "Example", "desc Example"
                , LocalDate.of(1895, 12, 27)
                , 100, 0L);
        assertThrows(RuntimeException.class, () -> filmController.createFilm(film));
    }

    @Test
    public void filmControllerInvalidDurationTest() {
        Film film = new Film(1L, "Example", "desc Example"
                , LocalDate.of(2000, 1, 1), 100, 0L);
        assertThrows(RuntimeException.class, () -> filmController.createFilm(film));
        film.setDuration(0);
        assertThrows(RuntimeException.class, () -> filmController.createFilm(film));
    }

