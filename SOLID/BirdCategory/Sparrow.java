package ProblemSolving.SOLID.BirdCategory;

import ProblemSolving.SOLID.Bird;
import ProblemSolving.SOLID.Danceable;
import ProblemSolving.SOLID.Flyable;

public class Sparrow extends Bird implements Flyable, Danceable {
    public Sparrow(String name, int numberOfWings, String colour) {
        super(name, numberOfWings, colour);
    }

    @Override
    public void dance() {
        System.out.println("Sprrow dance on trees");
    }

    @Override
    public void fly() {
        System.out.println("Flies for Migration");
    }
}
