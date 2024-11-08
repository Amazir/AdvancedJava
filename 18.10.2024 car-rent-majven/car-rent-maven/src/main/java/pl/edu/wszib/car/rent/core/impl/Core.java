package pl.edu.wszib.car.rent.core.impl;

import pl.edu.wszib.car.rent.authentication.impl.Authenticator;
import pl.edu.wszib.car.rent.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.core.ICore;
import pl.edu.wszib.car.rent.db.VehicleRepository;
import pl.edu.wszib.car.rent.gui.impl.GUI;
import pl.edu.wszib.car.rent.gui.IGUI;

public class Core implements ICore {

    private VehicleRepository carRepository = VehicleRepository.getInstance();
    private IGUI gui = GUI.getInstance();
    private IAuthenticator authenticator = Authenticator.getInstance();

    private static Core instance = new Core();

    private Core(){}

    @Override
    public void run(){
        boolean running = false;

        int tries = 0;
        while(!running && tries<3){
            running = authenticator.authenticate(this.gui.askForCredentials());
            tries++;
        }

        while(running){
            switch (gui.showMenuAndReadChoice()){
                case "1":
                    gui.listVehicles(this.carRepository.getVehicles());
                    break;
                case "2":
                    this.gui.showResultMessage(this.carRepository.rentVehicle(this.gui.readPlate()));
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
