import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements CarInterface {
    // member fields:
        //

    // A list of cars, modify if needed
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
    //ArrayList<TruckWithBed> trucks = new ArrayList<>();
    Workshop<Volvo240> workshop = new Workshop<>(2);
    //methods:
    //CarView frame;

    public CarController() {
        // TODO: Ändra så att vehicles läggs till i en metod / och kan läggas till vid anrop
        vehicles.add(VehicleFactory.CreateVolvo());
        vehicles.add(VehicleFactory.CreateSaab());
        vehicles.add(VehicleFactory.CreateScania());


    }
    public void Update(int frameWidth){
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof Volvo240 && workshop.checkIfCarInWorkshop((Volvo240) vehicles.get(i))){
                continue;
            }

            if(vehicles.get(i).getPosX() >= frameWidth - 100){
                vehicles.get(i).posX =  frameWidth - 100;
                vehicles.get(i).stopEngine();
                vehicles.get(i).turnLeft();
                vehicles.get(i).turnLeft();
                vehicles.get(i).startEngine();
            }
            if(vehicles.get(i).getPosX() < 0){
                vehicles.get(i).posX = 0;
                vehicles.get(i).stopEngine();
                vehicles.get(i).turnLeft();
                vehicles.get(i).turnLeft();
                vehicles.get(i).startEngine();

            }
            // TODO: lägg till så att bilarna inte åker ur skärmen.
            vehicles.get(i).posY = 100 * i;

            vehicles.get(i).move();
            int x = (int) Math.round(vehicles.get(i).getPosX());
            int y = (int) Math.round(vehicles.get(i).getPosY());

            if (vehicles.get(i) instanceof Volvo240 && x > 300 && x < 400) {
                vehicles.get(i).stopEngine();
                //vehicles.remove(vehicle);
                workshop.loadCar((Volvo240) vehicles.get(i));
                continue;
            }
        }

    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            try{
                vehicle.gas(gas);
            }
            catch (Exception e){
                continue;
            }
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
    public void startAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }
    public void stopAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    public void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }
    public void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }
    public void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).increaseBedAngle(10);
            }
        }
    }
    public void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).decreaseBedAngle(10);
            }
        }
    }

    public void addCar(int index) {
        if (index == 0) {
            vehicles.add(VehicleFactory.CreateVolvo());
        }
        else if (index == 1) {
            vehicles.add(VehicleFactory.CreateSaab());
        }
        else if (index == 2) {
            vehicles.add(VehicleFactory.CreateScania());
        }
    }

    public void removeCar(int index) {

        if (index == 0) {
            System.out.println("Hejejejejej");
            for (int i = vehicles.size()-1; i >= 0; i--) {
                if (vehicles.get(i) instanceof Volvo240) {
                    vehicles.remove(vehicles.get(i));
                    break;
                }
            }
        }
        else if (index == 1) {
            System.out.println("Hejejejejej");
            for (int i = vehicles.size() - 1; i >= 0; i--) {
                if (vehicles.get(i) instanceof Saab95) {
                    vehicles.remove(vehicles.get(i));
                    break;
                }
            }
        }
        else if (index == 2) {
            for (int i = vehicles.size() - 1; i >= 0; i--) {
                if (vehicles.get(i) instanceof Scania) {
                    vehicles.remove(vehicles.get(i));
                    break;
                }
            }
        }
    }

}