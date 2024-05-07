package Classes; //package = folder name

import Interfaces.oopInterface;

abstract public class Animal implements oopInterface {
    private String animalName;
    // making this attribute private is a method of hiding irrelevant information
    // from the user. (Abstraction)

    public Animal() {
    }

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    // setter method
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    // getter method
    public String getAnimalName() {
        return this.animalName;
    }

    public void speak() {
        System.out.println("Animal Sound!");
    }

}
