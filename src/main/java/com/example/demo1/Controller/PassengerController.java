package com.example.demo1.Controller;

import com.example.demo1.Entities.Passenger;
import com.example.demo1.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/*
POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
        POST API - Add a Train with trainNo , source ,destination .
        1.GET API - Find the Number of passengers travelling from City X and City Y on Date D
        2.GET API - Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.
        */
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping("/addpassenger")
    public ResponseEntity addPassenger(@RequestBody Passenger passenger) {
        String response = passengerService.addPassenger(passenger);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/passengercount")
    public ResponseEntity passengerCount(@RequestParam("/cityx") String cityX, @RequestParam String cityY, @RequestParam Date date) {
        int response = passengerService.getpasscount(cityX, cityY, date);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/countFemalePassengers")
    public ResponseEntity getFemalePassengerCount(@RequestParam("/dest") String destination, @RequestParam("/minage") int minAge, @RequestParam("/maxage") int maxAge) {
        int res = passengerService.getFemalePassengerCount(destination, minAge, maxAge);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }
}
