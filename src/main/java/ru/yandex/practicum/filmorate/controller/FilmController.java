package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
public class FilmController {
    protected HashMap<Integer, Film> films = new HashMap<>();
    private final static Logger log = LoggerFactory.getLogger(FilmController.class);

    @PostMapping(value = "/films")
    public Film createFilm(@RequestBody Film film) {
        if (film.getName().isBlank() || film.getDescription().length() > 200 || film.getReleaseDate().isBefore
                (LocalDateTime.of(1895, 12, 28, 0, 0)) || film.getDuration().
                isNegative() || film.getDuration().isZero()) {
            throw new ValidationException("ошибка валидации");
        } else {
            films.put(film.getId(), film);
            log.debug("Добавили фильм" + film);
        }
        return film;
    }

    @PostMapping(value = "/films")
    public Film updateFilm(@RequestBody Film film) {
        if (film.getName() == null || film.getDescription().length() > 200 || film.getReleaseDate().isBefore
                (LocalDateTime.of(1895, 12, 28, 0, 0)) || film.getDuration().
                isNegative() || film.getDuration().isZero()) {
            throw new ValidationException("ошибка валидации");
        } else {
            films.put(film.getId(), film);
            log.debug("Изменили фильм" + film);
        }
        return film;
    }

    @GetMapping("/films")
    public HashMap getAllFilms() {
        return films;
    }
}
