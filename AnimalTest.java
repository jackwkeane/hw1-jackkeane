
/* 
Name: Jack Keane
Class: CSE 017
Date: 2/12/2021
Homework 1: Animal Test Class
*/
import java.util.Scanner;

public class AnimalTest {
    
    public static void main(String[]args) {
    
    Animal[] animalList = new Animal[10]; // New array of size 10.
    WildAnimal wildAnimal1 = new WildAnimal("Lion", 400.0, "Africa");
    DomesticAnimal domesticAnimal1 = new DomesticAnimal("Dog", 68.5, "Jack Holmer");
    WildAnimal wildAnimal2 = new WildAnimal("Tiger", 410.0, "Asia");
    WildAnimal wildAnimal3 = new WildAnimal("Kangaroo", 110.0, "Australia");
    DomesticAnimal domesticAnimal2 = new DomesticAnimal("Cat", 8.56, "Patricia Bell");
    DomesticAnimal domesticAnimal3 = new DomesticAnimal("Goldfish", 0.75,"Sebastien Cole");
    WildAnimal wildAnimal4 = new WildAnimal("Wolf", 120.0, "Europe");
    DomesticAnimal domesticAnimal4 = new DomesticAnimal("Parrot", 3.7, "Lily Alexander");
    WildAnimal wildAnimal5 = new WildAnimal("Crocodile", 1000.0, "America");
    DomesticAnimal domesticAnimal5 = new DomesticAnimal("Hamster", 0.5, "Bella Chen");

    // Storing objects in the array
    animalList[0] = wildAnimal1;
    animalList[1] = wildAnimal2;
    animalList[2] = wildAnimal3;
    animalList[3] = wildAnimal4;
    animalList[4] = wildAnimal5;
    animalList[5] = domesticAnimal1;
    animalList[6] = domesticAnimal2;
    animalList[7] = domesticAnimal3;
    animalList[8] = domesticAnimal4;
    animalList[9] = domesticAnimal5;
    
    // Main menu loop through
    Scanner input = new Scanner(System.in); // scanner for user input
    int selection = 0; // incease scope of selection
    // do while loop
    do {
        printMenu();
        if (input.hasNextInt()) {
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Here is alist of all animals: ");
                    printArray(animalList);
                    break;
                case 2:
                    System.out.print("Enter the name you'd like to search for: ");
                    String name = input.next();
                    int num = searchByName(animalList, name);
                    if (num == -1) {
                        System.out.println("There is no animal with that name in the array.");
                    } else {
                        System.out.println("The animal appears at index " + num + ".");
                    }
                    break;
                case 3:
                    System.out.print("Enter the weight you'd like to search for: ");
                    Double weight = input.nextDouble();
                    int num2 = searchByWeight(animalList, weight);
                    if (num2 == 0) {
                        System.out.println("There are no animals heavier than the weight inputted.");
                    } else {
                        System.out.println("There are " + num2 + " animal(s) that are heavier than the inputted weight.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the type of animal (DomesticAnimal or WildAnimal): ");
                    String type = input.next();
                    System.out.println("There are " + searchByType(animalList, type) + " animal(s) of that type.");
                    break;
                case 5:
                    sortByName(animalList);
                    break;
                case 6:
                    sortByWeight(animalList);
                    break;
                case 7:
                    System.out.println("The program will be exited");
                    break;
            }
        }
    } while (selection != 7);

    
    }

    // Method that accepts an array of type Person and prints the information of the objects in the array
    public static void printArray(Animal[] animalList) {
        System.out.println("Type\t\tName\t\tWeight(lbs)\tOrigin/Owner\n");
        for(int i = 0; i < animalList.length; i++) {
            System.out.println(animalList[i].toString());
        }
    }

    /**
     * @param animalList
     * @param name
     * @return the index of the animal or -1 if it doesnt exist
     */
    // Method that searches an array for a name
    public static int searchByName(Animal[] animalList, String name) {
        //searching array
        for (int i = 0; i < animalList.length; i++) {
            if (animalList[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param animalList
     * @param weight
     * @return the number of animals with weight greater that the param     
     */
    // Method that searches an array for a weight
    public static int searchByWeight(Animal[] animalList, Double weight) {
       int counter = 0;
        //searching array
        for (int i = 0; i < animalList.length; i++) {
            if (animalList[i].getWeight() >= weight) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param animalList
     * @param type
     * @return prints list and returns number of animals of that type      
     */
    // Method that searches an array for the number of a certain type
    public static int searchByType(Animal[] animalList, String type) {
        int counter = 0;
        // Counting up amount of instances
        for (int i = 0; i < animalList.length; i++) {
            if (type.equals("WildAnimal")) {
                if (animalList[i] instanceof WildAnimal) {
                    counter++;
                }
            } else if (type.equals("DomesticAnimal")) {
                if (animalList[i] instanceof DomesticAnimal) {
                    counter++;
                }
            }
            
        }
        
        Animal[] typeList = new Animal[counter]; 
        int index = 0;
        //searching array
        for (int i = 0; i < animalList.length; i++) {
            if (type.equals("WildAnimal")) {
                if (animalList[i] instanceof WildAnimal) {
                    typeList[index] = animalList[i]; 
                    index++;
                }
            } else if (type.equals("DomesticAnimal")) {
                if (animalList[i] instanceof DomesticAnimal) {
                    typeList[index] = animalList[i]; 
                    index++;
                }
            }
        }


        System.out.println("Here is the list of " + type + "(s) in the array:");
        printArray(typeList); // Prints the array.

        return typeList.length; // returns amount of the type of animal.

    }

    /**
     * @param animalList
     * @return returns the sorted array as well as prints it
     */

    public static Animal[] sortByName(Animal[] animalList) {
        // Selection Sort
        for (int i = 0; i < animalList.length; i++) {
            int min = i;
            for (int j = i + 1; j < animalList.length; j++) {
                if (animalList[j].getName().compareTo(animalList[i].getName()) < 1) {
                    // Swapping reference at J with the reference at min
                    min = j;
                    Animal tempAnimal = animalList[min];
                    animalList[min] = animalList[i];
                    animalList[i] = tempAnimal;
                }
            }
        }
        System.out.println("List of animals sorted by name:");
        printArray(animalList); // Prints the sorted array
        return animalList;
     }

     /**
     * @param animalList
     * @return returns the sorted array as well as prints it
     */

    public static Animal[] sortByWeight(Animal[] animalList) {
        // Selection Sort
        for (int i = 0; i < animalList.length; i++) {
            int min = i;
            for (int j = i + 1; j < animalList.length; j++) {
                if (animalList[j].getWeight().compareTo(animalList[i].getWeight()) < 1) {
                    // Swapping reference at J with the reference at min
                    min = j;
                    Animal tempAnimal = animalList[min];
                    animalList[min] = animalList[i];
                    animalList[i] = tempAnimal;
                }
            }
        }
        System.out.println("List of animals sorted by weight:");
        printArray(animalList); // Prints the sorted array
        return animalList;
     }

     public static void printMenu() {
         System.out.println("1: View all animals\n2: Search by name\n3: Search by weight\n4: Search by type\n5: Sort by name\n6: Sort by weight\n7: Exit");
     }
}
