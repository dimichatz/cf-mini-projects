package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
  * Mini Project 1
  */

public class CombinationsSix {

    public static void main(String[] args) {
        ArrayList<Integer> numbers;
        int p = 6;

        try {
            File outFile = new File("C:\\Users\\dimch\\OneDrive\\Documents\\Java αρχεία CF\\project1output.txt");
            PrintStream ps = new PrintStream(outFile);

            numbers = getInputToArray();
            if (!isListAmount(numbers)) System.out.println("File must contain at least 7 numbers and at most 49.");
            else if (!isListValues(numbers))
                System.out.println("File contains numbers out of range. File must contain integer numbers with values 1-49");
            else {
                Collections.sort(numbers);

                for (int i = 0; i <= numbers.size() - p; i++) {
                    for (int j = i + 1; j <= numbers.size() - p + 1; j++) {
                        for (int k = j + 1; k <= numbers.size() - p + 2; ++k) {
                            for (int m = k + 1; m <= numbers.size() - p + 3; m++) {
                                for (int n = m + 1; n <= numbers.size() - p + 4; n++) {
                                    for (int o = n + 1; o <= numbers.size() - 1; o++) {
                                        int[] arr = {numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(m), numbers.get(n), numbers.get(o)};
                                        if (isEven(arr) && (isOdd(arr)) && (isContiguous(arr)) && (isSameEnding(arr)) && (isSameTen(arr)))
                                                ps.printf("%d\t%d\t%d\t%d\t%d\t%d\n", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (FileNotFoundException e1) {
            System.out.println("File not found");
        }
    }

    /**
     * Διαβάζει ακέραιες τιμές από ένα αρχείο και τις αποθηκεύει σε μία λίστα
     * @return τη λίστα
     * @throws FileNotFoundException αν το αρχείο δεν υπάρχει
     */
    public static ArrayList<Integer> getInputToArray() throws FileNotFoundException {
        try {
            File inFile = new File("C:\\Users\\dimch\\OneDrive\\Documents\\Java αρχεία CF\\project1numbers.txt");
            Scanner in = new Scanner(inFile);
            int k;

            ArrayList<Integer> numbers = new ArrayList<>();

            while (in.hasNextInt()) {
                k = in.nextInt();
                if (k == -1) break;
                else numbers.add(k);
            }

            return numbers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Ελέγχει αν το πλήθος των τιμών που περιέχονται σε μία λίστα είναι εντός ορίων >6 και <=49
     * @param arr η λίστα
     * @return το αποτέλεσμα του ελέγχου
     */
    public static boolean isListAmount(ArrayList<Integer> arr) {

        return arr.size() > 6 && arr.size() <= 49;
    }

    /**
     * Ελέγχει αν οι τιμές όλων των αριθμών που περιέχονται σε μία λίστα είναι εντός ορίων >=1 και <=49
     * @param arr η λίστα
     * @return το αποτέλεσμα του ελέγχου
     */
    public static boolean isListValues(ArrayList<Integer> arr) {
        boolean value = true;

        for (int i = 0; i <= arr.size() - 1; ++i) {
            if (arr.get(i) < 1 || arr.get(i) > 49) {
                value = false;
                break;
            }
        }

        return value;
    }

    public static boolean isEven(int[] arr) {
        boolean condition = false;
        int k = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] % 2 == 0) k++;
        }
        if (k <= 4) condition = true;

        return condition;
    }

    public static boolean isOdd(int[] arr) {
        boolean condition = false;
        int k = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] % 2 != 0) k++;
        }
        if (k <= 4) condition = true;

        return condition;
    }

    public static boolean isContiguous(int[] arr) {
        boolean condition = false;
        int k = 0;

        for (int i = 0; i<= arr.length - 1; i++) {
            for (int j = 0; j<= arr.length - 1; j++) {
                if (arr[i] - arr[j] == 1) k++;
                if (arr[i] - arr[j] == 2) k++;
                if (arr[i] - arr[j] == 3) k++;
            }
        }
        if (k<3) condition = true;

        return condition;
    }

    public static boolean isSameEnding(int[] arr) {
        boolean condition = false;
        int k0, k1, k2, k3, k4, k5, k6, k7, k8, k9;
        k0 = k1 = k2 = k3 = k4 = k5 = k6 = k7 = k8 = k9 = 0;

        int m;

        for (int i = 0; i <= arr.length - 1; i++) {
            m = arr[i] % 10;

            switch (m) {
                case 0:
                    k0 +=1;
                    break;
                case 1:
                    k1 +=1;
                    break;
                case 2:
                    k2 +=1;
                    break;
                case 3:
                    k3 +=1;
                    break;
                case 4:
                    k4 +=1;
                    break;
                case 5:
                    k5 +=1;
                    break;
                case 6:
                    k6 +=1;
                    break;
                case 7:
                    k7 +=1;
                    break;
                case 8:
                    k8 +=1;
                    break;
                case 9:
                    k9 +=1;
                    break;
            }
        }
        if (k0 <= 3 && k1 <= 3 && k2 <= 3 && k3 <= 3 && k4 <= 3 && k5 <= 3 && k6 <= 3 && k7 <= 3 && k8 <= 3 && k9 <= 3)
            condition = true;

        return condition;
    }

    public static boolean isSameTen(int[] arr) {
        boolean condition = false;
        int k0, k1, k2, k3, k4, k5, k6, k7, k8, k9;
        k0 = k1 = k2 = k3 = k4 = k5 = k6 = k7 = k8 = k9 = 0;

        int m;

        for (int i = 0; i <= arr.length - 1; i++) {
            m = arr[i] / 10;

            switch (m) {
                case 0:
                    k0 +=1;
                    break;
                case 1:
                    k1 +=1;
                    break;
                case 2:
                    k2 +=1;
                    break;
                case 3:
                    k3 +=1;
                    break;
                case 4:
                    k4 +=1;
                    break;
                case 5:
                    k5 +=1;
                    break;
                case 6:
                    k6 +=1;
                    break;
                case 7:
                    k7 +=1;
                    break;
                case 8:
                    k8 +=1;
                    break;
                case 9:
                    k9 +=1;
                    break;
            }
        }
        if (k0 <= 3 && k1 <= 3 && k2 <= 3 && k3 <= 3 && k4 <= 3 && k5 <= 3 && k6 <= 3 && k7 <= 3 && k8 <= 3 && k9 <= 3)
            condition = true;

        return condition;
    }
}