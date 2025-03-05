import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarSimulator{

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Workshop<Volvo240> workshop;

    private CarController cc;
    private CarView view;

    public CarSimulator(){
        workshop = new Workshop<Volvo240>(2);
        cc = new CarController(vehicles, workshop);
        view = new CarView("Forza Horizon 7", cc, vehicles);

    }
    public void Start(){
        timer = new Timer(delay, new CarSimulator.TimerListener());
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cc.Update();
            view.Update();
        }

    }
}
