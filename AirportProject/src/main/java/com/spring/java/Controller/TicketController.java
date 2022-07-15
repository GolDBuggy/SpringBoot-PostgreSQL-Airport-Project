package com.spring.java.Controller;

import com.spring.java.Model.Ticket;
import com.spring.java.Service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;


    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> all(){
        return ticketService.all();
    }

   @PostMapping("/save")
    public Ticket save(@RequestBody Ticket ticket){
        ticketService.save(ticket);
        return ticket;
    }


    @PutMapping("/update")
    public Ticket update(@RequestBody Ticket ticket){
        ticketService.updateTicket(ticket);
        return ticket;
    }

    @DeleteMapping("/delete")
    public String deleteAll(){
        ticketService.deleteAll();
        return "deleted all tickets!";
    }



  



}
