package com.upc.TuCine.TuCine.service.impl;

import com.upc.TuCine.TuCine.dto.FilmDto;
import com.upc.TuCine.TuCine.model.ContentRating;
import com.upc.TuCine.TuCine.model.Film;
import com.upc.TuCine.TuCine.shared.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

/* @ExtendWith(MockitoExtension.class)*/
public class ValidateFilmTest {

/*  @InjectMocks
    private FilmServiceImpl filmService;*/
    
    @Test
    public void testValidFilm() {
        int filmYear = 2021;
        
        Film validFilm = new Film();
        validFilm.setTitle("Título de la película");
        validFilm.setDuration(120);
        validFilm.setSynopsis("Sinopsis de la película");

        try {
            validFilm.validateForCopyright(filmYear);
            validFilm.setYear(filmYear);
            validFilm.setContentRating(new ContentRating());

            assertEquals(validFilm.getYear(), filmYear);
        }
        catch (ValidationException e) {
            fail(e.getMessage());
        }
    }
/* 
    @Test
    public void testValidateFilmWithTitleNull() {
        FilmDto nullTitleFilm = new FilmDto();
        nullTitleFilm.setDuration(120);
        nullTitleFilm.setSynopsis("Sinopsis de la película");
        nullTitleFilm.setYear(2024);
        nullTitleFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(nullTitleFilm));
        assertEquals("El nombre de la película no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithEmptyTitle() {
        FilmDto emptyTitleFilm = new FilmDto();
        emptyTitleFilm.setTitle("");
        emptyTitleFilm.setDuration(120);
        emptyTitleFilm.setSynopsis("Sinopsis de la película");
        emptyTitleFilm.setYear(2024);
        emptyTitleFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(emptyTitleFilm));
        assertEquals("El nombre de la película no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithDurationZero() {
        FilmDto zeroDurationFilm = new FilmDto();
        zeroDurationFilm.setTitle("Título de la película");
        zeroDurationFilm.setDuration(0);
        zeroDurationFilm.setSynopsis("Sinopsis de la película");
        zeroDurationFilm.setYear(2024);
        zeroDurationFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(zeroDurationFilm));
        assertEquals("La duración de la película no puede ser menor o igual a 0", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithDurationNull() {
        FilmDto nullDurationFilm = new FilmDto();
        nullDurationFilm.setTitle("Título de la película");
        nullDurationFilm.setSynopsis("Sinopsis de la película");
        nullDurationFilm.setYear(2024);
        nullDurationFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(nullDurationFilm));
        assertEquals("La duración de la película no puede ser menor o igual a 0", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithDurationNegative() {
        FilmDto negativeDurationFilm = new FilmDto();
        negativeDurationFilm.setTitle("Título de la película");
        negativeDurationFilm.setDuration(-1);
        negativeDurationFilm.setSynopsis("Sinopsis de la película");
        negativeDurationFilm.setYear(2024);
        negativeDurationFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(negativeDurationFilm));
        assertEquals("La duración de la película no puede ser menor o igual a 0", exception.getMessage());
    }



    @Test
    public void testValidateFilmWithSynopsisNull() {
        FilmDto nullSynopsisFilm = new FilmDto();
        nullSynopsisFilm.setTitle("Título de la película");
        nullSynopsisFilm.setDuration(120);
        nullSynopsisFilm.setYear(2024);
        nullSynopsisFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(nullSynopsisFilm));
        assertEquals("La sinopsis de la película no puede estar vacía", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithEmptySynopsis() {
        FilmDto emptySynopsisFilm = new FilmDto();
        emptySynopsisFilm.setTitle("Título de la película");
        emptySynopsisFilm.setDuration(120);
        emptySynopsisFilm.setSynopsis("");
        emptySynopsisFilm.setYear(2024);
        emptySynopsisFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(emptySynopsisFilm));
        assertEquals("La sinopsis de la película no puede estar vacía", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithYearZero() {
        FilmDto zeroYearFilm = new FilmDto();
        zeroYearFilm.setTitle("Título de la película");
        zeroYearFilm.setDuration(120);
        zeroYearFilm.setSynopsis("Sinopsis de la película");
        zeroYearFilm.setYear(0);
        zeroYearFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(zeroYearFilm));
        assertEquals("El año de la película no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithYearNegative() {
        FilmDto negativeYearFilm = new FilmDto();
        negativeYearFilm.setTitle("Título de la película");
        negativeYearFilm.setDuration(120);
        negativeYearFilm.setSynopsis("Sinopsis de la película");
        negativeYearFilm.setYear(-1);
        negativeYearFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(negativeYearFilm));
        assertEquals("El año de la película no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithYearNull() {
        FilmDto nullYearFilm = new FilmDto();
        nullYearFilm.setTitle("Título de la película");
        nullYearFilm.setDuration(120);
        nullYearFilm.setSynopsis("Sinopsis de la película");
        nullYearFilm.setContentRating(new ContentRating());

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(nullYearFilm));
        assertEquals("El año de la película no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testValidateFilmWithContentRatingNull() {
        FilmDto nullContentRatingFilm = new FilmDto();
        nullContentRatingFilm.setTitle("Título de la película");
        nullContentRatingFilm.setDuration(120);
        nullContentRatingFilm.setSynopsis("Sinopsis de la película");
        nullContentRatingFilm.setYear(2024);

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.validateFilm(nullContentRatingFilm));
        assertEquals("La clasificación de la película no puede estar vacío", exception.getMessage());
    } */
}
