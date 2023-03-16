package com.example.demo1.Service;

import com.example.demo1.Controller.Train;
import com.example.demo1.Entities.FoodOrder;
import com.example.demo1.Entities.Passenger;
import com.example.demo1.Repository.FoodOrderRepository;
import com.example.demo1.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    TrainRepo trainRepository;
    @Autowired
    FoodOrderRepository foodOrderRepository;
    public double getTotalFoodOrderPrice(Date date, int trainId) {
        Train train = trainRepository.findById(trainId).get();
        double totalPrice = 0.0;
        for (Passenger passenger : train.getPassengerList()) {
            if (passenger.getDate().equals(date)) {
                List<FoodOrder> foodOrders = foodOrderRepository.findByPassenger(passenger);
                for (FoodOrder foodOrder : foodOrders) {
                    totalPrice += foodOrder.getPrice();
                }
            }
        }
        return totalPrice;
    }

}
