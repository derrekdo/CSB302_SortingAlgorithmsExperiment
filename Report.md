# Algorithm Implementation

## Insertion Sort - Michael

This is my personal favorite sort. Last quarter I did the seperate array version of the algorithm but adapted for a linked list. This time around I picked an approach I didn't come across when I initially looking into the algorithm. In the version of insertion sort I'm most familiar with we have a 2nd array that matches the length of our original unsorted array. Then we go element by element through the unsorted array and put the current element into the 2nd array. The current element begins at the 'end' of the sorted data and the inner loop of the algorithm 'pulls' it closer to the front if it's smaller than everything else. In the version of the algorithm I picked for this assignment we don't use a 2nd array. Instead we use the same array as the unsorted data and the inner loop behaves the same. The current element is checked against everything that comes before it in the array and is swapped/pulled based on it's value.

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
 After the inner loop has finished if the boolean value is checked and if it was not changed then the algorithm ends early. I chose not to use this optimization because I wanted to show off the difference the O(n^2) algorithm makes over the much faster ones, even if the optimization is minimal.

## Selection Sort - Michael

At first I had trouble distinquishing this algorithm from bubble sort. It looks nearly the same at first glance but the key difference is that in the inner loop we update a 'smallest' integer with the index of the smallest value we find in the array. The swap between the smallest and the value at the outer loop's position occurs after the entire inner loop has finished and not with every iteration like the bubble sort algorithm. Even though both of these algorithms are O(n^2) selection sort is consistently faster than bubble sort.

## Merge Sort - Derrek

Since I had experience working with this algorithm due to assignments last quarter, I was able to build it without researching the algorthm. Additionally there were other implementations similar to mine but because of how it written I didnt like it as much because its hard to follow due to the fact merge sort relies on the use of recursion to split the array; even with these difference the runtime still ends up being similar to what is expected.  

## Heap Sort - Derrek

Heap sort was the one algorithm I was able to understand how it works but not how to implement properly because of the idea of visualizing it as a tree to sort it confused me. After doing much research on this algortihm, there were a few videos that explained how to treat the array as tree using an equation to find the "parent" and "child" of said array. The implementations I chose to help build the sorting algorithm, was based on their implementation of using a max heap rather than min heap; I liked sorting the larger numbers first and moving down to the lower numbers. Moving on, the execution of the algorithm generates results that meet our expectations. 

## Shell Sort - Derrek

Shell sort was another intersting algorithm, as it is basically insertion sort but compares values based on an interval that continues to decrease. I saw various implementations for this algorithm, mainly in their increment sequences, such as knuth's sequence which is theoretically faster than using shells sequences which I used. I didn't use a faster increment sequence because this was the first time I had used tried making shell sort, and I felt that doing so wouldn't be as meaningful in the scope of this project.


- Quick Sort (pivot selected as first element)
- Quick Sort (pivot selected as random element)
- Quick Sort (pivot selected with Median-of-three)
- Counting Sort
- Bucket Sort
- Radix Sort
