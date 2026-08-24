package oop.lesson10;

public class AbstractionDemo {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        Rectangle myRectangle = new Rectangle(10.5, 5.5);
        System.out.println(myCircle.calculateArea());
        System.out.println(myRectangle.calculateArea());
    }
    
}

abstract class Shape{
    abstract double calculateArea();
}

class Circle extends Shape{
    double radius;
    
    Circle(double radius){
        this.radius = radius;
    }
    
    @Override
    double calculateArea(){
        return 3.14159 * radius * radius;
    }
}

class Rectangle extends Shape{
    double length;
    double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    
    @Override
    double calculateArea(){
        return length * width;
    }
}