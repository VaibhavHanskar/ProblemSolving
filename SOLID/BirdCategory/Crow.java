package ProblemSolving.SOLID.BirdCategory;

import ProblemSolving.SOLID.Bird;
import ProblemSolving.SOLID.Danceable;
import ProblemSolving.SOLID.Flyable;

public class Crow extends Bird implements Flyable, Danceable {
    public Crow(String name, int numberOfWings, String colour) {
        super(name, numberOfWings, colour);
    }

    @Override
    public void dance() {
        System.out.println("dance on Party");
    }

    @Override
    public void fly() {
        System.out.println("flies to find food");
    }
}
