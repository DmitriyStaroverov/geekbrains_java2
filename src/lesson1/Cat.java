package lesson1;

class MainClass{
    public static void main(String[] args) {
        Cat cat1 = new Cat();

    }
}



public class Cat {
    String name;
    String color;
    int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
        this.color = "Неизвестно";
        this.age = 1;
    }
}
