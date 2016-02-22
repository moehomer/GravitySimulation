package GravitySimulation.UI;

public interface Displayable
{
    public int getWidth();

    public int getHeight();

    public Pixel[] getPixels();

    public void calculateNextFrame();
}
