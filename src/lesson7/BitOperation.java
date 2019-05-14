package lesson7;

public class BitOperation {
    public static void main(String[] args) {
        int a = 9;
        int b = 15;
        System.out.println (a + "  = " + Integer.toBinaryString ( a ));
        System.out.println (b + " = " + Integer.toBinaryString ( b ));
        System.out.println ("a|b = " + Integer.toBinaryString ( a|b ) + " или " + (a|b));
        System.out.println ("a&b = " + Integer.toBinaryString ( a&b ) + " или " + (a&b));
        System.out.println ("a^b = " + Integer.toBinaryString ( a^b ) + " или " + (a^b));




    }
}
