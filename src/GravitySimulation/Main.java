package GravitySimulation;

import GravitySimulation.Gravity.Universe;
import GravitySimulation.UI.DisplayService;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Universe universe = new Universe(1500, 1000);
        universe.populate(150);

        DisplayService display = new DisplayService(universe);
        display.paint();
    }
}