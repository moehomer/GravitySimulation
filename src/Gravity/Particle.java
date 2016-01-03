package Gravity;

import UI.Pixel;

import java.awt.*;

/**
 * Created by Markus on 02.01.2016.
 */
public class Particle implements Pixel{

    protected int weight;
    protected float coordX;
    protected float coordY;
    protected float forceX = 0;
    protected float forceY = 0;
    protected float velocityX;
    protected float velocityY;

    public Particle(int weight, float coordX, float coordY, float velocityX, float velocityY)
    {
        this.weight = weight;
        this.coordX = coordX;
        this.coordY = coordY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    @Override
    public int getCoordX()
    {
        return Math.round(this.coordX);
    }

    @Override
    public int getCoordY()
    {
        return Math.round(this.coordY);
    }

    @Override
    public Color getColor()
    {
        return Color.black;
    }
}
