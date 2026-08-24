package oop.lesson10;

public class InterfaceDemo {
    public static void main(String[] args) {
        Duck myDuck = new Duck();
        myDuck.swim();
        myDuck.fly();
    }
}

interface Swimmer{
    void swim();
}
interface Flyer{
    void fly();
}


class Duck implements Swimmer, Flyer{
    @Override
    public void swim(){
        System.out.println("Duck is swimming");
    }

    @Override
    public void fly(){
        System.out.println("Duck is flying");
    }
}