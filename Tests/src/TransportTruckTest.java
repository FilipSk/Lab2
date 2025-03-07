import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TransportTruckTest {
    TransportTruck transportTruck = new TransportTruck();
    @BeforeEach
    void transportTruckFunc() {
        TransportTruck transportTruck = new TransportTruck();
    }

    @Test
    void loadCarTest() {
        Volvo240 volvo240 = new Volvo240();
        transportTruck.startEngine();
        transportTruck.setRampDown();
        transportTruck.loadCar(volvo240, 1);
        Assertions.assertTrue(transportTruck.carStack().contains(volvo240));

    }
    @Test
    void deloadCarTest() {
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        Volvo240 volvo240_2 = new Volvo240();
        transportTruck.startEngine();
        transportTruck.setRampUp();
        transportTruck.gas(0.5);
        transportTruck.brake(0.5);
        transportTruck.setRampDown();
        transportTruck.loadCar(saab95, 1);
        transportTruck.loadCar(volvo240, 1);
        transportTruck.loadCar(volvo240_2, 1);
        transportTruck.deloadCar();
        Assertions.assertTrue(transportTruck.carStack().contains(volvo240));
        Assertions.assertFalse(transportTruck.carStack().contains(volvo240_2));
    }

    @Test
    void rampTests() {
        transportTruck.setRampUp();
        transportTruck.setRampDown();
        Assertions.assertFalse(transportTruck.getRampMode());
    }
    @Test
    void testPositions() {
        Volvo240 volvo240 = new Volvo240();
        transportTruck.startEngine();
        transportTruck.setRampDown();
        transportTruck.loadCar(volvo240, 1);
        double volvoPosY_1 = volvo240.getPosY();
        double volvoPosX_1 = volvo240.getPosX();

        transportTruck.setRampUp();
        transportTruck.gas(0.8);
        transportTruck.move();
        transportTruck.turnRight();
        transportTruck.gas(0.89);
        transportTruck.move();

        transportTruck.move();

        //System.out.println(transportTruck.posY);

        Assertions.assertEquals(volvo240.getPosY(), transportTruck.getPosY());
        Assertions.assertEquals(volvo240.getPosX(), transportTruck.getPosX());

        Assertions.assertNotEquals(volvoPosY_1, volvo240.getPosY());
        Assertions.assertNotEquals(volvoPosX_1, volvo240.getPosX());
    }

}