package SortingAlgorithms;

import java.util.HashMap;

/**
 * bubble sort algorithm. iterates through the array of values and compares the element against the next in the array
 * Values are swapped if next in the array is less than the value currently being iterated over
 */
public class BubbleSort implements ArraySortingInterface {

    public HashMap<int[], Integer> sortArrays(int[][] arrays) {

        //make a hashmap to store our output data
        HashMap<int[], Integer> output = new HashMap<int[], Integer>();

        //setup some local variables for processing each array we are sorting
        int[] arrayToSort;
        int operations;

        //loop through our input arrays and sort them using the bubble sort algorithm
        for (int i = 0; i < arrays.length; i++) {

            //extracting the current array being sorted so the algorithm is a bit easier to understand
            arrayToSort = arrays[i];
            operations = 0;
            //go through the entire array until one less than the last element.
            //we stop before the last because we are always peeking one index further into the array
            for (int j = 0; j < arrayToSort.length - 1; j++) {
                operations += 3;
                //sweep through the array aga
                for (int k = 0; k < arrayToSort.length - j - 1; k++) {
                    operations += 3;
                    if (arrayToSort[k] > arrayToSort[k + 1]) {
                        int temp = arrayToSort[k];
                        arrayToSort[k] = arrayToSort[k + 1];
                        arrayToSort[k + 1] = temp;
                        operations += 7;
                    }
                }
            }
            //put our processed data into the hashmap for output
            output.put(arrayToSort, operations);
        }

        return output;
    }
}
