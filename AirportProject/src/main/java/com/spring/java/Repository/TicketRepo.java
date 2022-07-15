package com.spring.java.Repository;

import com.spring.java.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepo extends JpaRepository<Ticket,String> {

    @Query("select count(departure)  from Ticket  where (departure=:name or turn=:name)  and (departure=:name1 or turn=:name1)")
    public int countTicketByDeparture(@Param("name") String name,@Param("name1") String name1);

 
}
