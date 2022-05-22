package project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Mini Project 3
 */

public class BufferReaderToArray {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        int n;
        int bufSize = 8192;
        char[] buf = new char[bufSize];
        int[][] chars = new int[256][2];
        int[][] copied;
        int pivot = 0;
        boolean m;

        for (int[] row : chars) {
            Arrays.fill(row, 0);
        }

        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/dimch/OneDrive/Documents/Java αρχεία CF/scrum.txt"));

        while ((n = bf.read(buf, 0, bufSize)) != -1) {
            sb.append(buf, 0, n);
            len += n;
        }

        for (int i = 0; i <= chars.length - 1; i++) {
            for (int j = 0; j <= chars[i].length - 1; j++) {
                chars[i][j] = 0;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            int a = sb.charAt(i);
            if (i == 0) {
                chars[i][0] = a;
                chars[i][1]++;
            }

            m = false;
            for (int j = 0; j < chars.length; j++){
                if (chars[j][0] == a) {
                    chars[j][1]++;
                    m = true;
                    break;
                }
            }
            if (!m) {
                pivot++;
                chars[pivot][0] = a;
                chars[pivot][1]++;
            }
        }

        copied = new int[pivot + 1][2];
        for (int i = 0; i <= pivot; i++) {
            copied[i] = Arrays.copyOf(chars[i], 2);
        }

        Arrays.sort(copied, (a1, a2) -> a1[0] - a2[0]);

        for (int i = 0; i <= pivot; i++) {
            System.out.println((char) copied[i][0] + ": " + copied[i][1]);

        }
    }
}