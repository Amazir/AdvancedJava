package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.Car;
import java.util.List;
import java.util.Scanner;

public class GUIV2 implements GUIInterface {
    Scanner sc = new Scanner(System.in);

    @Override
    public String showMenuAndReadChoice(){
        System.out.println("11. List cars");
        System.out.println("22. Rent car");
        System.out.println("33. Exit");

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
}
