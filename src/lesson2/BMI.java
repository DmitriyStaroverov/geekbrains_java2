package lesson2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;


public class BMI {

    static double[] parseLine(String line) {
        double[] rez = new double[2];
        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer ( line, " " );
        while (stringTokenizer.hasMoreTokens ()) {
            rez[i++] = Double.parseDouble ( stringTokenizer.nextToken () );
        }
        return rez;
    }

    public static void main(String[] args) {
        // чтение файла
        try {
            List<String> lines = Files.readAllLines ( Paths.get ( "C:/Users/dima/Dropbox/Обчучение GB_Java/BMI.txt" ), StandardCharsets.UTF_8 );
            for (String line :
                    lines) {
                double[] humenParam = parseLine ( line );
                double bmi = getBMI ( humenParam );
                System.out.println ( "Вес: " + String.format ( "%.2f", humenParam[0] ) + " кг Рост: " + String.format ( "%.2f", humenParam[1] ) +
                        " м. Индекс: " + String.format ( "%.2f", bmi ) + " соответствует: " + getBMIEnum ( bmi ).getRusName () );
            }
        } catch (IOException e) {
            e.printStackTrace ();
            System.exit ( 0 );
        }
    }

    static double getBMI(double[] param) {
        return param[0] / Math.pow ( param[1], 2.0 );
    }

    static BMICLASS getBMIEnum(double bmi) {
        BMICLASS rez;
        for (BMICLASS bmcl: BMICLASS.values ()){
            if(bmcl.getMin () <= bmi & bmi < bmcl.getMax ()){
                return  bmcl;
            }
        }
        System.out.println ("За пределами значений");
        return null;
    }

}

enum BMICLASS {

    UNDERWEIGHT ( 0.0, 18.5, "недостаточная масса" ),
    NORMALWEIGHT ( 18.5, 25.0, "норма" ),
    OVERWEIGHT ( 25.0, 30.0, "избыточная масса" ),
    OBESITY ( 30.0, 100.0, "ожирение" );

    /**
     * нижняя граница
     */
    private double min;

    /**
     * верхняя граница
     */
    private double max;

    /**
     * русскоязычное название
     */
    private String rusName;

    /**
     * возвращает русскоязычное название перечисления
     * @return
     */
    public String getRusName(){
        return rusName;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    BMICLASS(double min, double max, String rusName) {
        this.min = min;
        this.max = max;
        this.rusName = rusName;

    }
}