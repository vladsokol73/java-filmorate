package ru.yandex.practicum.filmorate.validate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidateFilmDataTest {
    static Film film = new Film(1L, "film", "film1"
            , LocalDate.of(2021, 5, 21), 120, 0L);

    @AfterEach
    public void film() {
        film = new Film(1L, "film", "film1"
                , LocalDate.of(2021, 5, 21), 120, 0L);
    }


    @Test
    public void correctAllData() {
        assertTrue(new FilmDataValidate(film).checkAllData());
    }

    @Test
    public void inCorrectName() {
        film.setName("");
        assertFalse(new FilmDataValidate(film).checkAllData());
    }

    @Test
    public void inCorrectLengthDescription() {
        film.setDescription(" ".repeat(201));
        assertFalse(new FilmDataValidate(film).checkAllData());
    }

    @Test
    public void inCorrectReleaseDate() {
        film.setReleaseDate(LocalDate.of(1894, 5, 21));
        assertFalse(new FilmDataValidate(film).checkAllData());
    }

    @Test
    public void inCorrectDuration() {
        film.setDuration(-1);
        assertFalse(new FilmDataValidate(film).checkAllData());
    }

}