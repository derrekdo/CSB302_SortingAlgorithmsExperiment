package SortingAlgorithms;

import java.util.Arrays;

//O(n) = n^2
public class QuickSort_Median_of_Three extends AbstractQuickSort {

    @Override
    public int getPivot(int[] nums, int left, int right) {
        int size = right - left + 1;
        if (size < 3){
            return nums[right];
        }

        int[] tempArr = new int[3];
        tempArr[0] = nums[left];
        tempArr[2] = nums[right];
        int mid = left + (right - left) / 2;
        tempArr[1] = nums[mid];

        Arrays.sort(tempArr);
        nums[left] = tempArr[0];
        nums[mid] = tempArr[2];
        nums[right] = tempArr[1];
        return nums[right];
    }
}
