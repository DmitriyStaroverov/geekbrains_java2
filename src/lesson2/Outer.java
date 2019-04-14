package lesson2;

public class Outer {

    private int outerVar;

    public Outer(int outerVar) {
        this.outerVar = outerVar;
    }

    class Inner {
        public int innerVar;

        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }

        void innerTest{
            System.out.println ("Inner " + innerVar);
            System.out.println ("Outer" + outerVar);
        }
    }

    void outerTest{
        System.out.println ("Outer" + outerVar);
    }

}
