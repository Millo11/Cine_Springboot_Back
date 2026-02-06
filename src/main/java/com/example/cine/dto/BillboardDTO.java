package com.example.cine.dto;

import java.time.LocalTime;
import java.util.List;

public class BillboardDTO {
    private String movieTitle;
    private String classification;
    private List<LocalTime> showtimes;

    //constructor
    public BillboardDTO(String movieTitle, String classification, List<LocalTime> showtimes){
        this.movieTitle = movieTitle;
        this.classification = classification;
        this.showtimes = showtimes;
    }

    //Getter and Setter

    public String getMovieTitle(){
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }
    public String getClassification(){
        return classification;
    }
    public void setClassification(String classification){
        this.classification = classification;
    }
    public List<LocalTime> getShowtimes(){
        return showtimes;
    }
    public void setShowtimes(List<LocalTime> showtimes){
        this.showtimes = showtimes;
    }

}
