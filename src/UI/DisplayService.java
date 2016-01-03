package UI;

import javax.swing.*;

/**
 * Created by Markus on 02.01.2016.
 */
public class DisplayService
{
    protected JFrame frame;
    protected Displayable source;

    public DisplayService(Displayable source)
    {
        this.source = source;
        this.frame = new JFrame();
        this.frame.setSize(source.getWidth(), source.getHeight());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void paint()
    {
        Pixel[] pixels = this.source.getPixels();
        PixelGraphic graphic = new PixelGraphic(pixels);
        this.frame.add(graphic);
    }

}
