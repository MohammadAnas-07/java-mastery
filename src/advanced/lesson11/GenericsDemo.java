package advanced.lesson11;

public class GenericsDemo {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        System.out.println(intBox.getItem());

        Box<String> strBox = new Box<>();
        strBox.setItem("Hello");
        System.out.println(strBox.getItem());
    }
    
}

class Box<T> {
    T item;

    void setItem(T item){
        this.item = item;
    }

    T getItem(){
        return item;
    }
}
