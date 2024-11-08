package pl.edu.wszib.car.rent.gui.impl;

import pl.edu.wszib.car.rent.gui.IGUI;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Truck;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class GUI implements IGUI {
    Scanner sc = new Scanner(System.in);

    private static GUI instance = new GUI();

    private GUI(){

    }

    @Override
    public String showMenuAndReadChoice(){
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Exit");

        return this.sc.nextLine();
    }

    @Override
    public void listVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            final String SEPARATOR = " ";
            StringBuilder sb = new StringBuilder();

            String result = sb.append(vehicle.getBrand()).append(SEPARATOR).append(vehicle.getModel()).append(SEPARATOR)
                    .append(vehicle.getColor()).append(SEPARATOR).append(vehicle.getYear()).append(SEPARATOR).append(vehicle.getPlate())
                    .append(SEPARATOR).append(vehicle.isRent()).append(SEPARATOR).append(vehicle.isRent() ? "wynajety":"Nie wynajety").append(SEPARATOR).append(vehicle instanceof Truck ? ((Truck) vehicle).getCapacity() : SEPARATOR).toString();

            System.out.println(result);
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

    public static GUI getInstance() {
        return instance;
    }
}
