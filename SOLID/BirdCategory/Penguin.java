package ProblemSolving.SOLID.BirdCategory;

import ProblemSolving.SOLID.Bird;
import ProblemSolving.SOLID.Danceable;

public class Penguin extends Bird implements  Danceable {
    public Penguin(String name, int numberOfWings, String colour) {
        super(name, numberOfWings, colour);
    }

    @Override
    public void dance() {
        System.out.println("Dance when they are in group");
    }

}
