package Classes;

public class Dog extends Animal { // extends enables inheritance
    // Override the default speak method that is inherited from the animal class.
    // (polymorphism)
    @Override
    public void speak() {
        System.out.println("bark!");
    }
}