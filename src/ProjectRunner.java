import ProjectUtils.AlgorithmTestResults;
import ProjectUtils.ArrayBuilder;
import ProjectUtils.StopWatch;
import ProjectUtils.TestOutputWriter;
import SortingAlgorithms.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectRunner {

    //helper classes
    static ArrayList<ArraySortingInterface> sortingStrategies;
    static StopWatch stopWatch;

    //data output
    static HashMap<String, AlgorithmTestResults> writeToFileResults;
    static ArrayList<String> printToTerminalResults;

    //main function. instantiates and initializes all of our necessary helper objects and test data
    public static void main(String[] args) throws IOException {

        HashMap<ArrayBuilder.arrayTypes, int[][]> testArrayTypes = ArrayBuilder.buildAllArrays();
        stopWatch = new StopWatch();
        writeToFileResults = new HashMap<String, AlgorithmTestResults>();
        printToTerminalResults = new ArrayList<String>();

        buildStartegyList();

        sortArrays(testArrayTypes);

        TestOutputWriter.printResults(printToTerminalResults);
        TestOutputWriter.makeOutputCSVFile(writeToFileResults);
    }

    /**
     * Function for adding the sorting algorithms to the list. Later they are used one by one to sort arrays of
     * integers. Implements strategy pattern
     */
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

    /**
     * Helper function for iterating through each sorting algorithm then ordering type and sorting the data
     * data is recorded twice - first for output to terminal and then to a data object for creating a csv file
     *
     * @param testArraysByTypes the type of arrays to be sorted (random, reverse ordered, etc)
     */
    public static void sortArrays(HashMap<ArrayBuilder.arrayTypes, int[][]> testArraysByTypes) {

        int totalOrderingTypes = ArrayBuilder.arrayTypes.values().length;
        int totalSortingAlgorithms = sortingStrategies.size();

        //iterate through the sorting algorithms
        for (ArraySortingInterface strategy : sortingStrategies) {

            //set up a new results data object to store results in
            AlgorithmTestResults results = new AlgorithmTestResults(strategy.getAlgorithmName(),
                    totalOrderingTypes, totalSortingAlgorithms);

            //iterate through the different array ordering types and sort them
            for (ArrayBuilder.arrayTypes type : testArraysByTypes.keySet()) {

                //label the data results
                results.addOrderingType(type.getIndex(), type.toString());

                //make a copy of the arrays so we have the same data between each algorithm
                int[][] testsArrays = testArraysByTypes.get(type);
                int[][] testArrayCopies = ArrayBuilder.copyArrays(testsArrays);

                timeThisSort(type, strategy, testArrayCopies, results);

                //add the results to the database of collected test results
                writeToFileResults.put(strategy.getAlgorithmName(), results);
            }
        }
    }// O(n^2)

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
            printToTerminalResults.add(printResult);
        }
    }
}
