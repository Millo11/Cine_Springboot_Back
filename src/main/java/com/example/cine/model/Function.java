package com.example.cine.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
//entidad JPA (encargada de convertir automaticamente objetos java en filas de una tabla SQL)

//@Entity es para decir que el codigo representa una tabla en la base de datos
//@Table es para indicar el nombre de la tabla en la BDD
@Entity
@Table(name = "funciones")
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //le indica que la BDD genera el numero del ID
    @Column(name = "id_funcion") // Mapea a la columna original 'id_funcion'
    private Integer functionId;

    @Column(name = "fecha_hora") //conecta la variable con la columna "fecha_hora"
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Movie movie;

    //se necesita mapear id_sala si se planea mostrar la sala, se omitira por mientras

    //getter and setter

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }
}