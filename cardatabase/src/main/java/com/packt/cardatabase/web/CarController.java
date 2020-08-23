package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping(value = "/cars", method = GET)
    public Iterable<Car> getCars(){
        return repository.findAll();
    }
}
