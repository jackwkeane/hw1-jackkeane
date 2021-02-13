/* 
Name: Jack Keane
Class: CSE 017
Date: 2/12/2021
Homework 1: Animal Class
*/

public class Animal {
    // Instance variables
    String name;
    Double weight;
    
    // Constructor Methods
    public animal(){
        name = "none";
        weight = 0.0;
    }

    public animal(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    // getter methods
    public String getName(){
        return name;
    }

    public Double getWeight(){
        return weight;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    // toString method
    public String toString(){
        return String.format("%-10s\t%-10.2f", name, weight);
    }
}