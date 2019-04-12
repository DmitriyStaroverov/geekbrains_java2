package lesson2;

import java.util.Arrays;

public class RunTime {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[] arrStr1 = new String[4];
        Arrays.fill ( arrStr1,0,4,"1" );
        String[] arrStr2 = new String[4];
        Arrays.fill ( arrStr2,0,4,"2" );
        String[] arrStr3 = new String[4];
        Arrays.fill ( arrStr3,0,4,"3" );
        String[] arrStr4 = new String[4];
        Arrays.fill ( arrStr4,0,4,"4" );
        String[][] arrStr = {arrStr1,arrStr2,arrStr3, arrStr4};

        arrStr[1][2] = "2";
        System.out.println (sum ( arrStr ));

    }

    private static int sum(String[][] arrS) throws MyArraySizeException, MyArrayDataException{
        if (arrS.length != 4) throw new MyArraySizeException ("размер массива");
        int summa = 0;
            for (int i = 0; i < 4; i++) {
                if (arrS[i].length != 4) throw new MyArraySizeException ("размер массива");
                for (int j = 0; j < 4; j++) {
                    try {
                        summa += (Integer.parseInt ( arrS[i][j] ));
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException ( "Ошибка в ячейке ", i, j);
                    }

                }

            }
        return summa;
    }


    static class MyArraySizeException extends Error {
        MyArraySizeException(String message) {
            super ( message );
        }
    }

    static class MyArrayDataException extends Error{
        private int x;
        private int y;
        MyArrayDataException(String message, int x, int y) {
            super ( message );
            this.x = x;
            this.y = y;
        }

        @Override
        public String getMessage() {
            return (super.getMessage () + " координаты " + x + ":" + y);
        }
    }
}
