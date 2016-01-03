package UI;

import javax.swing.*;
import java.awt.*;

public class PixelGraphic extends JPanel
{
    protected Pixel[] pixels;

    public PixelGraphic(Pixel[] pixels)
    {
        this.pixels = pixels;
    }

    public void paint(Graphics g)
    {
        for(Pixel pixel: this.pixels)
        {
            g.setColor(pixel.getColor());
            g.drawLine(pixel.getCoordX(), pixel.getCoordY(), pixel.getCoordX(), pixel.getCoordY());
        }
    }
}
