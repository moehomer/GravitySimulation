package GravitySimulation.UI;

import javax.swing.*;

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

    public void paint() throws InterruptedException
    {
        Pixel[] pixels = this.source.getPixels();
        PixelGraphic graphic = new PixelGraphic(pixels, source.getWidth(), source.getHeight());
        this.frame.add(graphic);

        for (int i = 0; i < 5000; i++) {
            this.source.calculateNextFrame();
            Thread.sleep(250);
            graphic.updateUI();
        }
    }

}
