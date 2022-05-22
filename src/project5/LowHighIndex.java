package project5;

/**
 *  Mini Project 5
 */

public class LowHighIndex {

    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9};
        int key = 8;

        int[] index = getLowAndHighIndexOf(arr, key);

        if (index[0] == -1) System.out.println("Key not in array");
        else System.out.println("{low index, high index} = {" + index[0] + ", " + index[1] + "}");
    }

    public static int[] getLowAndHighIndexOf(int[] arr, int key){
        int[] index = new int[2];
        int appearance = 0;
        int firstAppearance = 0;
        int lastAppearance = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                appearance++;
                lastAppearance = i;
            }

            if (arr[i] == key) {
                if (appearance == 1)
                    firstAppearance = i;
            }
        }

        if (appearance == 1) {
            index[0] = firstAppearance;
            index[1] = firstAppearance;
        } else if (appearance > 1) {
            index[0] = firstAppearance;
            index[1] = lastAppearance;
        } else
            index[0] = -1;

        return index;
    }
}
