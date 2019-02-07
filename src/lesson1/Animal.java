package lesson1;

public class Animal {
    private String name;
    protected int weight;

    public String getName() {
        return name;
    }

    void voice() {
        System.out.println("Животное издало какой-то звук");
    }

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        weight = 1;
    }

    public void animalInfo(){
        System.out.println ("Животное: " + this.name + " ,вес: " +weight);
    }

    public void jump(){
        System.out.println ("Животное подпрыгнуло");
    }


}
