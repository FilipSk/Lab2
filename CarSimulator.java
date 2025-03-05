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

    private ArrayList<Vehicle> vehicles;
    private Workshop<Volvo240> workshop;

    private CarController cc;
    private CarView view;

    public CarSimulator(){
        vehicles = new ArrayList<Vehicle>();
        workshop = new Workshop<Volvo240>(2);
        cc = new CarController(vehicles, workshop);
        view = new CarView("Forza Horizon 7", cc, vehicles);

        vehicles.add(VehicleFactory.CreateVolvo());
        vehicles.add(VehicleFactory.CreateSaab());
        vehicles.add(VehicleFactory.CreateScania());

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
