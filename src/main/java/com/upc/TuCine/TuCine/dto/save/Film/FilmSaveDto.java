package com.upc.TuCine.TuCine.dto.save.Film;

import lombok.Data;

@Data
public class FilmSaveDto {
    private String title;
    private Integer year;
    private String synopsis;
    private String posterSrc;
    private String trailerSrc;
    private Integer duration;
    private FilmContentRatingSaveDto contentRating;
}
