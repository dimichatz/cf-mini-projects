package project8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Mini Project 8
 */

public class TicTacToe {

    public static void main(String[] args) {
        boolean turn = false;
        boolean a = false;
        boolean b = false;
        boolean win = false;
        boolean tie = false;

        char[][] arr = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        int rowPosition = 0;
        int columnPosition = 0;

        System.out.println("~Tic-Tac-Toe Game~\n");

        do {
            System.out.println( !turn ? "Player's X turn:" : "Player's O turn:");

            showTicTacToe(arr);

            do {
                try {
                    System.out.println("Enter row position 1-3");
                    rowPosition = getPosition();
                    if (rowPosition == 1 || rowPosition == 2 || rowPosition == 3)
                        a = true;
                    else System.out.println("Invalid number. Please try again.");
                } catch (InputMismatchException e1) {
                    System.out.println("Error - Invalid row number: Please try again.");
                }
            } while (!a);

            do {
                try {
                    System.out.println("Enter column position 1-3");
                    columnPosition = getPosition();
                    if (columnPosition == 1 || columnPosition == 2 || columnPosition == 3)
                        b = true;
                    else System.out.println("Invalid number. Please try again.");
                } catch (InputMismatchException e2) {
                    System.out.println("Error - Invalid row number: Please try again.");
                }
            } while (!b);


            if (arr[rowPosition -1][columnPosition -1] == ' ') {
                if (!turn) {
                    arr[rowPosition -1][columnPosition -1] = 'X';
                } else {
                    arr[rowPosition -1][columnPosition -1] = 'O';
                }
            } else {
                System.out.println("This position is already filled. Try another one.");
                continue;
            }

            win = checkForWin(arr);
            tie = checkForTie(arr);


            if (!win && tie) {
                System.out.println("This Tic-Tac-Toe Game is a tie.");
                break;
            }
            turn = !turn;
        } while (!win);

        if (!tie) {
            if (turn) System.out.println("Player X Wins Game!");
            else System.out.println("Player O Wins Game!");
        }
        showTicTacToe(arr);

        System.out.println("\nThanks for playing.");
    }

    public static void showTicTacToe(char[][] arr) {
        System.out.println("|---|---|---|");

        for (char[] row: arr) {
            for (char column : row) {
                System.out.print("| " + column + " ");
            }

            System.out.println("|");
            System.out.println("|---|---|---|");
        }
    }

    public static int getPosition() {
        try {
            Scanner in = new Scanner(System.in);
            int position;

            position = in.nextInt();

            return position;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean checkForWin(char[][] arr) {
        boolean win = false;

        for (int i = 0; i < 3; i++) {
            if ((arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X') ||
                    (arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O') ||
                    (arr[0][i] == 'X' && arr[1][i] == 'X' && arr[2][i] == 'X') ||
                    (arr[0][i] == 'O' && arr[1][i] == 'O' && arr[2][i] == 'O')) {
                win = true;
                break;
            }
        }
        if ((arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') ||
                (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') ||
                (arr[2][0] == 'X' && arr[1][1] == 'X' && arr[0][2] == 'X') ||
                (arr[2][0] == 'O' && arr[1][1] == 'O' && arr[0][2] == 'O')) {
            win = true;
        }

        return win;
    }

    public static boolean checkForTie(char[][] arr) {
        boolean tie = true;

        for (char[] row: arr) {
            for (char column : row) {
                if (column == ' ') {
                    tie = false;
                    break;
                }
            }
        }

        return tie;
    }
}
