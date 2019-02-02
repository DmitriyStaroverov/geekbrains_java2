package lesson2;

import java.util.Arrays;

public class Arr7 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        changeArr(arr, -1);
    }

    private static void changeArr(int[] arr, int n) {

        //int oValue = arr[n];
        for (int i = 0; i < arr.length; i++) {

            int nIndex =  i+n;
            if (nIndex >= arr.length){
                nIndex = i-arr.length+n;
            }


            System.out.println(nIndex);



        }

        System.out.println(Arrays.toString(arr));
    }


}
