package project4;

import java.util.Arrays;

/**
 * Mini Project 4
 */

public class ParkingNumberOfCars {

    public static void main(String[] args) {
        int[][] arr = {{1012, 1136}, {1137, 1417}, {1015, 1020}};
        int[][] newArr = new int[arr.length * 2][2];
        int n = 0;
        int time = 1137;
        int zeros = 0;
        int ones = 0;
        int parkedCars;

        for (int i = 0; i <= newArr.length - 1; i++) {
            newArr[i][1] = (i % 2 == 0 ? 1 : 0);
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++) {
                newArr[n][0] = arr[i][j];
                n++;
            }
        }

        Arrays.sort(newArr, (a1, a2) -> a1[0] - a2[0]);

        for (int i = 0; i <= newArr.length - 1; i++) {
        if (newArr[i][0] <= time) {
            if (newArr[i][1] == 1) ones++;
                else zeros++;
        }
        }

        parkedCars = ones - zeros;
        if (parkedCars == 0)
            System.out.println("Ο χώρος στάθμευσης είναι άδειος.");
        else if (parkedCars == newArr.length / 2)
            System.out.println("O χώρος στάθμευσης είναι γεμάτος με " + (newArr.length / 2) + " θέσεις κατειλημμένες.");
        else
            System.out.println("Στον χώρο στάθμευσης αυτή τη στιγμή βρίσκονται " + parkedCars + " οχήματα.");
    }
}