package com.upc.TuCine.TuCine.service.impl;
import com.upc.TuCine.TuCine.repository.FilmRepository;
import com.upc.TuCine.TuCine.shared.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ExistsFilmByTitleTest {
/*     @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmServiceImpl filmService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testExistsFilmByTitle_WithTitleExists_ThrowsValidationException() {
        String existingTitle = "Existing Film";
        when(filmRepository.existsFilmByTitle(existingTitle)).thenReturn(true);

        ValidationException exception = assertThrows(ValidationException.class, () -> filmService.existsFilmByTitle(existingTitle));

        assertEquals("No se puede agregar la película, puesto que una con su mismo titulo ya existe", exception.getMessage());
    }

    @Test
    void testExistsFilmByTitle_WithTitleDoesNotExist_DoesNotThrowException() {
        String nonExistingTitle = "Non Existing Film";
        when(filmRepository.existsFilmByTitle(nonExistingTitle)).thenReturn(false);

        assertDoesNotThrow(() -> filmService.existsFilmByTitle(nonExistingTitle));
    } */
}
