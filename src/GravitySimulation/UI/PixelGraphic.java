package GravitySimulation.UI;

import javax.swing.*;
import java.awt.*;

public class PixelGraphic extends JPanel {
    protected Pixel[] pixels;
    protected int width;
    protected int height;

    public PixelGraphic(Pixel[] pixels, int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,this.width,this.height);
        for (Pixel pixel : this.pixels) {
            g.setColor(pixel.getColor());
            g.fillOval(pixel.getCoordX(), pixel.getCoordY(), 10, 10);
        }
    }
}
