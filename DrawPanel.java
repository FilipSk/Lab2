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

    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;

    private BufferedImage volvoWorkshopImage;
    private Point volvoWorkshopPoint = new Point(300,0);

    private ArrayList<Vehicle> vehicles;

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
