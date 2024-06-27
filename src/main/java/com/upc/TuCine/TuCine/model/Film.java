package com.upc.TuCine.TuCine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Film")
public class Film {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name = "synopsis", length = 5000, nullable = false)
    private String synopsis;
    @Column(name = "poster_src",nullable = false)
    private String posterSrc;
    @Column(name = "trailer_src",nullable = false)
    private String trailerSrc;
    @Column(name = "duration", nullable = false)
    private Integer duration;


/*    private Integer contentRatingId;*/

    @ManyToOne
    @JoinColumn(name = "content_rating_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FILM_CONTENTRATING"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ContentRating contentRating;

    @JsonIgnore
    @ManyToMany
    private List<Actor> actors;

    @JsonIgnore
    @ManyToMany
    private List<Category> categories;

    public void validateForCopyright(int year){
        if(year >= LocalDate.now().getYear() - 2){
            throw new Error("No se puede crear este film por temas de precaucion hacia derechos de autor");
        }
    }

}
