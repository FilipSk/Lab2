import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ScaniaTest {
    Scania scania = new Scania();
    @BeforeEach
    void setScania(){
        Scania scania = new Scania();

    }
    @Test
    void incrementSpeed() {
        scania.startEngine();
        double firstSpeed = scania.getCurrentSpeed();

        scania.gas(0.5);
        assertTrue(scania.getCurrentSpeed() > firstSpeed);

        assertThrows(IllegalArgumentException.class, () -> scania.gas(10));
    }

    @Test
    void decrementSpeed() {
        scania.startEngine();
        double firstSpeed = scania.getCurrentSpeed();
        scania.decrementSpeed(0.05);

        assertTrue(scania.getCurrentSpeed() < firstSpeed);
    }
}