package com.example.demo1.Controller;

import com.example.demo1.Entities.Passenger;
import com.example.demo1.Service.PassengerService;
import com.example.demo1.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo1.Controller.Train;

/*Create an IRCTC system:

        Train = TrainNo, Source, Destination
        Passenger = TicketId, TrainId ,Date, Age, Gender
        FoodOrder = TicketId, TrainId, Price

        POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
        POST API - Add a Train with trainNo , source ,destination .
        1.GET API - Find the Number of passengers travelling from City X and City Y on Date D
        2.GET API - Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.
*/
@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    TrainService trainService;
    @PostMapping("/addtrain")
    public ResponseEntity addTrain(@RequestBody Train train){
        String response=trainService.addTrain(train);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }







}
