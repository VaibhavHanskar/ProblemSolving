package ProblemSolving.SOLID;

public abstract class Bird {
    String name;
    int numberOfWings;
    String colour;


    public Bird(String name , int numberOfWings, String colour){
        this.name = name;
        this.numberOfWings = numberOfWings;
        this.colour = colour;
    }


    public void eat(){
        System.out.println(this.name  + " is eating");
    }
}
