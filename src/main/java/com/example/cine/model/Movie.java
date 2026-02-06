package com.example.cine.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "peliculas")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula") // Mapea a la columna original 'id_pelicula'
    private Integer movieId;

    @Column(name = "titulo") // Mapea a la columna original 'titulo'
    private String title;

    @Column(name = "clasificacion") // Mapea a la columna original 'clasificacion'
    private String classification;

    @Column(name = "duracion_min") // Mapea explícitamente a la columna 'duracion_min'
    private Integer durationMin; // Mapea a duracion_min automáticamente por convención camelCase

    @OneToMany(mappedBy = "movie") // Debe coincidir con el nombre de la variable en la clase Function
    private List<Function> functions;
    // private List<Funcion> funciones;

    //getter and setter
    public Integer getMovieId(){
        return movieId;
    }

    public void setMovieId(Integer movieId){
        this.movieId = movieId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getClassification(){
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getDurationMin(){
        return durationMin;
    }

    public void setDurationMin(Integer durationMin){
        this.durationMin = durationMin;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }
}