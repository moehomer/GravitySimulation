import Gravity.Universe;
import UI.DisplayService;

public class Main
{
    public static void main(String[] args)
    {

        Universe universe = new Universe(1000, 1000);
        universe.populate(10000);

        DisplayService display = new DisplayService(universe);
        display.paint();
    }
}
