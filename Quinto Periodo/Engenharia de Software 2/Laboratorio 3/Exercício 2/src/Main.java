import java.util.ArrayList;

interface RoboAction
{
    public void execute();
}

class Experimento
{
    public Experimento(ArrayList<Robot> robos)
    {
        for(int i = 0; i < robos.size(); i++) {
            robos.get(i).execute();
        }
    }
}

abstract class Robot implements RoboAction {}

class Robot1 extends Robot
{
    public void execute()
    {
        System.out.println("Execute do robot 1");
    }
}

class Robot2 extends Robot
{
    public void execute()
    {
        System.out.println("Execute do robot 2");
    }
}

public class Main {
    public static void main(String[]args) {
        Robot1 robo1 = new Robot1();
        Robot2 robo2 = new Robot2();
        ArrayList<Robot> roboTeste = new ArrayList<Robot>();
        roboTeste.add(robo1);
        roboTeste.add(robo2);
        Experimento teste = new Experimento(roboTeste);
    }
}