/* 
Name: Jack Keane
Class: CSE 017
Date: 2/12/2021
Homework 1: WildAnimal Class
*/
public class WildAnimal extends Animal{
    // additional instance variables
    String origin;

    // Constructor Methods
    public WildAnimal(){
        name = "none";
        weight = 0.0;
        origin = "none";
    }

    public WildAnimal(String name, Double weight, String origin) {
        this.name = name;
        this.weight = weight;
        this.origin = origin;
    }

    // getter methods
    public String getOrigin(){
        return origin;
    }

    // setter methods
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // toString method
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-10s\n", "Wild",
        super.toString(), origin);
    }

}
