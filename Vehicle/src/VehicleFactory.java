public abstract class VehicleFactory {
    public static Vehicle CreateVolvo(){
        return new Volvo240();
    }
    public static Vehicle CreateSaab(){
        return new Saab95();
    }
    public static Vehicle CreateScania(){
        return new Scania();
    }
}
