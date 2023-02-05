package SortingAlgorithms;

public class QuickSort extends AbstractQuickSort{
    @Override
    public int getPivot(int[] nums, int left, int right) {
        swap(nums, left, right);
        return nums[right];
    }
}
