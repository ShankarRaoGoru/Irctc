package com.example.demo1.Service;

import com.example.demo1.Controller.Train;
import com.example.demo1.Entities.Passenger;
import com.example.demo1.Enums.Gender;
import com.example.demo1.Repository.PassengerRepo;
import com.example.demo1.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PassengerService {
    @Autowired
    PassengerRepo passengerRepo;
    @Autowired
    TrainRepo trainRepo;
    public String addPassenger(Passenger passenger){
        Train train=passenger.getTrain();
        train.getPassengerList().add(passenger);
        passenger.setTrain(train);
        trainRepo.save(train);
        return "passenger added";
    }
    public int getpasscount(String cityX, String cityY, Date date){
        int count = 0;
        for (Train train : trainRepo.findAll()) {
            for (Passenger passenger : train.getPassengerList()) {
                if (passenger.getDate().equals(date) && passenger.getTrain().getSource().equals(cityX)
                        && passenger.getTrain().getDestination().equals(cityY)) {
                    count++;
                }
            }
        }
        return count;
    }
    public int getFemalePassengerCount(String destination,int  minAge, int maxAge){
        int femalePassengerCount = 0;

        for (Train train : trainRepo.findAll()) {
            for (Passenger passenger : train.getPassengerList()) {
                if (passenger.getGender().equals(Gender.FEMALE)
                        && passenger.getAge() >= minAge
                        && passenger.getAge() <= maxAge
                        && train.getDestination().equalsIgnoreCase(destination)) {
                    femalePassengerCount++;
                }
            }
        }

        return femalePassengerCount;
    }


    }






