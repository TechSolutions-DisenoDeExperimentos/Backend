package com.upc.TuCine.TuCine.service.impl;

import com.upc.TuCine.TuCine.model.Film;
import com.upc.TuCine.TuCine.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindByIdTest {

    @Mock
    private FilmRepository filmRepository;

    @Test
    void testFindFilmById() {
        // Arrange
        int filmId = 1;
        Film expectedFilm = new Film();
        expectedFilm.setId(filmId);
        when(filmRepository.findById(filmId)).thenReturn(Optional.of(expectedFilm));

        // Act
        Optional<Film> actualFilmOptional = filmRepository.findById(filmId);

        // Assert
        assertTrue(actualFilmOptional.isPresent());
        assertEquals(expectedFilm, actualFilmOptional.get());
    }

    @Test
    void testFindFilmByIdNotFound() {
        // Arrange
        int nonExistentFilmId = 100; // Suponemos que no existe una película con este ID
        when(filmRepository.findById(nonExistentFilmId)).thenReturn(Optional.empty());

        // Act
        Optional<Film> actualFilmOptional = filmRepository.findById(nonExistentFilmId);

        // Assert
        assertFalse(actualFilmOptional.isPresent()); // Verifica que no se haya encontrado ninguna película
    }

    @Test
    void testFindFilmByIdWithNegativeId() {
        // Arrange
        when(filmRepository.findById(-1)).thenThrow(IllegalArgumentException.class);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> filmRepository.findById(-1));
    }

    @Test
    void testFindFilmByIdWithNullId() {
        // Arrange
        when(filmRepository.findById(null)).thenThrow(IllegalArgumentException.class);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> filmRepository.findById(null));
    }

    @Test
    void testFindFilmByIdThrowsException() {
        // Arrange
        int filmId = 1;
        when(filmRepository.findById(filmId)).thenThrow(new RuntimeException("Error al buscar película por ID"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> filmRepository.findById(filmId));
    }
}
