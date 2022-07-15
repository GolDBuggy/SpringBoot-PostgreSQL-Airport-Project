package com.spring.java.Service;

import com.spring.java.ExceptionHandler.NotFoundException;
import com.spring.java.Model.Ticket;
import com.spring.java.Repository.TicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TicketService {

    Logger logger=Logger.getLogger(TicketService.class.getName());

    private final TicketRepo ticketRepo;

    public ResponseEntity<List<Ticket>> all(){
        return ResponseEntity.ok(ticketRepo.findAll());
    }


    public void save(Ticket ticket){
        try{
            ticket.setId(UUID.randomUUID().toString());
            control(ticket);
            ticketRepo.save(ticket);
        }catch (RuntimeException e){
            logger.info(e.getMessage());
        }
    }


    public void updateTicket(Ticket ticket){
        ticketRepo.save(ticket);
    }
    public String deleteAll(){
        ticketRepo.deleteAll();
        return "Butun veriler silindi!";
    }


    public Ticket findId(String id){
        Optional<Ticket> ticket=ticketRepo.findById(id);
        if(ticket.isEmpty())
            throw new NotFoundException("Ticket bulunamadı!");

        return ticket.get();
    }



    public void control(Ticket ticket){
        long diff=ticket.getTurnDate().getTime()-ticket.getDepartureDate().getTime();
        TimeUnit timeUnit=TimeUnit.DAYS;
        long differance= timeUnit.convert(diff,TimeUnit.MILLISECONDS);
        int count= ticketRepo.countTicketByDeparture(ticket.getDeparture(),ticket.getTurn())+1;
        if((count>3) && (differance <= 1) )
            throw new RuntimeException("Aynı gun icinde bu güzergahta en fazla 3 gidis-gelis yapılabilir!");
    }
}
