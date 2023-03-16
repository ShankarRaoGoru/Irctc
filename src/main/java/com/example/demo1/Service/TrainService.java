package com.example.demo1.Service;

import com.example.demo1.Controller.Train;
import com.example.demo1.Entities.Passenger;
import com.example.demo1.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    TrainRepo trainRepo;
    public String addTrain(Train train){
        trainRepo.save(train);
        return "added";
    }
    public String addPassenger(Passenger passenger){
        Train train=passenger.getTrain();
        train.getPassengerList().add(passenger);
        passenger.setTrain(train);
        trainRepo.save(train);
        return "passenger added";


    }
    /*POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
        POST API - Add a Train with trainNo , source ,destination .
        1.GET API - Find the Number of passengers travelling from City X and City Y on Date D
        2.GET API - Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.
*/


}
