package com.travis.aptech.session10;

public class FourWheeler extends Vehicle {
    private boolean powerSteer;

    public FourWheeler(String vId, String vName, int numWheels, boolean powerSteer) {
        super(vId, vName, numWheels);
        this.powerSteer = powerSteer;
    }

    public void showDetails() {
        System.out.println("Vehicle No: " + this.vehicleNo);
        System.out.println("Vehicle Name: " + this.vehicleName);
        System.out.println("Number of Wheels: " + this.wheels);

        if (powerSteer) {
            System.out.println("Power Steering: Yes");
        } else {
            System.out.println("Power Steering: No");
        }
    }

    public void accelerate(int speed) {
        super.accelerate(speed);
        System.out.println("Maximum acceleration: " + speed + " kmph");
    }
}
