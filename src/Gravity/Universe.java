package Gravity;

import UI.Displayable;
import UI.Pixel;

/**
 * Created by Markus on 02.01.2016.
 */
public class Universe implements Displayable{

    final double GRAVITYCONSTANT = 0.000001;
    final double SECONDS_PER_FRAME = 1;
    final double METERS_PER_PIXEL = 0.001;

    protected int width;
    protected int height;
    protected Particle[] particles;

    public Universe(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void populate(int numberOfParticles)
    {
        this.particles = new Particle[numberOfParticles];
        for(int i=0; i<numberOfParticles; i++){
            int x = (int)(Math.random() * this.width);
            int y = (int)(Math.random() * this.height);
            int m = (int)(Math.random() * 1000000000);
            this.particles[i] = new Particle(m, x, y, 0, 0);
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Pixel[] getPixels() {
        return this.particles;
    }
}