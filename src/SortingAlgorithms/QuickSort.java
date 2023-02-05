package SortingAlgorithms;

public class QuickSort extends AbstractQuickSort{
    @Override
    public int getPivot(int[] nums, int left, int right) {
        return nums[right];
    }
}
