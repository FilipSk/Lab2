import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {
    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();
    @BeforeEach
    void createNewCars() {
        volvo = new Volvo240();
        saab = new Saab95();
    }

    @Test
    void getNrDoors() {

        Assertions.assertEquals(4, volvo.getNrDoors());
        Assertions.assertEquals(2, saab.getNrDoors());

    }
    @Test
    void getEnginePower() {
        Assertions.assertEquals(100, volvo.getEnginePower());
        Assertions.assertEquals(125, saab.getEnginePower());
    }
    @Test
    void getColor() {
        Assertions.assertEquals(Color.black, volvo.getColor());
        Assertions.assertEquals(Color.red, saab.getColor());
    }

    @Test
    void turnLeft() {
        volvo.startEngine();
        double firstY = volvo.getPosY();
        double firstX = volvo.getPosX();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnRight();
        Assertions.assertNotEquals(firstX, volvo.getPosX());
        Assertions.assertNotEquals(firstY, volvo.getPosY());
    }
}