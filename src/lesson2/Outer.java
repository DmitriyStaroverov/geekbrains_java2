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

        void innerTest(){
            System.out.println ("Inner " + innerVar);
            System.out.println ("Outer " + outerVar);
        }
    }

    void outerTest(){
        System.out.println ("Outer " + outerVar);
    }
}

class OuterInnerMain{
    public static void main(String[] args) {
        Outer.Inner inner = new Outer( 5 ).new Inner ( 3 );
        inner.innerTest ();
        System.out.println (inner);
    }
}