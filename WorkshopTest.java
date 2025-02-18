import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WorkshopTest {

    Workshop<Volvo240> workshorp = new Workshop<>(3);
    @BeforeEach
    void setWorkshorp() {
        Workshop<Volvo240> workshorp = new Workshop<>(3);
    }
    @Test
    void loadCar(){

        Volvo240 volvo = new Volvo240();
        workshorp.loadCar(volvo);

        assertTrue(workshorp.getAmountOfCars() == 1);

        assertThrows(IllegalArgumentException.class, () -> workshorp.loadCar(volvo));

    }
    @Test
    void deloadCar(){
        Workshop<Volvo240> workshorp = new Workshop<>(3);
        Volvo240 volvo = new Volvo240();

        workshorp.loadCar(volvo);
        assertTrue(workshorp.getAmountOfCars() == 1);

        workshorp.deloadCar(volvo);
        assertTrue(workshorp.getAmountOfCars() == 0);




    }
}