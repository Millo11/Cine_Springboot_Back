package com.example.cine.Service;

import com.example.cine.dto.BillboardDTO;
import com.example.cine.model.Function;
import com.example.cine.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    @Autowired
    private FunctionRepository functionRepository;

    public List<BillboardDTO> getBillboardByDate(LocalDate date){
        //define el rango del dia (00:00:00 - 23:59:59)
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        //trae las funciones de la DB usando enl nuevo nombre del metodo
        List<Function> functionsOfDay = functionRepository.findByDateTimeBetween(startOfDay, endOfDay);

        //agrupa por titulo de la pelicula
        Map<String, List<Function>> groupedFunctions = functionsOfDay.stream().collect(Collectors.groupingBy(f -> f.getMovie().getTitle()));

        //convierte a DTO list
        List<BillboardDTO> billboard = new ArrayList<>();

        groupedFunctions.forEach((title, functionList) -> {
            //obtiene clasificacion de la primera pelicula de la lista
            String classification = functionList.get(0).getMovie().getClassification();

            List<LocalTime> showtimes = functionList.stream()
                    .map(f -> f.getDateTime().toLocalTime())
                    .sorted() // Good practice: order showtimes
                    .collect(Collectors.toList());

            billboard.add(new BillboardDTO(title, classification, showtimes));
        });

        return billboard;
    }
}
