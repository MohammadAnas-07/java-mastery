package oop.lesson10;

public class InheritanceDemo {
     public static void main(String[] args) {
        Bike myBike = new Bike(150,false);

        SportsCar myCar = new SportsCar(200, 4);

        myBike.speed = 60;
        myBike.hasGear = true;

        myBike.move();

        System.out.println(myBike.speed); // 60
        System.out.println(myBike.hasGear); // true
        System.out.println(myCar.doors); // 4
        System.out.println(myCar.speed); // 200
     }
}

class Vehicle{
    int speed;

    Vehicle(int speed){
        this.speed = speed;
        System.out.println("Vehicle constructor called");
    }
    void move(){
        System.out.println("Vehicle is moving");
    }
}

class SportsCar extends Vehicle{
    int doors;

    SportsCar(int speed, int doors){
        super(speed);
        this.doors = doors;
    }
}

class Bike extends Vehicle{
    boolean hasGear;

    Bike(int speed, boolean hasGear){
        super(speed);
        this.hasGear = hasGear;
    }
}
