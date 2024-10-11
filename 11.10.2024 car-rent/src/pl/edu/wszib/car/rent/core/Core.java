package pl.edu.wszib.car.rent.core;

import pl.edu.wszib.car.rent.db.CarRepository;
import pl.edu.wszib.car.rent.gui.GUI;
import pl.edu.wszib.car.rent.gui.GUIInterface;
import pl.edu.wszib.car.rent.gui.GUIV2;

public class Core {

    private CarRepository carRepository = CarRepository.getInstance();
    private GUIInterface gui = GUI.getInstance();

    private static Core instance = new Core();

    private Core(){}

    public void run(){
        boolean running = true;

        while(running){
            switch (gui.showMenuAndReadChoice()){
                case "1":
                    gui.listCars(this.carRepository.getCars());
                    break;
                case "2":
                    this.gui.showResultMessage(this.carRepository.rentCar(this.gui.readPlate()));
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect option.");
                    break;
            }
        }

    }

    public static Core getInstance() {
        return instance;
    }
}
