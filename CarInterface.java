public interface CarInterface {
    void gas(int amount);
    void brake(int amount);
    void startAllCars();
    void stopAllCars();
    void turboOn();
    void turboOff();
    void liftBed();
    void lowerBed();
    void addCar(int index);
    void removeCar(int index);
}
