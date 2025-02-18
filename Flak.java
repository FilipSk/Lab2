import java.awt.*;

public abstract class Flak extends Vehicle{
    private double bedAngle;
    private final double maxBedAngle;
    private final double minBedAngle;

    //amount that changes the angle of the truck bed
    //private double angleChange;

    public Flak(int nrDoors, double enginePower, Color color, String modelName, double _minBedAngle, double _maxBedAngle) {
        super(nrDoors, enginePower, color, modelName);
        this.bedAngle = 0;
        this.minBedAngle = _minBedAngle;
        this.maxBedAngle = _maxBedAngle;
        //this.angleChange = _angleChange;
    }

    public void increaseBedAnge(){
        if (currentSpeed != 0){
            return;
        }
        bedAngle = maxBedAngle;
    }
    public void decreaseBedAngle(){
        if (currentSpeed != 0){
            return;
        }
        bedAngle = minBedAngle;
    }
}
