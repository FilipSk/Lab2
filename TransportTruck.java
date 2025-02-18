import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class TransportTruck extends Truck{

    private int numOfCars;
    private int maxNumOfCars = 10;
    private double maxCarSize = 5; // Längd i meter
    private boolean rampIsUp;
    private double maxDistance;
    private Stack<Car> cars = new Stack<>();

    public TransportTruck() {
        super(2, 1000, Color.blue, "Volvo Truck");
    }

    public Stack<Car> carStack() {
        return cars;
    }

    @Override
    protected void incrementSpeed(double amount) {
        if (!rampIsUp){
            throw new IllegalArgumentException("Rampen är uppe!");
        }
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    protected void decrementSpeed(double amount) {
        if (!rampIsUp){
            throw new IllegalArgumentException("Rampen är uppe!");
        }
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    @Override
    public void move() {
        super.move();
        for (Car car : cars) {
            setCarPos(car);
        }
    }

    @Override
    public double speedFactor() {
        return this.getEnginePower() / 100;
    }
    private void setCarPos(Car car){
        car.posX = this.posX;
        car.posY = this.posY;
    }
    public void loadCar(Car car, double distance) {
        if (car.getSize() <= maxCarSize || distance <= maxDistance ||
                numOfCars < maxNumOfCars || getCurrentSpeed() == 0 || !rampIsUp
            && !cars.contains(car)) {

            numOfCars += 1;
            cars.push(car);
            setCarPos(car);
        }
        else {
            throw new IllegalArgumentException("Error!");
        }
    }

    public void deloadCar() {
        if (getCurrentSpeed() == 0 || !rampIsUp) {
            if (numOfCars != 0 ) {
                numOfCars -= 1;
                cars.pop();
            }
            else {
                throw new IllegalArgumentException("No cars on the truck");
            }
        }
        else {
            System.out.println("Error!");
        }
    }

    public void setRampUp() {
        rampIsUp = true;
    }

    public void setRampDown() {
        rampIsUp = false;
    }

    public boolean getRampMode() {
        return rampIsUp;
    }
}
