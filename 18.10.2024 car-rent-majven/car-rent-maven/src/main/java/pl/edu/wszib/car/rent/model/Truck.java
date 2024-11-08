package pl.edu.wszib.car.rent.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Truck extends Vehicle {
    private int capacity;
    public Truck(String brand, String model, int year, String color, String plate, int capacity) {
        super(brand, model, year, color, plate, false);
        this.capacity = capacity;
    }
}
