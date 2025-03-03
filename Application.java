import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    private final int delay = 50;

    public Timer timer = new Timer(delay, new Application.TimerListener());

    private CarController cc = new CarController();
    private CarView view = new CarView("CarSim 1.0", cc, cc.vehicles);

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
