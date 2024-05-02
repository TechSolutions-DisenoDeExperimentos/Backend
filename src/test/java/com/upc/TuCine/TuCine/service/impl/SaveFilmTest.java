package com.upc.TuCine.TuCine.service.impl;
import com.upc.TuCine.TuCine.model.Film;
import com.upc.TuCine.TuCine.repository.FilmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SaveFilmTest {
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void setUp() {
        filmRepository = mock(FilmRepository.class); // Inicializar el mock antes de cada prueba
    }

    @Test
    void testSaveFilm() {
        // Arrange
        Film filmToSave = new Film();
        filmToSave.setId(1);
        filmToSave.setTitle("Sample Film");
        filmToSave.setSynopsis("Sample Synopsis");
        // Simular el comportamiento de filmRepository.save(film)
        when(filmRepository.save(filmToSave)).thenReturn(filmToSave);

        // Act
        Film savedFilm = filmRepository.save(filmToSave);

        // Assert
        assertNotNull(savedFilm);
        assertEquals(filmToSave.getId(), savedFilm.getId());
        assertEquals(filmToSave.getTitle(), savedFilm.getTitle());
        assertEquals(filmToSave.getSynopsis(), savedFilm.getSynopsis());
        // Verificar que se llamó al método save del repositorio
        verify(filmRepository, times(1)).save(filmToSave);
    }

    @Test
    void testSaveFilmFailed() {
        // Arrange
        Film filmToSave = new Film();
        filmToSave.setTitle("Sample Film");
        filmToSave.setSynopsis("Sample Synopsis");
        // Simular un fallo al guardar
        when(filmRepository.save(filmToSave)).thenThrow(new RuntimeException("Error al guardar la película"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> filmRepository.save(filmToSave));
        // Verificar que se llamó al método save del repositorio
        verify(filmRepository, times(1)).save(filmToSave);
    }
}

