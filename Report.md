# Algorithm Implementation

## Insertion Sort - Michael

This is my personal favorite sort. Last quarter I did the seperate array version of the algorithm but adapted for a linked list. This time around I picked an approach I didn't come across when I initially looking into the algorithm. In the version of insertion sort I'm most familiar with we have a 2nd array that matches the length of our original unsorted array. Then we go element by element through the unsorted array and put the current element into the 2nd array. The current element begins at the 'end' of the sorted data and the inner loop of the algorithm 'pulls' it closer to the front if it's smaller than everything else. In the version of the algorithm I picked for this assignment we don't use a 2nd array. Instead we use the same array as the unsorted data and the inner loop behaves the same. The current element is checked against everything that comes before it in the array and is swapped/pulled based on it's value. Of the O(n^2) sorting methods this seems to be the fastest according to tests. I think this is because, unlike the others, we don't iterate over as much of the sorted array. Once we begin pulling a number to the front of the array we stop the inner loop once we detect the next element in the array is smaller than the value we are seeking a position for. As we get further in the out loop the the inner loop does less work.

## Bubble Sort - Michael

This is the one sorting algorithm I'm familiar enough with to do without looking it up. I did look around online to see if I could find more interesting versions of it though. Aside from stackoverflow arguements about the difference between selection sort and bubble sort I couldn't find anything very meaningful. I found an optimization that stores a boolean value outside the inner loop and sets it to true inside if a swap needed to take place(see below).
```
for(int i = 0; i < array.length; i++)
    {
      boolean foundLarger = false;

       for(int j = 0; j < array.length - i - 1; j++)
       {
          if(array[j] > array[j + 1])
          {
            foundLarger = true;
             int temp = array[j + 1];
             array[j + 1] = array[j];
             array[j] = temp;
          }
       }
      if(!foundLarger){ // if we didn't need to swap then we are done sorting
         return;
      }
}
```
 After the inner loop has finished if the boolean value is checked and if it was not changed then the algorithm ends early. I chose not to use this optimization because I wanted to show off the difference the O(n^2) algorithm makes over the much faster ones, even if the optimization is minimal. As expected, this O(n^2) algorithm consistently goes slower than the others. Probably because it goes through every single element twice and performs the swap operations every time we detect a value in the inner loop is different than the next position in the array.

## Selection Sort - Michael

At first I had trouble distinquishing this algorithm from bubble sort. It looks nearly the same at first glance but the key difference is that in the inner loop we update a 'smallest' integer with the index of the smallest value we find in the array. The swap between the smallest and the value at the outer loop's position occurs after the entire inner loop has finished and not with every iteration like the bubble sort algorithm. Even though both of these algorithms are O(n^2) selection sort is consistently faster than bubble sort.

## Merge Sort - Derrek

Since I had experience working with this algorithm due to assignments last quarter, I was able to build it without researching the algorthm. Additionally there were other implementations similar to mine but because of how it written I didnt like it as much because its hard to follow due to the fact merge sort relies on the use of recursion to split the array; even with these difference the runtime still ends up being similar to what is expected.  

## Heap Sort - Derrek

Heap sort was the one algorithm I was able to understand how it works but not how to implement properly because of the idea of visualizing it as a tree to sort it confused me. After doing much research on this algortihm, there were a few videos that explained how to treat the array as tree using an equation to find the "parent" and "child" of said array. The implementations I chose to help build the sorting algorithm, was based on their implementation of using a max heap rather than min heap; I liked sorting the larger numbers first and moving down to the lower numbers. Moving on, the execution of the algorithm generates results that meet our expectations. 

## Shell Sort - Derrek

Shell sort was another intersting algorithm, as it is basically insertion sort but compares values based on an interval that continues to decrease. I saw various implementations for this algorithm, mainly in their increment sequences, such as knuth's sequence which is theoretically faster than using shells sequences which I used. I didn't use a faster increment sequence because this was the first time I had used tried making shell sort, and I felt that doing so wouldn't be as meaningful in the scope of this project.

## Quick Sort - Rob

Quicksort was having a problem with largest int value is 40000, which results in StackOverFlow exception if the array being sorted is large and sorted.  This makes sense because if the pivot is last elements (largest or smallest), then resulting partitions would be "pathological".  Recursion depth becomes really large. 

Implementation-  I realize all three quick sorts are similar, so I should take advantage of either interface or abstract classes which I did there. I also learned that there are two schemes as to implement the partition algorithms.  I chose to use Lumato because it looks nice and pivot index is always at the end or the beginning.

Runtime- The runtime for quicksort is O(n^2).  If the pivot is picked well, then this behavior is not observed.  In the case where the array is sorted or half sorted, pivot at the end can cause a lot of problem.  If the pivot is picked to be a median or random, then performance is a lot better.

## Quick Sort - Rob

Quicksort was having a problem with largest int value is 40000, which results in StackOverFlow exception if the array being sorted is large and sorted.  This makes sense because if the pivot is last elements (largest or smallest), then resulting partitions would be "pathological".  Recursion depth becomes really large. 

Implementation-  I realize all three quick sorts are similar, so I should take advantage of either interface or abstract classes which I did there. I also learned that there are two schemes as to implement the partition algorithms.  I chose to use Lomuto because it does not have "while(true)" structure and pivot index is always at the end or the beginning. 

Runtime- The runtime for quicksort is O(n^2).  If the pivot is picked well, then this behavior is not observed.  In the case where the array is sorted or half sorted, pivot at the end can cause a lot of problem.  If the pivot is picked to be a median or random, then performance is a lot better.

The following pertains to the other two quicksort as well.  Quicksort when array size is small performs okay but it performs betters as array gets bigger relative to the array size; I think it is because recursion probably sets up a lot of computing overhead so a basic simple sort like selection sort or insert sort should be chosen instead.
In addition, using quicksort on almost sorted or sorted array sets does not perform well and it makes sense. In that case, quicksort should revert to insertion sort.  I believe some programming languages uses that implementation.


## Quick Sort (Median of medians)

This quicksort should solve the problem of having a bad pivot. This is used frequently in place of using the last index as the pivot.  The implement is as follow: pick 3 numbers (number at first index, middle index, and last index).  Sort the numbers and place the middle number as the pivot.

This should almost promise not having the worst pivot.  The performance definitly shows that it is better the basic quicksort.

## Quick Sort (Randomized pivot)

I think this one performs just as well as quicksort using median of medians).  There are many ways to implement this approach.  One interesting way is to shuffle the array partition entirely.  This should certainly avoid the problem of bad pivot, but it would introduce the additional runtime on shuffling the array.  The approach I pick is pick a random pivot and swab it with the value at the last index.  This is relatively simpler to implement and works well with existing structure.





