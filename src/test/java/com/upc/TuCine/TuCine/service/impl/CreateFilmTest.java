package com.upc.TuCine.TuCine.service.impl;
import com.upc.TuCine.TuCine.dto.ContentRatingDto;
import com.upc.TuCine.TuCine.dto.FilmDto;
import com.upc.TuCine.TuCine.dto.save.Film.FilmContentRatingSaveDto;
import com.upc.TuCine.TuCine.dto.save.Film.FilmSaveDto;
import com.upc.TuCine.TuCine.model.ContentRating;
import com.upc.TuCine.TuCine.model.Film;
import com.upc.TuCine.TuCine.repository.ContentRatingRepository;
import com.upc.TuCine.TuCine.repository.FilmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateFilmTest {
    @Mock
    private FilmRepository filmRepository;

    @Mock
    private ContentRatingRepository contentRatingRepository;

    @InjectMocks
    private FilmServiceImpl filmService;

    private ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateFilm() {
        // Arrange
        FilmSaveDto filmSaveDto = new FilmSaveDto();
        filmSaveDto.setTitle("Sample Film");
        filmSaveDto.setSynopsis("Sample Synopsis");
        filmSaveDto.setYear(2023); // Configurando un año válido
        filmSaveDto.setDuration(120);// Configurando una duración válida de 120 minutos
        

        // Crear un objeto FilmContentRatingSaveDto y configurarlo
        FilmContentRatingSaveDto filmContentRatingSaveDto = new FilmContentRatingSaveDto();
        filmContentRatingSaveDto.setId(1); // Establecer el ID del contenido de clasificación
        filmSaveDto.setContentRating(filmContentRatingSaveDto); // Configurar el contenido de clasificación en FilmSaveDto

        // Mocking behavior of contentRatingRepository.findById
        ContentRating contentRating = new ContentRating();
        contentRating.setId(1);
        when(contentRatingRepository.findById(1)).thenReturn(Optional.of(contentRating));

        // Mocking behavior of filmRepository.save
        Film filmToSave = new Film();
        filmToSave.setId(1);
        filmToSave.setTitle("Sample Film");
        filmToSave.setSynopsis("Sample Synopsis");
        when(filmRepository.save(any())).thenReturn(filmToSave);

        // Act
        FilmDto createdFilmDto = filmService.createFilm(filmSaveDto);

        // Assert
        assertNotNull(createdFilmDto);
        assertEquals("Sample Film", createdFilmDto.getTitle());
        assertEquals("Sample Synopsis", createdFilmDto.getSynopsis());
        if (createdFilmDto.getContentRating() != null) {
            assertEquals(1, createdFilmDto.getContentRating().getId());
        } else {
            // Manejar la situación en la que getContentRating() devuelve null
            // Puedes lanzar una excepción, mostrar un mensaje de error, etc.
            fail("ContentRating is null");
        }
        verify(contentRatingRepository, times(1)).findById(1);
        verify(filmRepository, times(1)).save(any());
    }
}
