class Animal {
    //Attributes
    String name ;
    int age ;

    //Constructor
    public Animal(String name , int age) {
        this.name = name ;
        this.age = age ;
    }
    //Method to output sound and age
    public void makeSound() {
        System.out.println("Animal makes sound. ");
    }
}
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    //Method to output sound and age overriding the method
    @Override
    public void makeSound() {
        System.out.println(name + " (Dog): Woof Woof!" + " age: " + age);
    }
}
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    } 
    
    //Method to output sound and age overriding the method
    @Override
    public void makeSound() {
        System.out.println(name + " (Cat): Meow Meow!"+ " age: " + age);
    }
}
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    //Method to output sound and age overriding the method
    @Override
    public void makeSound() {
        System.out.println(name + " (Bird): Chirp Chirp!"+ " age: " + age);
    }
}
public class AnimalHierarchy {
    public static void main(String[] args) {
        //Making object
        Animal Dog = new Dog("Tommy", 5);
        Animal Cat = new Dog("Billu", 3);
        Animal Bird = new Bird("Robin" , 2);

        //Calling method
        Dog.makeSound();
        Cat.makeSound();
        Bird.makeSound();
    }
}