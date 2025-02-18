import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab = new Saab95();

    @Test
    void decrementSpeed() {
        saab.startEngine();
        double firstSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(0.05);
        //System.out.println(firstSpeed);
        //System.out.println(saab.getCurrentSpeed());

        assertTrue(saab.getCurrentSpeed() < firstSpeed);
    }

    @Test
    void brake() {
        saab.startEngine();
        double firstSpeed = saab.getCurrentSpeed();
        saab.gas(0.8);
        saab.brake(0.9);

        assertTrue(saab.getCurrentSpeed() < firstSpeed);
    }
}