package oop.lesson10;

public class EncapsulationDemo{
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.setSpeed(-500);
        myCar.setSpeed(100);

        myCar.setColor("Blue");

        System.out.println(myCar.getSpeed());
        System.out.println(myCar.getColor());
    }
}

class Car{
    private String color;
    private int speed;

    void setSpeed(int speed){
        if(speed < 0){
            System.out.println("Speed can't be negative!");
        }else{
            this.speed = speed;
        }
    }

    void setColor(String color){
        this.color = color;
    }

    String getColor(){
        return color;
    }

    int getSpeed(){
        return speed;
    }
}