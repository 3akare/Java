import Classes.Animal;
import Classes.Cat;
import Classes.Dog;
import Classes.PitBull;
import Enums.Laptop;
import Interfaces.lamdaInterface;

public class OOP {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.speak();
        Animal cat = new Cat(); // autoboxing
        Dog pitbull = new PitBull();

        pitbull.speak();

        @SuppressWarnings("unused") // suppress the unused variable newPitBull
        PitBull newPitbull = (PitBull) pitbull; // unboxing

        cat.speak();

        cat.setAnimalName("Katherine");
        System.out.println(cat.getAnimalName());

        lamdaInterface nonLamdaFunction = new lamdaInterface() {
            public void show() {
                System.out.println("Showing... (not lamda function)");
            }
        };
        nonLamdaFunction.show();

        lamdaInterface lamdaFunction = () -> System.out.println("Showing... (lamda function)");
        lamdaFunction.show();

        for (Laptop laptop : Laptop.values()) {
            System.out.println(laptop.getPrice() + " " + laptop.name());
        }
    }
}
