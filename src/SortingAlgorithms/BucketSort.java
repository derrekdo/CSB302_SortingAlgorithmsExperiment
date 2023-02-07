package SortingAlgorithms;

import java.util.ArrayList;


/**
	BucketSort class

	@author	Joel Perry
	@since	2023/02/04
	@version	2023/02/04
*/
public class BucketSort implements ArraySortingInterface {
	int BIN_COUNT = 10;

	/**
		Distributes all the values into separate bins based on the range of the value,
		sorts each bin separately, and then combines the bins back together again into
		the original array.  Uses RadixSort to sort each bin.

		@param	array	Array of integers to be sorted
	*/
	public void sortArray(int[] array) {
		ArrayList<Integer>[] bins = new ArrayList[BIN_COUNT];

		// set up the bins to distribute the integers into
		// O(N)
		for (int index = 0; index < BIN_COUNT; index++) {
			bins[index] = new ArrayList<Integer>();
		}


		// initialize maximum value in array
		int max = array[0];

		// find maximum value in array
		// O(N)
		for (int index = 1; index < array.length; index++) {
			max = Math.max(array[index], max);
		}

		// bump maximum value in array
		max++;


		// distribute integers into bins
		// O(N)
		for (int index = 0; index < array.length; index++) {
			int bin = array[index] * BIN_COUNT / max;
			bins[bin].add(array[index]);
		}


		// initialize original array index
		int idx = 0;

		// copy each bin into array, sort each array,
		// then copy array into original array
		// O(N^2)
		for (int bin = 0; bin < bins.length; bin++) {
			// set up sorted array
			int[] sorted = new int[bins[bin].size()];

			// copy bin into sorted array
			for (int index = 0; index < bins[bin].size(); index++) {
				sorted[index] = bins[bin].get(index);
			}

			// set up array sorter
			RadixSort sorter = new RadixSort();

			// sort array
			sorter.sortArray(sorted);

			// copy sorted array into original array
			for (int index = 0; index < sorted.length; index++) {
				array[idx + index] = sorted[index];
			}

			// increase original array index
			idx += sorted.length;
		}
	}


	public String getAlgorithmName() {
		return "Bucket Sort";
	}
}
