package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Truck;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();

    private static VehicleRepository instance = new VehicleRepository();

    private VehicleRepository() {
        this.vehicles.add(new Car("Toyota", "Corolla",
                2020, "Red", "KR11"));
        this.vehicles.add(new Car("Kia", "Ceed",
                2020, "Yellow", "KR22"));
        this.vehicles.add(new Car("BMW", "5",
                2022, "Black", "KR33"));
        this.vehicles.add(new Car("Mercedes", "C",
                2019, "White", "KR44"));
        this.vehicles.add(new Car("Honda", "Civic",
                2020, "Red", "KR55"));
        this.vehicles.add(new Truck("Volvo", "Super", 2021, "Black", "KR666", 1000 ));
    }

    public boolean rentVehicle(String plate){
        for (Vehicle vehicle : this.vehicles){
            if (vehicle.getPlate().equals(plate) && !vehicle.isRent()){
                vehicle.setRent(true);
                return true;
            }
        }
        return false;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public static VehicleRepository getInstance() {
        return instance;
    }
}
