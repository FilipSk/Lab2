import java.awt.*;

public abstract class Vehicle implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    protected double posX;
    protected double posY;

    private int direction;
    private int[] directionX = {1,0,-1,0 };
    private int[] directionY = {0,-1,0,1 };

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();

    }


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }
    public String getname(){
        return modelName;
    }


    public void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }



    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);
    protected abstract double speedFactor();

    public void gas(double amount){
        if (amount > 1 || amount < 0) {
            throw new IllegalArgumentException("Amount is out of range.");
        }
        else {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1 ) {
            throw new IllegalArgumentException();
        }
        else {
            decrementSpeed(amount);
        }
    }

    @Override
    public void move() {
        posX += directionX[direction] * getCurrentSpeed();
        posY += directionY[direction] * getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        direction -=1;
        if (direction < 0){
            direction = 3;
        }

    }

    @Override
    public void turnRight() {
        direction +=1;
        if (direction > 3){
            direction = 0;
        }
    }


}



//hej hej