package SortingAlgorithms;

import java.util.ArrayList;


/**
	Radix sort

	@author	Joel Perry
	@since	2023/02/04
	@version	2023/02/04
*/
public class RadixSort implements ArraySortingInterface {

	/**
		Distributes all the values into separate bins based on the digit at
		a given position within the number, and continues this procedure for each
		digit in the numbers for all the places in the largest number, accumulating
		the distributed numbers back into the original array until the array is sorted.

		@param	array	Array of integers to be sorted
	*/
	public void sortArray(int[] array) {
		ArrayList<Integer>[] bins = new ArrayList[10];

		// set up the bins to distribute the integers into
		for (int index = 0; index < bins.length; index++) {
			bins[index] = new ArrayList<Integer>();
		}

		// initialize power of first decimal place
		int power = 0;
		// declare flag indicating completion
		boolean done;

		do {
			// calculate decimal place
			int place = (int)Math.pow(10.0, power);
			// initialize flag indicating completion
			done = true;

			// distribute integers into bins
			for (int index = 0; index < array.length; index++) {
				// calculate decimal place digit
				int digit = (array[index] / place) % 10;
				// check for completion
				done = done && digit < 1;
				// distribute integer into bin
				bins[digit].add(array[index]);
			}

			if (!done) {
				// increase size of first bin to accomodate all integers in array
				bins[0].ensureCapacity(array.length - bins[0].size());

				// accumulate other bins into first bin
				for (int digit = 1; digit < bins.length; digit++) {
					// add other bin to first bin
					bins[0].addAll(bins[digit]);
					// clear other bin
					bins[digit].clear();
				}

				// copy first bin into original array
				for (int index = 0; index < array.length; index++) {
					array[index] = bins[0].get(index);
				}

				// clear first bin
				bins[0].clear();
				// bump power to next decimal place
				power++;
			}
		} while (!done);

		// copy first bin into original array
		for (int index = 0; index < array.length; index++) {
			array[index] = bins[0].get(index);
		}
	}


	public String getAlgorithmName() {
		return "Radix Sort";
	}
}
