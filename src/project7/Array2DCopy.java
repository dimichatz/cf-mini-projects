package project7;

/**
 * Mini Project 7
 */

public class Array2DCopy {

    public static void main(String[] args) {
        int[][] arr = { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        int[][] shallowCopyArr;
        int[][] deepCopyArr;

        shallowCopyArr = shallowCopy(arr);

        shallowCopyArr[0][0] = 50;
        shallowCopyArr[1][2] = 50;
        System.out.println(" Πίνακας arr: " + arr[0][0] + ", " + arr[1][2]);
        System.out.println(" Πίνακας shallowCopyArr: " +    shallowCopyArr[0][0] + ", " + shallowCopyArr[1][2]);

        System.out.println();

        deepCopyArr = deepCopy(arr);

        deepCopyArr[0][0] = -1;
        deepCopyArr[1][2] = -1;
        System.out.println(" Πίνακας arr: " + arr[0][0] + ", " + arr[1][2]);
        System.out.println(" Πίνακας deepCopyArr: " +    deepCopyArr[0][0] + ", " + deepCopyArr[1][2]);
    }

    public static int[][] shallowCopy(int[][] arr) {
        int[][] copyArr = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = new int[arr[i].length];
            System.arraycopy(arr[i], 0, copyArr[i], 0, arr[i].length);
        }

        return arr;
    }

    public static int[][] deepCopy(int[][] arr) {
        int[][] copyArr = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        return copyArr;
    }
}


