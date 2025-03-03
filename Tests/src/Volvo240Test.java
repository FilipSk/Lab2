import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 volvo = new Volvo240();
    @Test
    void incrementSpeed() {
        volvo.startEngine();
        double firstSpeed = volvo.getCurrentSpeed();
        volvo.incrementSpeed(0.4);
        Assertions.assertTrue(volvo.getCurrentSpeed() > firstSpeed);
    }

    @Test
    void gas() {
        volvo.startEngine();
        double firstSpeed = volvo.getCurrentSpeed();

        volvo.gas(0.5);
        Assertions.assertTrue(volvo.getCurrentSpeed() > firstSpeed);

        Assertions.assertThrows(IllegalArgumentException.class, () -> volvo.gas(10));
    }
}