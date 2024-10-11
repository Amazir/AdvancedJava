package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.Car;
import java.util.List;
import java.util.Scanner;

public class GUI implements GUIInterface {
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
    public void listCars(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getBrand()+" "+car.getModel()+" "+
                    car.getColor()+" "+car.getYear()+" "+car.getPlate()+" "+
                    car.isRent());
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

    public static GUI getInstance() {
        return instance;
    }
}
