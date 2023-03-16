package com.example.demo1.Entities;

import com.example.demo1.Controller.Train;
import com.example.demo1.Enums.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name="passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TicketId;
    private int TraindId;
    Date date;
    int age;
    String gender;
    @Enumerated(EnumType.STRING)
    private Gender gender1;
    @ManyToOne
    @JoinColumn
    private  Train train;
    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrderList=new ArrayList<>();

    public Passenger() {
    }

    public Passenger(int ticketId, int traindId, Date date, int age, String gender) {
        TicketId = ticketId;
        TraindId = traindId;
        this.date = date;
        this.age = age;
        this.gender = gender;
    }

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public int getTraindId() {
        return TraindId;
    }

    public void setTraindId(int traindId) {
        TraindId = traindId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<FoodOrder> getFoodOrderList() {
        return foodOrderList;
    }

    public void setFoodOrderList(List<FoodOrder> foodOrderList) {
        this.foodOrderList = foodOrderList;
    }
}
