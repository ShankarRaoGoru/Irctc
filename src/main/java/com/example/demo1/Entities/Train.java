package com.example.demo1.Controller;

import com.example.demo1.Entities.Passenger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
Create an IRCTC system:

Train = TrainNo, Source, Destination
Passenger = TicketId, TrainId ,Date, Age, Gender
FoodOrder = TicketId, TrainId, Price

POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
POST API - Add a Train with trainNo , source ,destination .
1.GET API - Find the Number of passengers travelling from City X and City Y on Date D
2.GET API - Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.

 */
@Entity
@Table(name="Train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TrainNo ;
    private String Source;
    private String Destination;

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<Passenger> passengerList=new ArrayList<>();

    public Train() {
    }

    public Train(int trainNo, String source, String destination) {
        TrainNo = trainNo;
        Source = source;
        Destination = destination;
    }

    public int getTrainNo() {
        return TrainNo;
    }

    public void setTrainNo(int trainNo) {
        TrainNo = trainNo;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }
}
