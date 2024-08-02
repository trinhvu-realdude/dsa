package com.travis.aptech.session10;

public class Vehicle {
    protected String vehicleNo;
    protected String vehicleName;
    protected int wheels;

    public Vehicle(String vId, String vName, int numWheels) {
        this.vehicleNo = vId;
        this.vehicleName = vName;
        this.wheels = numWheels;
    }

    public void accelerate(int speed) {
        System.out.println("Accelerating at: " + speed + " kmph");
    }
}
