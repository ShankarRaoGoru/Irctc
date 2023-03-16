package com.example.demo1.Repository;

import com.example.demo1.Entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}
