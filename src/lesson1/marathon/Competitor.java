package lesson1.marathon;

public interface Competitor {

    void run(int dist);
    void swim(int dist);
    void jump(int height);
    void info();
    boolean isActive();

}

class Animal implements Competitor{

    String name;
    String type;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String name, String type, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.type = type;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance){
            System.out.println (type + " " + name + " справился с дистанцией");
        } else {
            System.out.println (type + " " + name + " не справился с дистанцией");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance){
            System.out.println (type + " " + name + " справился с дистанцией");
        } else {
            System.out.println (type + " " + name + " не справился с дистанцией");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight){
            System.out.println (type + " " + name + " справился с высотой");
        } else {
            System.out.println (type + " " + name + " не справился с высотой");
            onDistance = false;
        }
    }

    @Override
    public void info() {
        System.out.println (type + " " + name + " на дистанции - " + onDistance);
    }

    @Override
    public boolean isActive() {
        return onDistance;
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super ( name, "Кот", 200, 10, 5 );
    }
}

class Dog extends Animal{

    public Dog(String name) {
        super ( name, "Пес", 50,5,10 );
    }
}