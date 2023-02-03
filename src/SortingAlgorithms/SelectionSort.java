package SortingAlgorithms;

/**
 * Selection sort algorithm. Sorts by iterating through the array. with each iteration an inner loop is used to find
 * the next smallest value ahead in the array. at the end of the inner loop the smallest value found is swapped with the
 * value at the outer loop's index. similar to bubble sort but we don't perform swapping operations until after the inner
 * loop finishes iterating
 */
public class SelectionSort implements ArraySortingInterface {

    public void sortArray(int[] array) {

        //outer loop through the entire array
        for (int i = 0; i < array.length; i++) {

            //set up a variable for tracking the index of the smallest index we find in the inner loop
            int smallestIndex = i;

            // innner loop through the rest of the array.
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) { // if the inner loop finds a smaller value update the smallest tracker
                    smallestIndex = j;
                }
            }

            //after the inner loop swap the value at the outer loop's index with the smallest we found with the inner loop
            int tempValue = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = tempValue;
        }
    } // O(n^2)

    public String getAlgorithmName() {
        return "Selection Sort";
    }
}
