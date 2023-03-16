package com.example.demo1.Repository;

import com.example.demo1.Controller.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<Train,Integer> {
}
