package GravitySimulation.Gravity;

public class Physic
{
    final static double GRAVITYCONSTANT = 0.000001;

    static public double distance(Particle a, Particle b, double scale)
    {
        return Math.sqrt((Math.pow((a.getCoordX() + b.getCoordX()), 2) + Math.pow((a.getCoordY() + b.getCoordY()), 2))) * scale;
    }

    static public double[] gravityForce2d(Particle a, Particle b, double distance)
    {
        double totalForce = GRAVITYCONSTANT * (a.getWeight() * b.getWeight()/Math.pow(distance, 2));
        double[] vector = Physic.vector2d(a, b);
        double[] force = new double[2];
        force[0] = totalForce * (vector[0] / (vector[0] + vector[1]));
        force[1] = totalForce * (vector[1] / (vector[0] + vector[1]));

        return  force;
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
