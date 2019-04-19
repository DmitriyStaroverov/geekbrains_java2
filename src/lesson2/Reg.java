package lesson2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {
    public static void main(String[] args) {
        System.out.println ( testPass ( "Java" ));
        System.out.println ( testPass ( "Javajava2er" ));
        System.out.println ( testPass ( "Java" ));
        System.out.println ( testPass ( "Ja35v78a" ));
        System.out.println ( testPass ( "2jaVa485" ));
        System.out.println ( testPass ( "JAVA8ю" ));
        System.out.println ( testPass ( "Java" ));
        System.out.println ( testPass ( "java" ));
        System.out.println ( testPass ( "ПРИВЕТ" ));
        System.out.println ( testPass ( "Java" ));
        System.out.println ( testPass ( "приВет" ));
    }

    public static boolean testPass(String testString){
        boolean rez = false;
        // не менее 8ми символов
        Pattern p0 = Pattern.compile ("^.{8,}$");
        // есть цифры
        Pattern p1 = Pattern.compile (".*\\d+.*");
        // есть заглавные буквы
        Pattern p2 = Pattern.compile (".*[A-ZА-Я]+.*");
        // есть прописные
        Pattern p3 = Pattern.compile (".*[a-zа-я]+.*$");

        Pattern pattern = Pattern.compile ( "(?=.*\\d)(?=.*[A-ZА-Я])(?=.*[a-zа-я])+.{8,}" );

        Matcher matcher0 = p0.matcher ( testString );
        Matcher matcher1 = p1.matcher ( testString );
        Matcher matcher2 = p2.matcher ( testString );
        Matcher matcher3 = p3.matcher ( testString );

        Matcher matcher = pattern.matcher ( testString );

        return matcher.matches ();
        //return matcher0.matches() & matcher1.matches() & matcher2.matches() & matcher3.matches();
    }
}
