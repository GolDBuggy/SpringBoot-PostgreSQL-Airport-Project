package com.spring.java.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    private String id;

    @Column(name = "departure")
    private String departure;

    @Column(name = "departure_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date departureDate;

    @Column(name = "turn")
    private String turn;

    @Column(name = "turn_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date turnDate;

    @ManyToOne
    @JoinColumn(name = "ticket_customer")
    private Customer customer;


}
