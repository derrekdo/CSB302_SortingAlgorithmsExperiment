package SortingAlgorithms;

/**
 * bubble sort algorithm. iterates through the array of values and compares the element against the next in the array
 * Values are swapped if next in the array is less than the value currently being iterated over
 */
public class BubbleSort implements ArraySortingInterface {

    public void sortArray(int[] array) {

        //go through the entire array until one less than the last element.
        //we stop before the last because we are always peeking one index further into the array
        for (int j = 0; j < array.length - 1; j++) {

            //sweep through the array aga
            for (int k = 0; k < array.length - j - 1; k++) {

                if (array[k] > array[k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
    }

    public String getAlgorithmName() {
        return "Bubble Sort";
    }
}
