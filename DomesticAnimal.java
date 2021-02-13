
/* 
Name: Jack Keane
Class: CSE 017
Date: 2/12/2021
Homework 1: DomesticAnimal Class
*/

public class DomesticAnimal extends Animal {
    // additional instance variables
    String owner;

    // Constructor Methods
    public DomesticAnimal(){
        name = "none";
        weight = 0.0;
        owner = "none";
    }

    public DomesticAnimal(String name, Double weight, String owner) {
        this.name = name;
        this.weight = weight;
        this.owner = owner;
    }

    // getter methods
    public String getOwner(){
        return owner;
    }

    // setter methods
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // toString method
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-10s\n", "Domestic",
        super.toString(), owner);
    }
}
