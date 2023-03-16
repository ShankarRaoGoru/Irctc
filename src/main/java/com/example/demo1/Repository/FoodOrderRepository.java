package com.example.demo1.Repository;

import com.example.demo1.Entities.FoodOrder;
import com.example.demo1.Entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class FoodOrderRepository implements JpaRepository<FoodOrder, Integer> {

    public List<FoodOrder> findByPassenger(Passenger passenger) {
        return null;
    }

}
