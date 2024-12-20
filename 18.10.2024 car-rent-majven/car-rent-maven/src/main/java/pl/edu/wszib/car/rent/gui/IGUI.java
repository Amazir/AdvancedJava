package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;

public interface IGUI {
    String showMenuAndReadChoice();
    void listVehicles(List<Vehicle> vehicles);
    String readPlate();
    void showResultMessage(boolean s);
    User askForCredentials();
}
