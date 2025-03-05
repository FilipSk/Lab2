import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements UpdateInterface{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a single car's position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,0);

    // TODO: Make this general for all cars

    // Göra detta så att den går igenom en lista med vehicles
    void moveit(Vehicle vehicle,int x, int y){
        if (vehicle instanceof Volvo240) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        if (vehicle instanceof Saab95) {
            saabPoint.x = x;
            saabPoint.y = y + 100;
        }
        if (vehicle instanceof Scania) {
            scaniaPoint.x = x;
            scaniaPoint.y = y + 200;
        }
    }

    ArrayList<Vehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;


        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));

            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < vehicles.size(); i++) {
            if (Objects.equals(vehicles.get(i).getname(), "Volvo240")) {
                g.drawImage(volvoImage, (int)vehicles.get(i).getPosX(), (int)vehicles.get(i).getPosY(), null); // see javadoc for more info on the parameters
            } else if (Objects.equals(vehicles.get(i).getname(), "Saab95")) {
                g.drawImage(saabImage, (int)vehicles.get(i).getPosX(), (int)vehicles.get(i).getPosY(), null); // see javadoc for more info on the parameters
            } else if (Objects.equals(vehicles.get(i).getname(), "Scania")) {
                g.drawImage(scaniaImage, (int)vehicles.get(i).getPosX(), (int)vehicles.get(i).getPosY(), null); // see javadoc for more info on the parameters
            }

        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    @Override
    public void Update() {
        repaint();
    }
}
