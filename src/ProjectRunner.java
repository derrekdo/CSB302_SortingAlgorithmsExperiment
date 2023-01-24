import SortingAlgorithms.ArraySortingInterface;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.InsertionSort;

import java.util.HashMap;
import java.util.Random;

public class ProjectRunner {
    static HashMap<String, ArraySortingInterface> sortingStrategies;

    public static void main(String[] args) {


        int[][] arrays = debugBasicArrays();

        buildStartegyList();
        sortArrays(arrays);
    }

    //add your sorting algorithms here.
    public static void buildStartegyList() {

        sortingStrategies = new HashMap<String, ArraySortingInterface>();
        sortingStrategies.put("Insertion Sort", new InsertionSort());
        sortingStrategies.put("Bubble Sort", new BubbleSort());
    }

    // replace this with the fancy array builder method
    public static int[][] debugBasicArrays() {

        int[][] output = new int[14][];

        Random rand = new Random();

        int size = 4;
        for (int i = 0; i < 14; i++) {
            output[i] = new int[size];
            size *= 2;

            for (int j = 0; j < output[i].length; j++) {
                int num = rand.nextInt(40000);
                output[i][j] = num;
            }
        }
        return output;
    }

    public static void sortArrays(int[][] arrays) {

        //make copy of arrays
        int[][] arrayCopies;

        for (ArraySortingInterface strategy : sortingStrategies.values()) {
            arrayCopies = copyArrays(arrays);
            strategy.sortArrays(arrayCopies);
        }
    }

    /**
     * array copy function because when we want to compare the sorting algorithm data we want to use the same array
     * contents for each algorithm to get the most accurate comparison
     */
    public static int[][] copyArrays(int[][] arrays) {

        int[][] arrayCopies = new int[arrays.length][];
        for (int i = 0; i < arrays.length; i++) {
            arrayCopies[i] = arrays[i].clone();
        }
        return arrayCopies;
    }

    //stub function for outputting data. use for debugging then remove once we come up with the actual display stuff
    public static void debugPrintDataRemoveMe(HashMap<int[], Integer> data) {

        for (int[] array : data.keySet()) {
            int operations = data.get(array);

            System.out.println("array: " + array.toString() + " has " + operations + " operations");
        }
    }
}
