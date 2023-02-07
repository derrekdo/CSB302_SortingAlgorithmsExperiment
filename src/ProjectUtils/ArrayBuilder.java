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
        halfOrdered(3),
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
     *
     * @return
     */
    public static HashMap<arrayTypes, int[][]> buildAllArrays() {

        StopWatch watch = new StopWatch();
        HashMap<arrayTypes, int[][]> arraysMap = new HashMap<arrayTypes, int[][]>();
        arraysMap.put(arrayTypes.random, buildRandomArrays());

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
