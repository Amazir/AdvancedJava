package pl.edu.wszib.car.rent.gui.impl;

import pl.edu.wszib.car.rent.gui.IGUI;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class GUIV2 implements IGUI {
    Scanner sc = new Scanner(System.in);

    @Override
    public String showMenuAndReadChoice(){
        System.out.println("11. List cars");
        System.out.println("22. Rent car");
        System.out.println("33. Exit");

        return this.sc.nextLine();
    }

    @Override
    public void listVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getBrand()+" "+vehicle.getModel()+" "+
                    vehicle.getColor()+" "+vehicle.getYear()+" "+vehicle.getPlate()+" "+
                    vehicle.isRent());
        }
    }

    @Override
    public String readPlate(){
        System.out.println("Enter plate: ");
        return sc.nextLine();
    }

    @Override
    public void showResultMessage(boolean s){
        System.out.println(s ? "success":"error");
    }

    @Override
    public User askForCredentials() {
        User user = new User();
        System.out.println("Enter login: ");
        user.setLogin(sc.nextLine());
        System.out.println("Enter password: ");
        user.setPassword(sc.nextLine());
        return user;
    }
}
