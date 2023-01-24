package SortingAlgorithms;

/**
 * bubble sort algorithm. iterates through the array of values and compares the element against the next in the array
 * Values are swapped if next in the array is less than the value currently being iterated over
 */
public class BubbleSort implements ArraySortingInterface {

    public void sortArrays(int[][] arrays) {


        //setup some local variables for processing each array we are sorting
        int[] arrayToSort;

        //loop through our input arrays and sort them using the bubble sort algorithm
        for (int i = 0; i < arrays.length; i++) {

            //extracting the current array being sorted so the algorithm is a bit easier to understand
            arrayToSort = arrays[i];

            //go through the entire array until one less than the last element.
            //we stop before the last because we are always peeking one index further into the array
            for (int j = 0; j < arrayToSort.length - 1; j++) {

                //sweep through the array aga
                for (int k = 0; k < arrayToSort.length - j - 1; k++) {

                    if (arrayToSort[k] > arrayToSort[k + 1]) {
                        int temp = arrayToSort[k];
                        arrayToSort[k] = arrayToSort[k + 1];
                        arrayToSort[k + 1] = temp;
                    }
                }
            }
        }
    }
}
