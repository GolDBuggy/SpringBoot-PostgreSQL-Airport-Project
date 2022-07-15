package com.spring.java.Service;

import com.spring.java.ExceptionHandler.NotFoundException;
import com.spring.java.Model.Airport;
import com.spring.java.Repository.AirportRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepo repo;

    public ResponseEntity<List<Airport>> all(){
        return ResponseEntity.ok(repo.findAll());
    }


    public void save(Airport airport){
        repo.save(airport);
    }

    public String deleteAll(){
        repo.deleteAll();
        return "Butun veriler silindi!";
    }


    public Airport findByCode(String name){
        Airport airport=repo.findAirportByCode(name);
        if(airport==null)
            throw new NotFoundException("Havaalanı bulunamadı!");
        return airport;
    }




}
