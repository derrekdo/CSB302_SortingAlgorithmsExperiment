package SortingAlgorithms;

import java.util.HashMap;

/**
 * Insertion sort algorithm using the input arrays. This version does not create a new
 * array to put the processed variables in order (linked list style). Algorithm iterates through
 * elements in the array comparing them against elements earlier in the array and swapping them if
 * the current element is smaller than the earlier elements
 */
public class InsertionSort implements ArraySortingInterface {

    public HashMap<int[], Integer> sortArrays(int[][] arrays) {

        //make a hashmap to store our output data
        HashMap<int[], Integer> output = new HashMap<int[], Integer>();

        //setup some local variables for processing each array we are sorting
        int[] arrayToSort;
        int operations;

        //loop through our input arrays and sort them using the insertion sort algorithm
        for (int i = 0; i < arrays.length; i++) {

            //initialize the processing variables
            arrayToSort = arrays[i];
            operations = 0;

            for (int j = 1; j < arrayToSort.length; j++) {
                //for each element in the array set a local variable to the element's value and
                // an additional iterator index to the index ahead of this current element
                int current = arrayToSort[j];
                int k = j - 1;

                operations += 4; // this is 4 operations I think...

                // loop until the additional iterator hits the front of the array AND
                // the elements we are iterating over are larger than the current element value

                while (k >= 0 && arrayToSort[k] > current) {
                    //swap elements if they are larger. decrement the additional iterator further toward the front
                    arrayToSort[k + 1] = arrayToSort[k];
                    k--;

                    operations += 4; // unsure if this is true...
                }
                arrayToSort[k + 1] = current; //put the current value wherever the additional iterator index ended up
            }

            //put our processed data into the hashmap for output
            output.put(arrayToSort, operations);
        }

        return output;
    }
}
