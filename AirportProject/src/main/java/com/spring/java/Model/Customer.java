package com.spring.java.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_mail")
    private String mail;

    @Column(name = "customer_phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Ticket> tickets;
}
