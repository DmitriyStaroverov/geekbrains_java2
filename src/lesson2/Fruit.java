package lesson2;

public enum Fruit {
    ORANGE("Апельсин",1),
    BANANA("Банан",2),
    APPLE("Яблоко",3),
    CHERRY("Вишня",2);

    private String rusName;

    private int height;

    Fruit(String rusName, int height) {
        this.rusName = rusName;
        this.height = height;
    }

    public String getRusName() {
        return rusName;
    }

    public int getHeight() {
        return height;
    }
}

class MainEnum{
    public static void main(String[] args) {
        Fruit fruit = Fruit.APPLE;

        if (fruit == Fruit.APPLE){
            System.out.println ("Это яблоко");
        }

        System.out.println ("------------");
        for (Fruit fr: Fruit.values ()){
            System.out.println (fr);
        }
        System.out.println ("------------");
        System.out.println (Fruit.valueOf ( "BANANA" ));
        System.out.println ("------------");
        System.out.println (Fruit.BANANA.ordinal ());
        System.out.println ("------------");
        for (Fruit fr: Fruit.values ()){
            System.out.println (fr.getRusName () + ", " + fr.getHeight ());
        }

    }
}
