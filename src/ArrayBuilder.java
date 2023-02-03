import java.util.HashMap;
import java.util.Random;

public class ArrayBuilder {

    private static Random rand = new Random();

    public enum arrayTypes {
        random(0),
        reverseOrdered(1),
        ordered(2),
        halfOrdered(3),
        quarterRandom(4);

        int index;

        arrayTypes(int i) {
            index = i;
        }

        int getIndex() {
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

        HashMap<arrayTypes, int[][]> arraysMap = new HashMap<arrayTypes, int[][]>();
        arraysMap.put(arrayTypes.random, buildRandomArrays());


        return arraysMap;
    }

    /**
     * function for making 2D array for the builder functions
     *
     * @return
     */
    private static int[][] arrayInitializer() {

        int[][] output = new int[14][];

        int size = 4;
        for (int i = 0; i < 14; i++) {
            output[i] = new int[size];
            size *= 2;
        }
        return output;
    }

    /**
     * function for building entirely randomized arrays
     *
     * @return
     */
    private static int[][] buildRandomArrays() {

        int[][] output = arrayInitializer();

        for (int i = 0; i < output.length; i++) {

            for (int j = 0; j < output[i].length; j++) {
                int num = rand.nextInt(40000);
                output[i][j] = num;
            }
        }
        return output;
    }
}
