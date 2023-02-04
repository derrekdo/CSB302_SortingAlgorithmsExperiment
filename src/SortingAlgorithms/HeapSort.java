package SortingAlgorithms;

public class HeapSort implements ArraySortingInterface{
    public void sortArray(int[] array) {
        int size = array.length;

        //builds the max heap
        for(int node = size/2; node >= 0; node--){
            heapify(array, node, size);
        }

        //sorts the array
        for(int i = size - 1; i > 0; i--){
            //holds the last element in heap
            int temp = array[i];
            //swaps the root with last elemnt in heap
            array[i] = array[0];
            array[0] = temp;

            //recreate max heap starting at root node
            //size input decreases because elements at the end of array are sorted
            heapify(array, 0, i);
        }
    }



    public void heapify(int[] array, int node, int size){
        int largest = node;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 1;

        //detemines which child node is larger based on the current root node
        if(leftChild < size && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        if(rightChild < size && array[rightChild] > array[largest]){
            largest = rightChild;
        }

        //checks if the root node has the larger element
        //if not bubbles the larger elements to top of heap and smaller elements to the bottom via recursion
        if(largest != node){
            //holds the roots element
            int temp = array[node];
            //swaps the root with larger child
            array[node] = array[largest];
            array[largest] = temp;
            //continue heapify
            heapify(array, largest, size);
        }
    }

    public String algorithmName() {
        return "Heap Sort";
    }
}
