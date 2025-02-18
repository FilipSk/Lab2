import java.awt.*;

public abstract class Car extends Vehicle{
    private double carSize;
    public Car(int nrDoors, double enginePower, Color color, String modelName, double carSize) {
        super(nrDoors, enginePower, color, modelName);
        this.carSize = carSize;
    }
    public double getSize() {
         return carSize;
    }
}
