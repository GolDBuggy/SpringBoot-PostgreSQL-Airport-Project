package com.spring.java.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "airport")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long id;

    @Column(name = "airport_code")
    private String code;

    @Column(name = "airport_location")
    private String location;
}
