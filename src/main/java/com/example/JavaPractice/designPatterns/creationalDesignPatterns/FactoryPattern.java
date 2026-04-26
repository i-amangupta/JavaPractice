package com.example.JavaPractice.designPatterns.creationalDesignPatterns;

public class FactoryPattern {
    static interface Vehicle {
        void print();
    }
    static class Bike implements Vehicle {
        @Override
        public void print() {
            System.out.print("Bike");
        }
    }
    static class Car implements Vehicle {
        @Override
        public void print() {
            System.out.print("Car");
        }
    }
    static class VehicleFactory {
        public Vehicle getVehicle(String vehicleType) {
            if(vehicleType == "BIKE")
                return new Bike();
            else if(vehicleType == "CAR")
                return new Car();
            else
                return null;
        }
    }

    public static void main(String... args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getVehicle("BIKE");
        vehicle.print();
    }
}
