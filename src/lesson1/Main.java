
package lesson1;

public class Main {

    public static void main(String[] args) {

        int a = 5;
        byte b = 10;
        long c = 2000L;
        float d = 12.3f;
        double e = 256.36d;
        char f = '5';
        boolean g = false;
        String str = "Hello";

        System.out.println(calc(5f, 6f, 7f, 8f) );
        System.out.println(checkNumber(10f, 10.1f));
        System.out.println(checkHundred(852));
        System.out.println(checkYear(25));
    }

    public static float calc (float a, float b, float c, float d) {
        return  a * (b + (c / d));
    }

    public static String checkNumber (float a, float b) {
        return a > b ? "a больше b" : "а меньше b";
    }

    public static String checkHundred (int a) {
        if ( a > 100  & a <= 999) {
            return new StringBuilder(Integer.toString(a)).reverse().toString();
        }
        else {
            return Integer.toString(a);
        }
    }

    public static String checkYear ( int a ) {
        if ( (a%4 == 0 & a%100 != 0) || a%400 == 0) {
            return "Високосный";
        }
        else {
            return "Не високосный";
        }
    }
}
