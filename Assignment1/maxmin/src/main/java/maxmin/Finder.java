package maxmin;

/**
 * Hello world!
 *
 */
public class Finder {
    public static void main(String[] args) {
    }

    public int findMax(int[] intArray) {
        if (intArray.length == 0) {
            throw new IllegalArgumentException("empty array");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
        }
        return max;
    }

    public int findMin(int[] intArray) {
        if (intArray.length == 0) {
            throw new IllegalArgumentException("empty array");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < min) {
                min = intArray[i];
            }
        }
        return min;
    }
}
