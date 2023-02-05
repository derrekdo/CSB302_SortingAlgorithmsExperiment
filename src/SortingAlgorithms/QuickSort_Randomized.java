package SortingAlgorithms;

import java.util.Random;

public class QuickSort_Randomized extends AbstractQuickSort {

    @Override
    public int getPivot(int[] nums, int left, int right) {
          Random rand= new Random();
          int pivot = rand.nextInt(right-left) + left;
          swap(nums, right, pivot);
          return nums[right];
    }
}
