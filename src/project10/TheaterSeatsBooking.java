package project10;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Mini Project 10
 */

public class TheaterSeatsBooking {

    public static void main(String[] args) throws IOException {

        char column;
        boolean[][] arr = new boolean[30][12];

        while (true) {
            int choice = 0;
            int row = 0;

            do {
                try {
                    printMenu();
                    choice = getChoice();
                    if (!isInRowLimits(row))
                        System.out.println("The number you entered is out of bounds. Please try again.");
                } catch (InputMismatchException e1) {
                    System.out.println("Error - Invalid option: Please try again.");
                }
            } while (!isChoiceInLimits(choice));

            if (choice == 3) {
                System.out.println("Exit program completed");
                break;
            }

            do {
                try {
                    do {
                        row = getRow();
                        if (!isInRowLimits(row))
                            System.out.println("The number you entered is out of bounds. Please try again.");
                    } while (!isInRowLimits(row));
                } catch (InputMismatchException e2) {
                    System.out.println("Error - Invalid row number: Please try again.");
                }
            } while (!isInRowLimits(row));

            do {
                column = getColumn();
                if (!isInColumnLimits(column))
                    System.out.println("The character you entered is out of bounds. Please try again.");
            } while (!isInColumnLimits(column));

            if (choice == 1)
            arr = bookSeat(column, row, arr);
            else
            arr = cancelSeat(column, row, arr);
        }
    }

    public static void printMenu() {
        System.out.println("Choose one of the following options:");
        System.out.println("1. Book a seat");
        System.out.println("2. Cancel a booked seat");
        System.out.println("3. Exit");
    }

    public static int getChoice() {
        try {
            Scanner in = new Scanner(System.in);
            int choice;

            System.out.println("Give option number:");
            choice = in.nextInt();

            return choice;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int getRow() {
        try {
            Scanner in = new Scanner(System.in);
            int row;

            System.out.println("Choose row number - 1-30:");
            row = in.nextInt();

            return row;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static char getColumn() throws IOException {
        char column;

        System.out.println("Choose seat in row - capital A-L:");

        do {
            column= (char) System.in.read();
        } while(column == '\n' | column == ' ' | column == '\t');

        return column;
    }

    public static boolean isChoiceInLimits (int choice) {

        return (choice == 1 || choice == 2 || choice == 3);
    }

    public static boolean isInRowLimits (int a) {

        return (a >= 1 && a <= 30);
    }

    public static boolean isInColumnLimits (char c) {

        return (!(c != 'A' && c != 'B' && c != 'C'&& c != 'D'&& c != 'E' && c != 'F'
                && c != 'G' && c != 'H' && c != 'I' && c != 'J' && c != 'K' && c != 'L'));
    }


    public static boolean[][] bookSeat(char column, int row, boolean[][] arr) {
        int i = row -1;
        int j = 0;

        switch (column) {
            case 'A':
                j = 0;
                break;
            case 'B':
                j = 1;
                break;
            case 'C':
                j = 2;
                break;
            case 'D':
                j = 3;
                break;
            case 'E':
                j = 4;
                break;
            case 'F':
                j = 5;
                break;
            case 'G':
                j = 6;
                break;
            case 'H':
                j = 7;
                break;
            case 'I':
                j = 8;
                break;
            case 'J':
                j = 9;
                break;
            case 'K':
                j = 10;
                break;
            case 'L':
                j = 11;
                break;
        }
        if (arr[i][j]) System.out.println("Seat " + column + row + " already booked.\n");
        else {
            arr[i][j] = true;
            System.out.println("Book completed for seat " + column + row);
            System.out.println();
        }

    return arr;
    }

    public static boolean[][] cancelSeat(char column, int row, boolean[][] arr) {
        int i = row -1;
        int j = 0;

        switch (column) {
            case 'A':
                j = 0;
                break;
            case 'B':
                j = 1;
                break;
            case 'C':
                j = 2;
                break;
            case 'D':
                j = 3;
                break;
            case 'E':
                j = 4;
                break;
            case 'F':
                j = 5;
                break;
            case 'G':
                j = 6;
                break;
            case 'H':
                j = 7;
                break;
            case 'I':
                j = 8;
                break;
            case 'J':
                j = 9;
                break;
            case 'K':
                j = 10;
                break;
            case 'L':
                j = 11;
                break;
        }
        if (!arr[i][j]) System.out.println("Cannot cancel, seat " + column + row + " is not booked.\n");
        else {
            arr[i][j] = false;
            System.out.println("Cancel completed for seat " + column + row);
            System.out.println();
        }

        return arr;
    }
}
