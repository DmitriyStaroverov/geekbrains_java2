package lesson3;

import java.util.HashMap;

public class SetOfWords {
    public static void main(String[] args) {
        String[] arrStr = {"dsfsafd", "cats", "cat", "milk", "hjjg", "cats",
                "milk", "hdjshdfjsh", "milk", "cat", "dfgvbc", "cat"};
        HashMap<String, Integer> hashMap = new HashMap<> ();
        for (String str : arrStr) {
            hashMap.put ( str, hashMap.getOrDefault ( str, 0 ) + 1 );
        }
        System.out.println ( hashMap );
    }
}
