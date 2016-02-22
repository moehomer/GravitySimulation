package GravitySimulation.Gravity;

import GravitySimulation.UI.Pixel;
import java.awt.*;

public class Particle implements Pixel
{
    protected int weight;
    protected double coordX;
    protected double coordY;
    protected double forceX = 0;
    protected double forceY = 0;
    protected double velocityX;
    protected double velocityY;

    public Particle(int weight, double coordX, double coordY, double velocityX, double velocityY)
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
        return (int) Math.round(this.coordX);
    }

    public void setCoordX(double coordX)
    {
        this.coordX = coordX;
    }

    @Override
    public int getCoordY()
    {
        return (int) Math.round(this.coordY);
    }

    public void setCoordY(double coordY)
    {
        this.coordY = coordY;
    }

    public double getForceX() 
    {
        return forceX;
    }

    public void setForceX(double forceX) 
    {
        this.forceX = forceX;
    }

    public double getForceY()
    {
        return forceY;
    }

    public void setForceY(double forceY)
    {
        this.forceY = forceY;
    }

    public double getVelocityX()
    {
        return velocityX;
    }

    public void setVelocityX(double velocityX) 
    {
        this.velocityX = velocityX;
    }

    public double getVelocityY() 
    {
        return velocityY;
    }

    public void setVelocityY(double velocityY)
    {
        this.velocityY = velocityY;
    }

    @Override
    public Color getColor()
    {
        return Color.black;
    }

    public int getWeight()
    {
        return this.weight;
    }
}
