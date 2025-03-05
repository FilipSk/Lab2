import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarSimulator{

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final int delay = 50;
    private Timer timer;

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private Workshop<Volvo240> workshop = new Workshop<Volvo240>(2);

    private CarController cc = new CarController(vehicles, workshop,CarView.X);
    private CarView view = new CarView("Forza Horizon 7", cc, vehicles);

    public CarSimulator(){
        cc.addCar(0);
        cc.addCar(1);
        cc.addCar(2);
    }
    public void Start(){
        timer = new Timer(delay, new CarSimulator.TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cc.Update();
            view.Update();
        }
    }
}
