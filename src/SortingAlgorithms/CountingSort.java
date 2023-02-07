package SortingAlgorithms;


/**
	CountingSort class

	@author	Joel Perry
	@since	2023/02/04
	@version	2023/02/04
*/
public class CountingSort implements ArraySortingInterface {

	/**
		Counts the occurences of each value, copies each value into a sorted array,
		and then copies the sorted array back into the original array.

		@param	array	Array of integers to be sorted
	*/
	public void sortArray(int[] array) {
		// initialize maximum value in array
		int max = array[0];

		// find maximum value in array
		// O(N)
		for (int index = 1; index < array.length; index++) {
			max = Math.max(array[index], max);
		}


		// set up counts using maximum value in array
		int[] counts = new int[max + 1];

		// accumulate counts of each value
		// O(N)
		for (int index = 0; index < array.length; index++) {
			counts[array[index]]++;
		}


		// calculate accumulation of counts of each value
		// O(N)
		for (int index = 1; index < counts.length; index++) {
			counts[index] = counts[index] + counts[index - 1];
		}


		// shift counts one place to the right
		// O(N)
		for (int index = counts.length - 1; index > 0; index--) {
			counts[index] = counts[index - 1];
		}


		// set up sorted counts array
		int[] sorted = new int[array.length];

		// copy values into sorted array according to counts array
		// O(N)
		for (int index = 0; index < array.length; index++) {
			sorted[counts[array[index]]] = array[index];
			counts[array[index]]++;
		}


		// copy values from sorted array to original array
		// O(N)
		for (int index = 0; index < array.length; index++) {
			array[index] = sorted[index];
		}
	}


	public String getAlgorithmName() {
		return "Counting Sort";
	}
}
