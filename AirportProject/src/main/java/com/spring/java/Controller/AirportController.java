package com.spring.java.Controller;

import com.spring.java.Model.Airport;
import com.spring.java.Service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/airport")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService repo;

    @GetMapping("/all")
    public ResponseEntity<List<Airport>> all(){
        return repo.all();
    }

   @PostMapping("/save")
    public Airport save(@RequestBody Airport airport){
        repo.save(airport);
        return airport;
    }

    @PutMapping("/update")
    public Airport update(@RequestBody Airport airport){
        repo.save(airport);
        return airport;
    }

    @DeleteMapping("/delete")
    public String deleteAll(){
        repo.deleteAll();
        return "deleted all tickets!";
    }

    @GetMapping("/find/{airportcode}")
    public Airport findAirport(@PathVariable String airportcode){
       return repo.findByCode(airportcode);
    }



  



}
