package lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//      1 ----------------
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeArray(array1);
        Arrays.stream(array1).forEach(s -> System.out.printf("%d ", s));
        System.out.println("\n");
//      2------------------
        int[] array2 = new int[8];
        fillArray(array2);
        Arrays.stream(array2).forEach(s -> System.out.printf("%d ", s));
        System.out.println("\n");
//      3------------------
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        lessSix(array3);
        Arrays.stream(array3).forEach(s -> System.out.printf("%d ", s));
        System.out.println("\n");
//      4------------------
        int[][] array4 = new int[6][6];
        fillDiagonal(array4);
        for (int[] ints : array4) {
            Arrays.stream(ints).forEach(s -> System.out.printf("%d  ", s));
            System.out.println();
        }
        System.out.println("\n");
//      5------------------
        int[] array5 = new int[10];
        fillRandom(array5, 100);
        Arrays.stream(array5).forEach(s -> System.out.printf("%d  ", s));
        System.out.println();
        Arrays.stream(searchExtremum(array5)).forEach(s -> System.out.printf("%d  ", s));
        System.out.println("\n");

//      6------------------
        int[] array6 = new int[20];
        fillRandom(array6, 4);
        Arrays.stream(array6).forEach(s -> System.out.printf("%d  ", s));
        System.out.println();
        compareParts(array6);


    }

    public static void changeArray (int[] arr) {
        for (int i = 0; i < arr.length; i++ ) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

    public static void fillArray (int[] arr) {
        for (int i = 0,  j = 0; i < arr.length; i++, j += 3 ) {
            arr[i] = j;
        }
    }

    public static void lessSix (int[] arr) {
        for (int i = 0; i < arr.length; i++ ) {
            arr[i] = (arr[i] < 6) ? arr[i] * 6 : arr[i];
        }
    }

    public static void fillDiagonal (int[][] arr) {
//        поскольку массив квадратный то упрощаем:))
        for (int i = 0; i < arr.length; i++ ) {
             arr[i][i] = 1;
        }
    }
    public static void fillRandom (int[] arr, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max );
        }
    }

    public static int[] searchExtremum (int[] arr) {
        int[] extr =  {arr[0],arr[0]};
        for (int j : arr) {
            extr[0] = Math.min(j, extr[0]);
            extr[1] = Math.max(j, extr[1]);
        }
    return extr;
    }

    public static void compareParts (int[] arr) {
        int[] arrFront = new int[arr.length];
        int[] arrBack =  new int[arr.length];
        int comCount = 0;
        for (int i = 0; i < arr.length; i++ ) {
            arrFront[i] = (i == 0) ? arr[i] : arr[i] + arrFront[i-1];
        }

        for (int i = arr.length - 1, j = 0 ; i >= 0; i-- , j++ ) {
            arrBack[i] = (i == arr.length - 1) ? arr[i] : arr[i] + arrBack[i+1];
        }
        for (int i = 0; i < arr.length - 1; i++ ) {
            if ( arrFront[i] == arrBack[i+1]) {
                for (int j = 0; j <= i; j ++  ) {
                    System.out.printf("%d  ", arr[j]);
                }
                System.out.print("|| ");
                for (int k = i + 1; k < arr.length; k++) {
                    System.out.printf("%d  ", arr[k]);
                }
                comCount++;
                break;
            }
        }
        if (comCount == 0 ) {
            System.out.println("Нет совпадений");
        }
    }
}
