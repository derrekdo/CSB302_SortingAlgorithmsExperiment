package SortingAlgorithms;

/**
 * Insertion sort algorithm using the input arrays. This version does not create a new
 * array to put the processed variables in order (linked list style). Algorithm iterates through
 * elements in the array comparing them against elements earlier in the array and swapping them if
 * the current element is smaller than the earlier elements
 */
public class InsertionSort implements ArraySortingInterface {

    public void sortArray(int[] arrays) {

        for (int j = 1; j < arrays.length; j++) {
            //for each element in the array set a local variable to the element's value and
            // an additional iterator index to the index ahead of this current element
            int current = arrays[j];
            int k = j - 1;

            // loop until the additional iterator hits the front of the array AND
            // the elements we are iterating over are larger than the current element value

            while (k >= 0 && arrays[k] > current) {
                //swap elements if they are larger. decrement the additional iterator further toward the front
                arrays[k + 1] = arrays[k];
                k--;
            }
            arrays[k + 1] = current; //put the current value wherever the additional iterator index ended up
        }
    } // O(n^2)

    public String getAlgorithmName() {
        return "Insertion Sort";
    }
}
