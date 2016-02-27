package GravitySimulation.Gravity;

public class Physic
{
    final static double GRAVITYCONSTANT = 0.00000001;

    static public double distance(Particle a, Particle b, double scale)
    {
        return Math.sqrt((Math.pow((a.getCoordX() - b.getCoordX()), 2) + Math.pow((a.getCoordY() - b.getCoordY()), 2))) * scale;
    }

    static public double[] gravityForce2d(Particle a, Particle b, double distance)
    {
        double totalForce = GRAVITYCONSTANT * (a.getWeight() * b.getWeight()/(Math.pow(distance, 2)));

        double deltaX = a.getCoordX() - b.getCoordX();
        double deltaY = b.getCoordY() - b.getCoordY();
        double angle = Math.atan(deltaY / deltaX);
        
        return 0;
    }

    static public double[] vector2d(Particle a, Particle b)
    {
        double[] vector = new double[2];
        vector[0] = b.getCoordX() - a.getCoordX();
        vector[1] = b.getCoordY() - a.getCoordY();

        return  vector;
    }

    static public double velocity(double weight, double force, double time)
    {
        return (force / weight) * time;
    }
}
