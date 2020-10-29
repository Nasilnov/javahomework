package lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date of creation: 26.10.2020
 */

public class Main {

    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random(); // [0;1)

    public static int fieldSizeX;
    public static int fieldSizeY;
    public static int fieldWon;
    public static char[][] field;

    public static void initMap() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        fieldWon = 4;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x)); //&& - and / || - or
        field[y][x] = HUMAN_DOT;
    }

    public static void pcTurn() {
        int x;
        int y;
        int[] point = checkPosition(HUMAN_DOT);
        if (point != null) {
            field[point[1]][point[0]] = PC_DOT;
        }
        else {
            do {
                x = RANDOM.nextInt(fieldSizeX); // 0...2
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(y, x));
            field[y][x] = PC_DOT;
        }
    }



    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public static boolean isEmptyCell(int y, int x) {

        return field[y][x] == EMPTY_DOT;
    }

    public  static boolean isHumanCell(int y, int x) {
        return field[y][x] == HUMAN_DOT;
    }

    public static int[] checkPosition (char c) {

        for (int xShift = 0; xShift <= (fieldSizeX - fieldWon); xShift++) {
            for (int yShift = 0; yShift <= (fieldSizeY - fieldWon); yShift++) {
                int won = 0;

                for (int x = xShift, y = yShift; x < fieldWon + xShift && y < fieldWon + yShift; x++, y++) {
                    if (field[x][y] == c) {
                        won++;
                    }
                    else {
                        won = 0;
                    }
                    if (won == fieldWon - 2) {
                        if (isValidCell(y - won, x - won) && isEmptyCell(y - won, x - won )  ) {
                            return new int[]{y - won, x - won};
                        }
                        for (int yShiftIn = y, xShiftIn = x; yShiftIn < fieldSizeY - 1; yShiftIn++, xShiftIn++ ) {
                            if (isValidCell(xShiftIn + 1, yShiftIn + 1) && isEmptyCell(xShiftIn + 1, yShiftIn + 1)) {
                                return new int[]{yShiftIn + 1, xShiftIn + 1};
                            }
                        }
                        break;
                    }
                }

                won = 0;
                for (int x = fieldWon - 1 + xShift, y = 0; x >= 0; x--, y++) {
                    if (field[x][y] == c) {
                        won++;
                    }
                    else {
                        won = 0;
                    }
                    if (won == fieldWon - 2) {
                        if (isValidCell(x + won, y - won ) && isEmptyCell(x + won, y - won )) {
                            return new int[]{y - won , x + won};
                        }
                        for (int yShiftIn = y, xShiftIn = x; yShiftIn < fieldSizeY - 1; yShiftIn++, xShiftIn-- ) {
                            if (isValidCell(xShiftIn - 1, yShiftIn + 1) && isEmptyCell(xShiftIn - 1, yShiftIn + 1)) {
                                return new int[]{yShiftIn + 1, xShiftIn - 1};
                            }
                        }
                        break;
                    }
                }
            }
        }

        for (int x = 0; x < fieldSizeX; x++) {
            int won = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    won++;
                }
                else {
                    won = 0;
                }
                if (won ==  fieldWon - 2 ) {
                    if (isValidCell(x, y - won) && isEmptyCell(x,y - won) ) {
                        return new int[]{y - won, x};
                    }
                    for (int yShift = y; yShift < fieldSizeY - 1 ; yShift++ ) {
                        if (isValidCell(x, yShift + 1) && isEmptyCell(x, yShift + 1) && (yShift + 1) < (fieldSizeY - 1)) {
                            return new int[]{yShift + 1, x};
                        }
                    }
                    break;
                }
            }
            won = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == c) {
                    won++;
                }
                else {
                    won = 0;
                }
                if (won ==  fieldWon - 2 ) {
                    if (isValidCell(y - won, x ) && isEmptyCell( y - won, x )) {
                        return new int[]{x, y - won};
                    }
                    for (int yShift = y; yShift < fieldSizeY - 1; yShift++ ) {
                        if (isValidCell(yShift + 1, x) && isEmptyCell(yShift + 1, x) && (yShift + 1) < (fieldSizeY - 1)) {
                            return new int[]{x, yShift + 1};
                        }
                    }
                    break;
                }
            }
        }

        for ( int y = 0; y < fieldSizeX; y++ ) {
            for (int x = 0; x < fieldSizeY; x++ ) {
                if (isHumanCell(y, x)) {
                    for (int yShift = y - 1; yShift <= y + 1; yShift++ ) {
                        for (int xShift = x - 1; xShift <= x + 1; xShift++ ) {
                            if (isValidCell(yShift , xShift) && isEmptyCell(yShift, xShift)) {
                                return new int[]{xShift, yShift};
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean checkWin(char c) {
        for (int x = 0; x < fieldSizeX; x++) {
            int won = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    won++;
                }
                if (won ==  fieldWon) {
                    return true;
                }
            }
            won = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == c) {
                    won++;
                }
                if (won ==  fieldWon) {
                    return true;
                }
            }
        }

        for (int xShift = 0; xShift <= (fieldSizeX - fieldWon); xShift++) {
            for (int yShift = 0; yShift <= (fieldSizeY - fieldWon); yShift++) {
                int won = 0;

                for (int x = xShift, y = yShift; x < fieldWon + xShift && y < fieldWon + yShift; x++, y++) {
                    if (field[x][y] == c) {
                        won++;
                    }
                    if (won == fieldWon) {
                        return true;
                    }
                }

                won = 0;
                for (int x = fieldWon - 1 + xShift, y = 0; x >= 0; x--, y++) {
                    if (field[x][y] == c) {
                        won++;
                    }
                    if (won == fieldWon) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Человек выиграл!!!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println();
            pcTurn();
            printMap();
            if (checkWin(PC_DOT)) {
                System.out.println("Компьютер выиграл!!! $(((");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println();
        }
    }

    /**
     * Полностью разобраться с кодом, попробовать переписать с нуля;
     * ^ Усовершенствовать метод проверки победы (через циклы);
     * ^ Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
     * ^^ Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока.
     */


}
