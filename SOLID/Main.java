package ProblemSolving.SOLID;

import ProblemSolving.SOLID.BirdCategory.Penguin;

public class Main {
    public static void main(String[] args) {
        Penguin penguine = new Penguin("Penguine", 0,"White Black");
        penguine.eat();
        penguine.dance();
    }
}
