package com.spring.java.Controller;

import com.spring.java.Model.Customer;
import com.spring.java.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService service;


    @GetMapping("/all")
    public ResponseEntity<List<Customer>> all(){
        return service.all();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        service.save(customer);
        return customer;
    }


    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer){
        service.save(customer);
        return customer;
    }

    @GetMapping("/find/{id}")
    public Customer get(@PathVariable int id){
         return    service.findId(id);
    }

    @DeleteMapping("/delete")
    public String delete(){
        return service.deleteAll();

    }
}
