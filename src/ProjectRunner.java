import SortingAlgorithms.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectRunner {
    static ArrayList<ArraySortingInterface> sortingStrategies;
    static StopWatch stopWatch;
    static HashMap<String, AlgorithmTestResults> testResults;
    static ArrayList<String> printResults; // delete this later. this is for debug now
    static int totalOrderingTypes;
    static int totalSortingAlgorithms;

    public static void main(String[] args) throws IOException {

        HashMap<ArrayBuilder.arrayTypes, int[][]> testArrayTypes = ArrayBuilder.buildAllArrays();
        stopWatch = new StopWatch();
        testResults = new HashMap<String, AlgorithmTestResults>();
        printResults = new ArrayList<String>();

        buildStartegyList();

        totalOrderingTypes = ArrayBuilder.arrayTypes.values().length;
        totalSortingAlgorithms = sortingStrategies.size();

        sortArrays(testArrayTypes);
        printResults();
        OutputMaker.makeCSV(testResults);
    }

    //add your sorting algorithms here.
    public static void buildStartegyList() {

        sortingStrategies = new ArrayList<ArraySortingInterface>();
        sortingStrategies.add(new InsertionSort());
        sortingStrategies.add(new BubbleSort());
        sortingStrategies.add(new SelectionSort());
        sortingStrategies.add(new MergeSort());
        sortingStrategies.add(new ShellSort());
        sortingStrategies.add(new HeapSort());
        sortingStrategies.add(new QuickSort());
        sortingStrategies.add(new QuickSort_Randomized());
        sortingStrategies.add(new QuickSort_Median_of_Three());
    }

    public static void sortArrays(HashMap<ArrayBuilder.arrayTypes, int[][]> testArrayTypes) {

        //iterate through the sorting algorithms
        for (ArraySortingInterface strategy : sortingStrategies) {

            //set up a new results data object to store results in
            AlgorithmTestResults results = new AlgorithmTestResults(strategy.getAlgorithmName(),
                    totalOrderingTypes, totalSortingAlgorithms);

            //iterate through the different array ordering types and sort them
            for (ArrayBuilder.arrayTypes type : testArrayTypes.keySet()) {

                //label the data results
                results.addOrderingType(type.getIndex(), type.toString());

                //make a copy of the arrays so we have the same data between each algorithm
                int[][] arrayConfig = testArrayTypes.get(type);
                int[][] arrayCopies = copyArrays(arrayConfig);

                timeThisSort(type, strategy, arrayCopies, results);

                //add the results to the database of collected test results
                testResults.put(strategy.getAlgorithmName(), results);
            }
        }
    }

    // helper function to make the sortArrays function a bit easier to read
    private static void timeThisSort(ArrayBuilder.arrayTypes type, ArraySortingInterface strategy,
                                     int[][] arrayCopies, AlgorithmTestResults result) {

        int[] arraySizeData = new int[arrayCopies.length];
        String[] arrayTimingData = new String[arrayCopies.length];

        for (int i = 0; i < arrayCopies.length; i++) {

            int arraySize = arrayCopies[i].length;

            stopWatch.start();
            strategy.sortArray(arrayCopies[i]);
            stopWatch.end();

            arraySizeData[i] = arraySize;
            arrayTimingData[i] = stopWatch.getDuration();
            result.addData(type.getIndex(), arraySizeData, arrayTimingData);

            String printResult = String.format("Algorithm: %s. Array type: %s %s elements Time spent: %s",
                    strategy.getAlgorithmName(), type.toString(), arraySize, stopWatch.getDuration());

            stopWatch.reset();
            printResults.add(printResult);
        }
    }

    /**
     * array copy function because when we want to compare the sorting algorithm data we want to use the same array
     * contents for each algorithm to get the most accurate comparison
     * <p>
     * Note: we should probably move this to the array builder class to make this one a bit cleaner
     */
    public static int[][] copyArrays(int[][] arrays) {

        int[][] arrayCopies = new int[arrays.length][];
        for (int i = 0; i < arrays.length; i++) {
            arrayCopies[i] = arrays[i].clone();
        }
        return arrayCopies;
    }

    public static void printResults() {
        for (String result : printResults) {
            System.out.println(result);
        }
    }
}
