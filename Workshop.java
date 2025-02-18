import java.util.ArrayList;

public class Workshop <T extends Car> {
    private int maxCars = 10;
    private ArrayList<T> cars = new ArrayList<>();

    public Workshop(int maxCars) {
        this.maxCars = maxCars;
    }

    public void loadCar(T car) {
        if (cars.contains(car)){
            throw new IllegalArgumentException("This car is already in workshop");
        }

        if (isNotFull()) {
            cars.add(car);
        }
        else {
            throw new IllegalArgumentException("This workshop is full");
        }
    }

    private boolean isNotFull() {
        return cars.size() < maxCars;
    }

    public void deloadCar(T car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
        else {
            throw new IllegalArgumentException("This car not in workshop");
        }
    }
    public int getAmountOfCars(){
        return cars.size();
    }
}
