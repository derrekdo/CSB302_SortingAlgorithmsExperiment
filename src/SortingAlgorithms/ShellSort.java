package SortingAlgorithms;

public class ShellSort implements ArraySortingInterface {

    public void sortArray(int[] array) {
        //holds the an element to be swapped
        int size = array.length;

        //interval is the space/gap between each element being compared
        //outer loop determine the gaps and reduces it each iteration
        for (int interval = size / 3; interval > 0; interval /= 3) {

            //performs insertion sort
            //each iteration compares the next element with the element at interval+1
            for (int i = interval; i < size; i++) {
                //holds element at interval
                int temp = array[i];
                int j;

                //compares the two gapped elements
                //array[j-interval] gives the element we are comparing with
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    //if the element at the interval is less than, swap it with the value it is compared with
                    array[j] = array[j - interval];
                }
                //changes the compared element to the original element at interval
                array[j] = temp;
            }
        }
    }

    public String getAlgorithmName() {
        return "Shell Sort";
    }
}
