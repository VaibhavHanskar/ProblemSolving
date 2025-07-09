package ProblemSolving.SOLID.BirdCategory;

import ProblemSolving.SOLID.Bird;
import ProblemSolving.SOLID.Danceable;
import ProblemSolving.SOLID.Flyable;

public class Pigeon extends Bird implements Flyable, Danceable {
    public Pigeon(String name, int numberOfWings, String colour) {
        super(name, numberOfWings, colour);
    }

    @Override
    public void dance() {
        System.out.println("Pigeon dance on Nests");
    }

    @Override
    public void fly() {
        System.out.println("Flies to find food");
    }
}
