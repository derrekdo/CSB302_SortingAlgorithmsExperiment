package SortingAlgorithms;

public class MergeSort implements ArraySortingInterface {

    public void sortArray(int[] array) {
        if (array.length > 1) {
            array = split(array);
        }
    }

    public int[] split(int[] array) {
        //base case
        if (array.length == 1) {
            return array;
        }

        //the size of each subarray
        int half1 = array.length / 2;
        int half2 = array.length - half1;

        //subarrays to hold the elements
        int[] array1 = new int[half1];
        int[] array2 = new int[half2];

        //adds the first half of elements to first subarray
        for (int i = 0; i < half1; i++) {
            array1[i] = array[i];
        }

        //adds the second half of elements to second subarray
        for (int i = 0; i < half2; i++) {
            array2[i] = array[i + half1];
        }

        //recursive function to keep splitting arrays
        array1 = split(array1);
        array2 = split(array2);


        //places elements back into the array sorted
        array = merge(array, array1, array2);

        return array;
    }

    public int[] merge(int[] array, int[] array1, int[] array2) {
        //index of the merged and sub arrays
        int l = 0;
        int j = 0;
        int i = 0;

        //merges the elements in each subarray into 1 array, until one subarray has no more elements
        while (l != array1.length && j != array2.length) {
            //compares the elements in each subarray
            //and adds the lower element into the merged array and increments index
            if (array1[l] < array2[j]) {
                array[i] = array1[l];
                l++;
                i++;
            } else if (array1[l] > array2[j]) {
                array[i] = array2[j];
                j++;
                i++;
                //if both elements are the same add both to the merged array and increment both subarray
            } else if (array1[l] == array2[j]) {
                array[i] = array1[l];
                array[i + 1] = array2[j];
                j++;
                l++;
                i += 2;
            }
        }

        //adds all elements in the remaining subarray to the merged array
        if (l == array1.length) {
            while (j != array2.length) {
                array[i] = array2[j];
                i++;
                j++;
            }
        } else if (j == array2.length) {
            while (l != array1.length) {
                array[i] = array1[l];
                i++;
                l++;
            }
        }
        return array;
    }

    public String getAlgorithmName() {
        return "Merge Sort";
    }
}
