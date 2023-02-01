import SortingAlgorithms.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectRunner {
    static ArrayList<ArraySortingInterface> sortingStrategies;
    static StopWatch stopWatch;
    static ArrayList<String> results;

    public static void main(String[] args) {

        HashMap<ArrayBuilder.arrayTypes, int[][]> testArrays = ArrayBuilder.buildAllArrays();
        stopWatch = new StopWatch();
        results = new ArrayList<String>();

        buildStartegyList();
        sortArrays(testArrays);
        printResults();
    }

    //add your sorting algorithms here.
    public static void buildStartegyList() {

        sortingStrategies = new ArrayList<ArraySortingInterface>();
        sortingStrategies.add(new InsertionSort());
        sortingStrategies.add(new BubbleSort());
        sortingStrategies.add((new SelectionSort()));
        sortingStrategies.add(new MergeSort());
    }

    public static void sortArrays(HashMap<ArrayBuilder.arrayTypes, int[][]> testArrays) {

        //iterate through the kv pairs. use the key as the iterator so that we use it later to print what ordering we sorted
        for (ArrayBuilder.arrayTypes type : testArrays.keySet()) {

            //extract the int arrays for copying then sorting
            int[][] arrayConfig = testArrays.get(type);
            //make copy of arrays
            int[][] arrayCopies;

            for (ArraySortingInterface strategy : sortingStrategies) {
                arrayCopies = copyArrays(arrayConfig);
                timeThisSort(type, strategy, arrayCopies);
            }
        }
    }

    // helper function to make the sortArrays function a bit easier to read
    private static void timeThisSort(ArrayBuilder.arrayTypes type, ArraySortingInterface strategy, int[][] arrayCopies) {

        for (int i = 0; i < arrayCopies.length; i++) {

            int arraySize = arrayCopies[i].length;

            stopWatch.start();
            strategy.sortArray(arrayCopies[i]);
            stopWatch.end();

            String result = String.format("Algorithm: %s. Array type: %s %s elements Time spent: %s",
                    strategy.algorithmName(), type.toString(), arraySize, stopWatch.getDuration());
            stopWatch.reset();
            results.add(result);
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

    public static void printResults() {
        for (String result : results) {
            System.out.println(result);
        }
    }
}
