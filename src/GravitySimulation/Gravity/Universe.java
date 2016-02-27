package GravitySimulation.Gravity;

import GravitySimulation.UI.Displayable;
import GravitySimulation.UI.Pixel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Universe implements Displayable
{
    final double SECONDS_PER_FRAME = 1;
    final double METERS_PER_PIXEL = 0.001;

    protected int width;
    protected int height;
    protected Particle[] particles;

    public Universe(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void populate(int numberOfParticles) {
        this.particles = new Particle[numberOfParticles];
//        for (int i = 0; i < numberOfParticles; i++) {
//            int x = (int) (Math.random() * this.width);
//            int y = (int) (Math.random() * this.height);
//            int m = (int) (Math.random() * 1000000000);
//            this.particles[i] = new Particle(m, x, y, 0, 0);
//        }

        this.particles[0] = new Particle(1000000000, 500, 500, 0, -10);
        this.particles[1] = new Particle(1000000000, 550, 500, 0, 10);
    }

    public void calculateNextFrame()
    {
        this.calculateForces();
        this.calculateVelocity();
        this.calculatePositions();
    }

    protected void calculateForces()
    {
        for (int a = 0; a < this.particles.length; a++) {
            Particle particleInScope = this.particles[a];
            for (int b = a + 1; b < this.particles.length; b++) {
                Particle otherParticle = this.particles[b];
                double distance = Physic.distance(particleInScope, otherParticle, METERS_PER_PIXEL);
                double[] force = Physic.gravityForce2d(particleInScope, otherParticle, distance);
                particleInScope.setForceX(particleInScope.getForceX() + force[0]);
                particleInScope.setForceY(particleInScope.getForceX() + force[1]);
                otherParticle.setForceX(otherParticle.getForceX() - force[0]);
                otherParticle.setForceY(otherParticle.getForceY() - force[1]);
            }
        }
    }

    protected void calculateVelocity()
    {
        for (Particle particle : this.particles) {
            double velocityX = Physic.velocity(particle.getWeight(), particle.getForceX(), SECONDS_PER_FRAME);
            double velocityY = Physic.velocity(particle.getWeight(), particle.getForceY(), SECONDS_PER_FRAME);
            particle.setVelocityX(particle.getVelocityX() + velocityX);
            particle.setVelocityY(particle.getVelocityY() + velocityY);
        }
    }

    protected void calculatePositions()
    {
        for (Particle particle : this.particles) {
            double x = particle.getCoordX() + (particle.getVelocityX() * SECONDS_PER_FRAME);
            double y = particle.getCoordY() + (particle.getVelocityY() * SECONDS_PER_FRAME);

            x = x > this.width ? x - this.width : x;
            y = y > this.height ? y - this.height : y;

            x = x < 0 ? x + this.width : x;
            y = y < 0 ? y + this.height : y;

            particle.setCoordX(x > this.width ? x - this.width : x);
            particle.setCoordY(y > this.height ? y - this.height : y);
        }
    }

    @Override
    public int getWidth()
    {
        return this.width;
    }

    @Override
    public int getHeight()
    {
        return this.height;
    }

    @Override
    public Pixel[] getPixels()
    {
        return this.particles;
    }
}