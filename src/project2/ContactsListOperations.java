package project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Mini Project 2
 * Πίνακας επαφών με στήλες: Επίθετο | Όνομα | Τηλέφωνο.
 */

public class ContactsListOperations {

    public static void main(String[] args) {
        int[][] pointer = new int[500][3];
        ArrayList<String> arr = new ArrayList<>();
        int choice;
        int k = 0;
        boolean contactExists = false;
        boolean newContactExists = false;
        boolean availableRow = false;

        String s;
        String s1;

        initializePointer(pointer);

        while (true) {
            do {
                choice = 0;
                try {
                    printMenu();
                    choice = getChoice();
                    if (!isInNumberLimit(choice))
                        System.out.println("Το ψηφίο που πληκτρολογήσατε δεν αντιστοιχεί σε επιλογή. Προσπαθήστε ξανά.");
                } catch (InputMismatchException e1) {
                    System.out.println("Σφάλμα - Δεν εισάγατε ψηφίο. Προσπαθήστε ξανά");
                }
            } while (!isInNumberLimit(choice));


            if (choice == 1) {
                System.out.println("Εισάγετε Τηλέφωνο προς Αναζήτηση Επαφής");
                s = getInput();
                if (arr.contains(s)) {
                    for (int i = 0; i < pointer.length; i++) {
                        if (pointer[i][2] == arr.indexOf(s)) {
                            contactExists = true;
                            System.out.println("Η επαφή με Επίθετο: " + arr.get(pointer[i][0]) + " Όνομα: " + arr.get(pointer[i][1]) +
                                    " Τηλέφωνο: " + s + " βρέθηκε στον πίνακα επαφών.\n");
                        }
                    }
                    if (!contactExists) System.out.println("Για το τηλέφωνο που εισάγατε δεν αντιστοιχεί επαφή.\n");
                } else System.out.println("Για το τηλέφωνο που εισάγατε δεν αντιστοιχεί επαφή.\n");
                contactExists = false;

            } else if (choice == 2) {
                System.out.println("Εισάγετε Τηλέφωνο προς Εισαγωγή Επαφής");
                s = getInput();
                if (arr.contains(s)) {
                    for (int i = 0; i < pointer.length; i++) {
                        if (pointer[i][2] == arr.indexOf(s)) {
                            System.out.println("Η επαφή υπάρχει ήδη.\n");
                            contactExists = true;
                        }
                    }
                }
                if (!contactExists) {
                    for (int i = 0; i < pointer.length; i++) {
                        if (pointer[i][2] == -1) {
                            availableRow = true;
                            k = i;

                            if (!arr.contains(s)) arr.add(s);
                            pointer[i][2] = arr.indexOf(s);

                            System.out.println("Εισάγετε Επίθετο προς Εισαγωγή Επαφής");
                            s = getInput();
                            if (!arr.contains(s)) arr.add(s);
                            pointer[i][0] = arr.indexOf(s);

                            System.out.println("Εισάγετε Όνομα προς Εισαγωγή Επαφής");
                            s = getInput();
                            if (!arr.contains(s)) arr.add(s);
                            pointer[i][1] = arr.indexOf(s);
                        }
                        if (availableRow) {
                            System.out.println("Πραγματοποιήθηκε εισαγωγή επαφής με Επίθετο: " + arr.get(pointer[k][0]) +
                                    " Όνομα: " + arr.get(pointer[k][1]) + " Τηλέφωνο: " + arr.get(pointer[k][2]) + "\n");
                            break;
                        }
                    }
                    if (!availableRow)
                        System.out.println("Δεν υπάρχει διαθέσιμος χώρος. Θα πρέπει πρώτα να διαγράψετε κάποια άλλη επαφή.\n");
                }
                contactExists = false;
                availableRow = false;
                k = 0;

            } else if (choice == 3) {
                System.out.println("Εισάγετε Τηλέφωνο προς Ενημέρωση Επαφής");
                s = getInput();
                if (arr.contains(s)) {
                    for (int i = 0; i < pointer.length; i++) {
                        if (pointer[i][2] == arr.indexOf(s)) {
                            contactExists = true;
                            k = i;
                            break;
                        }
                    }
                    if (contactExists) {
                        System.out.println("Ενημερώστε με το νεό Τηλέφωνο");
                        s1 = getInput();
                        if (arr.contains(s1)) {
                            for (int m = 0; m < pointer.length; m++) {
                                if (pointer[m][2] == arr.indexOf(s1)) {
                                    newContactExists = true;
                                    break;
                                }
                            }
                            if (!newContactExists) {
                                pointer[k][2] = arr.indexOf(s1);
                                System.out.println("Πραγματοποιήθηκε ενημέρωση επαφής, με στοιχεία ενημερωμένης επαφής Επίθετο: "
                                        + arr.get(pointer[k][0]) + " Όνομα: " + arr.get(pointer[k][1]) + " Τηλέφωνο: " + arr.get(pointer[k][2]) + "\n");
                            } else
                                System.out.println("Το τηλέφωνο με το οποιό θέλετε να ενημερώσετε την επαφή, ανήκει σε άλλη επαφή.\n");
                        } else {
                            arr.add(s1);
                            pointer[k][2] = arr.indexOf(s1);
                            System.out.println("Πραγματοποιήθηκε ενημέρωση επαφής, με στοιχεία ενημερωμένης επαφής Επίθετο: "
                                    + arr.get(pointer[k][0]) + " Όνομα: " + arr.get(pointer[k][1]) + " Τηλέφωνο: " + arr.get(pointer[k][2]) + "\n");
                        }
                    }

                } else System.out.println("Η επαφή δεν υπάρχει. Θα πρέπει να δημιουργήσετε καινούργια.\n");
                contactExists = false;
                newContactExists = false;
                k = 0;

            } else if (choice == 4) {
                System.out.println("Εισάγετε Τηλέφωνο προς Διαγραφή Επαφής.");
                s = getInput();
                if (arr.contains(s)) {
                    for (int i = 0; i < pointer.length; i++) {
                        if (pointer[i][2] == arr.indexOf(s)) {
                            System.out.println("Διαγράφηκε η επαφή με Επίθετο: " + arr.get(pointer[i][0]) +
                                    " Όνομα: " + arr.get(pointer[i][1]) + " Τηλέφωνο: " + arr.get(pointer[i][2]) +"\n");
                            contactExists = true;
                            pointer[i][0] = -1;
                            pointer[i][1] = -1;
                            pointer[i][2] = -1;

                        }
                        }
                    if (!contactExists) System.out.println("Η επαφή που θέλετε να διαγράψετε δεν υπάρχει.\n");
                 } else System.out.println("Η επαφή που θέλετε να διαγράψετε δεν υπάρχει.\n");
                contactExists = false;

            } else break;
        }
    }

    public static int[][] initializePointer(int[][] arr) {
        for (int[] row : arr) {
            Arrays.fill(row, -1);
        }

        return arr;
    }

    public static void printMenu() {
        System.out.println("Επιλέξτε μία από τις παρακάτω επιλογές");
        System.out.println("1. Αναζήτηση");
        System.out.println("2. Εισαγωγή");
        System.out.println("3. Ενημέρωση");
        System.out.println("4. Διαγραφή");
        System.out.println("5. Έξοδος");
    }

    public static int getChoice() {
        try {
            Scanner in = new Scanner(System.in);
            int choice;

            System.out.println("Δώστε επιλογή");
            choice = in.nextInt();

            return choice;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean isInNumberLimit(int a) {

        return (a >= 1 && a <= 5);
    }

    public static String getInput() {
        Scanner in = new Scanner(System.in);
        String str;

        str = in.nextLine();

        return str;
    }
}