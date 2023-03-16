package com.example.demo1.Controller;

import com.example.demo1.Repository.PassengerRepo;
import com.example.demo1.Service.FoodService;
import com.example.demo1.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;
    @GetMapping("/total-food-order-price")
    public ResponseEntity<Double> getTotalFoodOrderPrice(@RequestParam("date") Date date,
                                                         @RequestParam("trainId") int trainId) {
        double totalPrice = foodService.getTotalFoodOrderPrice(date, trainId);
        return ResponseEntity.ok(totalPrice);
    }
}
