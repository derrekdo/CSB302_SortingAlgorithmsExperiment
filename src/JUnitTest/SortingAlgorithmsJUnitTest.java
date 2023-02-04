package JUnitTest;

import SortingAlgorithms.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingAlgorithmsJUnitTest {

    int[] sorted   = {0,0,1,3,4,9,15,23,45,52,64,69,80,81,100,354};

    @Test
    void testBubbleSort(){
        BubbleSort sort = new BubbleSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- BUBBLE SORT TEST ---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testHeapSort(){
        HeapSort sort = new HeapSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- HEAP SORT TEST ---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testInsertionSort(){
        InsertionSort sort = new InsertionSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- INSERTION SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testMergeSort(){
        MergeSort sort = new MergeSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- MERGE SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testSelectionSort(){
        SelectionSort sort = new SelectionSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- SELECTION SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testShellSort(){
        ShellSort sort = new ShellSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- SHELL SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

/*    @Test
    void testQuickSortFirstElement(){
        QuickSortFirstElement sort = new QuickSortFirstElement();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- QUICK SORT (FIRST ELEMENT) TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testQuickSortRandomElement(){
        QuickSortRandomElement sort = new QuickSortRandomElement();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- QUICK SORT (RANDOM ELEMENT) TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testQuickSortMedianThree(){
        QuickSortMedianThree sort = new QuickSortMedianThree();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- QUICK SORT (MEDIAN-OF-THREE) TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testCountingSort(){
        CountingSort sort = new CountingSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- COUNTING SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testBucketSort(){
        BucketSort sort = new BucketSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- BUCKET SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }

    @Test
    void testRadixSort(){
        RadixSort sort = new RadixSort();
        int[] unsorted = {80,15,23,0,69,52,45,354,81,64,4,1,100,9,0,3};

        System.out.println("--------------- RADIX SORT TEST---------------");
        System.out.println("Array Before:\n" + Arrays.toString(unsorted));
        sort.sortArray(unsorted);
        System.out.println("Array After:\n" + Arrays.toString(unsorted));

        assertEquals(Arrays.toString(sorted),Arrays.toString(unsorted));
    }*/
}
