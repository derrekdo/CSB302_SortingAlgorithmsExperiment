package SortingAlgorithms;

/**
 * Insertion sort algorithm using the input arrays. This version does not create a new
 * array to put the processed variables in order (linked list style). Algorithm iterates through
 * elements in the array comparing them against elements earlier in the array and swapping them if
 * the current element is smaller than the earlier elements
 */
public class InsertionSort implements ArraySortingInterface {

    public void sortArrays(int[][] arrays) {

        //setup some local variables for processing each array we are sorting
        int[] arrayToSort;

        //loop through our input arrays and sort them using the insertion sort algorithm
        for (int i = 0; i < arrays.length; i++) {

            //initialize the processing variables
            arrayToSort = arrays[i];

            for (int j = 1; j < arrayToSort.length; j++) {
                //for each element in the array set a local variable to the element's value and
                // an additional iterator index to the index ahead of this current element
                int current = arrayToSort[j];
                int k = j - 1;

                // loop until the additional iterator hits the front of the array AND
                // the elements we are iterating over are larger than the current element value

                while (k >= 0 && arrayToSort[k] > current) {
                    //swap elements if they are larger. decrement the additional iterator further toward the front
                    arrayToSort[k + 1] = arrayToSort[k];
                    k--;

                }
                arrayToSort[k + 1] = current; //put the current value wherever the additional iterator index ended up
            }
        }
    }
}
