import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    // refactor detta till en klass
    // vehicles ur carcontroller
    // interface av update
    //

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new Application.TimerListener());


    private CarController cc = new CarController();
    private CarView view = new CarView("Forza Horizon 7", cc, cc.vehicles);

    public static void main(String[] args) {
        Application app = new Application();
        app.timer.start();
    }
    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cc.Update(view.getWidth());
            view.Update();
        }

    }
}
