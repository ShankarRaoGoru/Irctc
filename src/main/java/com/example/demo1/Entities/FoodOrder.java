package com.example.demo1.Entities;

import javax.persistence.*;

/*Create an IRCTC system:

        Train = TrainNo, Source, Destination
        Passenger = TicketId, TrainId ,Date, Age, Gender
        FoodOrder = TicketId, TrainId, Price

        POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
        POST API - Add a Train with trainNo , source ,destination .
        1.GET API - Find the Number of passengers travelling from City X and City Y on Date D
        2.GET API - Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.
*/
@Entity
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TicketId;
    private int TrainId;
    int price;
    @ManyToOne
    @JoinColumn
    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public FoodOrder() {
    }

    public FoodOrder(int ticketId, int trainId, int price) {
        TicketId = ticketId;
        TrainId = trainId;
        this.price = price;
    }

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public int getTrainId() {
        return TrainId;
    }

    public void setTrainId(int trainId) {
        TrainId = trainId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
