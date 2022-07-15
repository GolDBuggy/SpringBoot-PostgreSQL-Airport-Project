package com.spring.java.Repository;

import com.spring.java.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport,Long> {

    Airport findAirportByCode(String name);
}
