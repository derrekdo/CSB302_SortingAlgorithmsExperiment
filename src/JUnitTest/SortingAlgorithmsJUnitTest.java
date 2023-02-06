package JUnitTest;

import SortingAlgorithms.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingAlgorithmsJUnitTest {

    int[] sorted   = {0,0,1,3,4,9,15,23,45,52,64,69,80,81,100,354};
    int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

    @Test
    void testBubbleSort(){
        BubbleSort sort = new BubbleSort();

        System.out.println("--------------- BUBBLE SORT TEST ---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testHeapSort(){
        HeapSort sort = new HeapSort();

        System.out.println("--------------- HEAP SORT TEST ---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testInsertionSort(){
        InsertionSort sort = new InsertionSort();

        System.out.println("--------------- INSERTION SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testMergeSort(){
        MergeSort sort = new MergeSort();

        System.out.println("--------------- MERGE SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testSelectionSort(){
        SelectionSort sort = new SelectionSort();

        System.out.println("--------------- SELECTION SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testShellSort(){
        ShellSort sort = new ShellSort();

        System.out.println("--------------- SHELL SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testQuickSortFirstElement(){
        QuickSort sort = new QuickSort();

        System.out.println("--------------- QUICK SORT (FIRST ELEMENT) TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testQuickSortRandomElement(){
        QuickSort_Randomized sort = new QuickSort_Randomized();

        System.out.println("--------------- QUICK SORT (RANDOM ELEMENT) TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testQuickSortMedianThree(){
        QuickSort_Median_of_Three sort = new QuickSort_Median_of_Three();

        System.out.println("--------------- QUICK SORT (MEDIAN-OF-THREE) TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }
/*
    @Test
    void testCountingSort(){
        CountingSort sort = new CountingSort();

        System.out.println("--------------- COUNTING SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testBucketSort(){
        BucketSort sort = new BucketSort();

        System.out.println("--------------- BUCKET SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testRadixSort(){
        RadixSort sort = new RadixSort();

        System.out.println("--------------- RADIX SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }*/
}
