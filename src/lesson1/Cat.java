package lesson1;

class MainClass {
    public static void main(String[] args) {
        Animal animal = new Animal ( "Дружок" );
        Cat cat = new Cat ( "Мурзик", "Белый" );
        Dog dog = new Dog ();
        //animal.animalInfo ();
        //cat.animalInfo ();
        Animal animalCat = new Cat ( "Животный кот" , "рыжий");
        animalCat.animalInfo ();
        if (animalCat instanceof Cat ) {
            ((Cat) animalCat).voice2 ();
        }

        animalCat.voice ();
        System.out.println (animalCat.getClass ());

        //cat.catInfo ();

        //cat.voice ();
        //dog.voice ();

    }
}

class Dog extends Animal{

}

public class Cat extends Animal {

    private String color;

    //private int weight;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
        weight = 2;
    }

    //@Override
    void voice2() {
        System.out.println ("Кот мяукнул");
    }

    @Override
    public void animalInfo() {
        System.out.println ( "Кот имя: " + getName () + " цвет: " + color + " вес: " + weight);
    }

    public void catInfo() {
        animalInfo ();
        super.animalInfo ();
    }


}
