package oop.lesson10;

public class PolymorphismDemo {
    public static void main(String[] args) {
        /* Animal myAnimal = new Animal(); */
        Animal myAnimal = new Dog();
        Dog myDog = new Dog();
        Cat myCat = new Cat();
        
        myAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
        myAnimal.sleep();
    }
}

class Animal{
    void makeSound(){
        System.out.println("Animal makes a sound");
    }
    void sleep(){
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("Meow Meow!");
    }
    }
