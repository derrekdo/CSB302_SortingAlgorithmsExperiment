package SortingAlgorithms;

import java.util.Random;

//O(n) = n^2
public class QuickSort_Randomized extends AbstractQuickSort {

    @Override
    public int getPivot(int[] nums, int left, int right) {
          Random rand= new Random();
          int pivot = rand.nextInt(right-left + 1) + left;
          swap(nums, right, pivot);
          return nums[right];
    }
}
