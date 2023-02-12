package SortingAlgorithms;

public abstract class AbstractQuickSort implements ArraySortingInterface{


    @Override
    public void sortArray(int[] array) {
        if (array.length > 9000){
            return;
        }
        quickSort(array, 0, array.length -1);
    }

    public abstract int getPivot(int[] nums, int left, int right);

    public void quickSort(int[] nums, int left, int right){
        if (left < right){
            int pivotRestingSpot = partition(nums, left, right);
            quickSort(nums, left, pivotRestingSpot -1);
            quickSort(nums, pivotRestingSpot + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right){

        int pivot = getPivot(nums, left, right);
        int i = (left - 1);

        for (int j = left; j < right; j++){
            if (nums[j] <= pivot){
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }


    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Override
    public String getAlgorithmName(){
        return getClass().getSimpleName();
    }
}
