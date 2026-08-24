package oop.lesson10;

public class ClassesObjectsDemo {
    public static void main(String[] args) {
        Car myCar = new Car("Red",100);
        Car yourCar = new Car("Blue");
        Car ouCar = new Car();

        myCar.honk(); // Beep beep!
        
        System.out.println(myCar.color); // Red
        System.out.println(myCar.speed); // 100
        System.out.println(yourCar.color); // Blue
        System.out.println(yourCar.speed); // 0
        System.out.println(ouCar.color); // not assigned
        System.out.println(ouCar.speed); //0
    }
}

class Car {
    String color;
    int speed;
    
    // Constructor 1: dono parameter
    Car(String color, int speed){
        this.color = color;
        this.speed = speed;
    }

    // Constructor 2: sirf color
    Car(String color){
        this.color = color;
        this.speed = 0; // default value manually set
    }
    
    // Constructor 3: 0 parameter
    Car(){
        color = "not assigned";
    } // Yahan koi parameter hai hi nahi — no clash possible hai.
    //  Jab Java color dekhta hai is method ke andar, aur local scope
    //  mein koi color naam ka variable exist nahi karta, to Java automatically 
    // upar jaake class ka field color dhundta hai — aur wahi use kar leta hai.
    
    void honk(){
        System.out.println("Beep beep!");
    }
}