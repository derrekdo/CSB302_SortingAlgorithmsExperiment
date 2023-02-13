package ProjectUtils;

import java.util.HashMap;
import java.util.Random;

/**
 * Class for making arrays of integers for our algorithms to sort
 */
public class ArrayBuilder {

    //constants based on project requirements
    private static final int TOTAL_ARRAYS = 14;
    private static final int ARRAY_SIZE_MULTIPLIER = 2;
    private static final int INITIAL_ARRAY_SIZE = 4;
    private static final int LARGEST_INT_SIZE = 40000;

    private static Random rand = new Random();

    // enum set up so we can also use it like an index in other areas of the project
    public enum arrayTypes {
        random(0),
        reverseOrdered(1),
        ordered(2),
        halfRandom(3),
        quarterRandom(4);

        private int index;

        arrayTypes(int i) {
            index = i;
        }

        public int getIndex() {
            return index;
        }

    }

    /**
     * Master function for building the container with our arrays to be sorted via algorithms.
     * contains 5 types of arrays:
     * <p>
     * randomly ordered arrays
     * reverse ordered array
     * ordered arrays'
     * 50% ordered array
     * 75% ordered array
     * <p>
     * each type is loaded into the container with 14 different lengths.( 4, 8, 16...32768 elements)
     */
    public static HashMap<arrayTypes, int[][]> buildAllArrays() {

        HashMap<arrayTypes, int[][]> arraysMap = new HashMap<arrayTypes, int[][]>();

        arraysMap.put(arrayTypes.random, buildRandomArrays());
        arraysMap.put(arrayTypes.ordered, buildSorted());
        arraysMap.put(arrayTypes.reverseOrdered, buildReversedArrays());
        arraysMap.put(arrayTypes.halfRandom, buildHalfOrdered());
        arraysMap.put(arrayTypes.quarterRandom, buildQuarterRandom());

        return arraysMap;
    }

    /**
     * helper function for initializing a 2D array of integers for the other array builder functions
     *
     * @return
     */
    private static int[][] arrayInitializer() {

        int[][] output = new int[TOTAL_ARRAYS][];

        int size = INITIAL_ARRAY_SIZE;
        for (int i = 0; i < TOTAL_ARRAYS; i++) {
            output[i] = new int[size];
            size *= ARRAY_SIZE_MULTIPLIER;
        }
        return output;
    }

    /**
     * function for building entirely randomized arrays
     *
     * @return a 2D array of randomly ordered arrays
     */
    public static int[][] buildRandomArrays() {

        int[][] output = arrayInitializer();

        for (int i = 0; i < output.length; i++) {

            for (int j = 0; j < output[i].length; j++) {
                int num = rand.nextInt(LARGEST_INT_SIZE);
                output[i][j] = num;
            }
        }
        return output;
    }

    /**
     * function for building ordered arrays that are in reverse
     *
     * @return a 2D array of reverse ordered integers
     */
    public static int[][] buildReversedArrays() {
        int[][] nums = buildRandomArrays();
        for (int[] num : nums) {
            reverseSort(num);
        }

        return nums;
    }

    /**
     * Function for building a 2D array of sorted arrays
     *
     * @return a 2D array of sorted integers
     */
    public static int[][] buildSorted() {
        int[][] nums = buildRandomArrays();
        for (int[] num : nums) {
            sort(num, 0);
        }

        return nums;
    }

    /**
     * Function for building arrays of half ordered integers
     *
     * @return a 2D array of partially (half) sorted integers
     */
    public static int[][] buildHalfOrdered() {
        int[][] nums = buildRandomArrays();
        for (int[] num : nums) {
            sort(num, (num.length) / 2 + 1);
        }

        return nums;
    }

    /**
     * Function for building a partially sorted array of numbers
     *
     * @return a 2D array of partially sorted (25%) integers
     */
    public static int[][] buildQuarterRandom() {
        int[][] nums = buildRandomArrays();
        for (int[] num : nums) {
            int end = num.length * 3 / 4 + 1;
            sort(num, end);
        }

        return nums;
    }

    /**
     * function for partially sorting an array
     *
     * @param nums the array of numbers to be partially sorted
     * @param end  the index in the array to sort to
     */
    public static void sort(int[] nums, int end) {

        for (int i = 0; i < nums.length - 1 && i < end; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    /**
     * Function for sorting an array in descending order
     *
     * @param nums array of numbers to be sorted
     */
    public static void reverseSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[index]) {
                    index = j;
                }
            }

            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }


    /**
     * array copy function because we want to use the same data in each of our algorithms for accurate timing results
     * Also, the algorithms modify the incoming arrays so we need to preserve the data before handing over to be sorted
     *
     * @param arrays The arrays you want to copy
     * @return a 2D integer array with a deep copy of the original array elements
     */
    public static int[][] copyArrays(int[][] arrays) {

        int[][] arrayCopies = new int[arrays.length][];
        for (int i = 0; i < arrays.length; i++) {
            arrayCopies[i] = arrays[i].clone();
        }

        return arrayCopies;
    }
}
