import java.awt.*;

public abstract class TruckWithBed extends Truck {

    private double bedAngle;
    private final double maxBedAngle;
    private final double minBedAngle;

    public TruckWithBed(int nrDoors, double enginePower, Color color, String modelName, double _minBedAngle, double _maxBedAngle) {
        super(nrDoors, enginePower, color, modelName);
        this.maxBedAngle = _maxBedAngle;
        this.minBedAngle = _minBedAngle;
    }

    public void increaseBedAngle(double angle) {
        setBedAngle(getBedAngle() + angle);
        if (getBedAngle() > getMaxBedAngle()) {
            setBedAngle(getMaxBedAngle());
        }
    }

    public void decreaseBedAngle(double angle) {
        setBedAngle(getBedAngle() - angle);
        if (getBedAngle() < getMinBedAngle()) {
            setBedAngle(getMinBedAngle());
        }
    }

    private void setBedAngle(double angle) {
        bedAngle = angle;
    }
    @Override
    protected void incrementSpeed(double amount) {
        if (getBedAngle() < getMinBedAngle()){
            throw new IllegalArgumentException("Rampen är uppe!");
        }
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    protected void decrementSpeed(double amount) {
        if (getBedAngle() > getMaxBedAngle()){
            throw new IllegalArgumentException("Rampen är uppe!");
        }
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;

    }

    @Override
    protected double speedFactor() {
        return this.getEnginePower() / 100;
    }

    public double getBedAngle() {
        return bedAngle;
    }
    public double getMinBedAngle() {
        return minBedAngle;
    }
    public double getMaxBedAngle() {
        return maxBedAngle;
    }
}