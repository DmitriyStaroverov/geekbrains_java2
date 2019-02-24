package lesson1;

public abstract class AnimalAbstract {

    public abstract void voice();

    void jump(){
        System.out.println ("Животное прыгнуло");
    }

}

class Cat1 extends AnimalAbstract{

    @Override
    public void voice() {
        System.out.println ("Кот мяукул");
    }

    public static void main(String[] args) {
        AnimalAbstract animalAbstract = new Cat1 ();
        animalAbstract.voice ();
        animalAbstract.jump ();
    }
}