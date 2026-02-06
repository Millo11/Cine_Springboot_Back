package com.example.cine.controller;

import com.example.cine.dto.BillboardDTO;
import com.example.cine.Service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cinema") //endpoint
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    // GET localhost:8080/api/cinema/billboard?date=2026-02-05
    @GetMapping("/billboard")
    public List<BillboardDTO> getBillboard(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return cinemaService.getBillboardByDate(date);
    }
}
