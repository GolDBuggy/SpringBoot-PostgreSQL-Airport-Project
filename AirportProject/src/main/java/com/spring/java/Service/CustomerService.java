package com.spring.java.Service;

import com.spring.java.ExceptionHandler.NotFoundException;
import com.spring.java.Model.Customer;
import com.spring.java.Repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CustomerService {

    Logger logger=Logger.getLogger(CustomerService.class.getName());


    private final CustomerRepo repo;

    public ResponseEntity<List<Customer>> all(){
        return ResponseEntity.ok(repo.findAll());
    }


    public void save(Customer customer){
            repo.save(customer);
    }

    public String deleteAll(){
        repo.deleteAll();
        logger.info("Butun veriler silindi!");
        return "Butun veriler silindi!";
    }


    public Customer findId(int id){
        Optional<Customer> customer=repo.findById(id);
        if(customer.isEmpty())
            throw new NotFoundException("Customer bulunamadı!");

        return customer.get();
    }


}
