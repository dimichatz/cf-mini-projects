package project9;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Mini project 9
 */

public class MessageCipher {

    public static void main(String[] args) {
        String initialStr, cipherStr, complementaryStr, decipherStr;
        int key = 0;
        char check;

        do {
            initialStr = getString();
            check =initialStr.charAt(initialStr.length() - 1);
            if (check != '#') System.out.println("Last character of the message must be symbol #. Please try again:");
        } while (check != '#');

            do {
            try {
                key = getKey();
            } catch (InputMismatchException e1) {
                System.out.println("Error - Invalid input: Please try again:");
            }
            if (key == 0) System.out.println("Value 0 not acceptable. Please try again:");
        } while (key == 0);

        cipherStr = getEncryptionCode(initialStr, key);
        System.out.println("Code after encryption:\n" + cipherStr);

        System.out.println();

        complementaryStr = getComplementaryCode(initialStr, key);
        System.out.println("Complementary code for deciphering purposes:\n" + complementaryStr);

        System.out.println();

        decipherStr = getDecryptionCode(cipherStr, complementaryStr, key);
        System.out.println("Code after deciphering:\n" + decipherStr);
    }

    public static String getString() {
        Scanner in = new Scanner(System.in);
        String str;

        System.out.println("Enter message for encryption - Message encryption ends with #:");
        str = in.nextLine();

        return str;
    }

    public static int getKey() {
        try {
            Scanner in = new Scanner(System.in);
            int key;

            System.out.println("Enter integer key - Except value 0:");
            key = in.nextInt();

            return key;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String getEncryptionCode(String str, int key) {
        int number;
        String code;

        if (str.charAt(0) == '#') {
            code = "-1";
        } else {
            code = (int) str.charAt(0) + " ";

            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == '#') {
                    code = code + "-1";
                    break;
                }

                number = (str.charAt(i) + str.charAt(i - 1)) % key;
                code = code + number + " ";
            }
        }

        return code;
    }

    /**
     * Παράγει συμπληρωμάτικό κώδικο που χρειάζεται για την αποκρυπτογράφηση.
     * Ο κώδικας προκύπτει από το πηλίκο κάθε ακέραιας τιμής που αντιστοιχεί στον χαρακτήρα ASCII,
     * προσθέτοντας την ακεραία τιμή του χαρακτήρα ASCII του προηγούμενου χαρακτήρα του μηνύματος,
     * διαιρώντας με το κλειδί
     * @param str   το αρχικό μήνυμα
     * @param key   το κλεδι
     * @return      sting με τον συμπληρωματικό κώδικα
     */
    public static String getComplementaryCode(String str, int key) {
        int complementaryNumber;
        String complementaryCode;

        complementaryCode = key * (((int) str.charAt(0)) / key) + (((int) str.charAt(0)) % key) + " ";

        for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == '#') break;

                complementaryNumber = (str.charAt(i) + str.charAt(i - 1)) / key;
                complementaryCode = complementaryCode + complementaryNumber + " ";
            }

        return complementaryCode;
    }

    /**
     * Για κάθε αριθμό που έχει προκύψει από την κρυπτογράφηση:
     * Βρίσκει το πηλικό από τον συμπληρωματικό κώδικα και το υπόλοιπο από τον κρυπτογραφημένο κώδικα.
     * Με το κλειδί παράγει το πηλίκο,το υπόλοιπο και την τιμή ASCII του προγούμενου χαρακτήρα,
     * μέσω της πράξης key*div + mod - int previousASCII
     * και τον μετατρέπει σε χαρακτήρα του αρχικού μηνύματος.
     * @param cipherStr ο κρυπτογραφημένος κώδικας
     * @param comStr    ο συμπληρωματικός κώδικας
     * @param key       το κλειδί
     * @return          τον αρχικού κώδικα
     */
    public static String getDecryptionCode(String cipherStr, String comStr, int key) {
        String code = "";
        String s = "";
        String s1 = "", s2 = "";
        int cipherPreviousSpacePosition = 0;
        int cipherNextSpacePosition;
        int comPreviousSpacePosition = 0;
        int comNextSpacePosition;
        int cipherSubstringNumber;
        int comSubstringNumber;
        int previousCharAsciiNumber = 0;

        if (cipherStr.charAt(0) == '-') {
            code = "#";
        } else {

            while (true) {
                if (cipherPreviousSpacePosition != 0 ) {
                    cipherNextSpacePosition = cipherStr.indexOf(" ", cipherPreviousSpacePosition + 1);
                    comNextSpacePosition = comStr.indexOf(" ", comPreviousSpacePosition + 1);
                    if (cipherNextSpacePosition == -1) {
                        code = code + "#";
                        break;
                    }

                    for (int i = cipherPreviousSpacePosition + 1; i < cipherNextSpacePosition; i++) {
                        s1 = s1 + cipherStr.substring(i, i + 1);
                    }
                    cipherSubstringNumber = Integer.parseInt(s1);

                    for (int i = comPreviousSpacePosition + 1; i < comNextSpacePosition; i++) {
                        s2 = s2 + comStr.substring(i, i + 1);
                    }
                    comSubstringNumber = Integer.parseInt(s2);

                    code = code + (char) (key * comSubstringNumber + cipherSubstringNumber - previousCharAsciiNumber);
                    previousCharAsciiNumber = (key * comSubstringNumber + cipherSubstringNumber - previousCharAsciiNumber);

                } else {
                    cipherNextSpacePosition = cipherStr.indexOf(" ", cipherPreviousSpacePosition);

                    for (int i = cipherPreviousSpacePosition; i < cipherNextSpacePosition; i++) {
                        s = s + cipherStr.substring(i, i + 1);
                    }

                    previousCharAsciiNumber = Integer.parseInt(s);
                    code = code + (char) Integer.parseInt(s);
                    comNextSpacePosition = cipherNextSpacePosition;
                }

                cipherPreviousSpacePosition = cipherNextSpacePosition;
                comPreviousSpacePosition = comNextSpacePosition;
                s1 = "";
                s2 = "";
            }
        }

        return code;
    }
}


