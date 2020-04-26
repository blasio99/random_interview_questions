package src;

import resources.MergeSort;

public class SumUpToS {
	/*
	 * 1. Given an array of N distinct natural numbers, how many pairs of numbers
	 * sum up to a given number S?
	 */

	/*
	 * version A -- (assume input is correct) using a search, each time look for the
	 * complement(S - value) of the value working with in the remaining part of the
	 * array; using a sorting algorithm might be useful because searching could be
	 * implemented with binary search, and also the search can be only made on the
	 * remaining elements of the array(when finding one it will always guarantee
	 * that the next possible matching element won't be bigger, so it can be made
	 * until that point, decreasing the sub-array in which the search is done)
	 * 
	 * Using a merge sort : O(nlogn) and using one loop to check the elements of the
	 * array, searching with binary search on remaining elements : O(logn) In
	 * conclusion : complexity O(nlogn), memory O(n) - merge sort
	 */
	public static int binarySearch(int arr[], int first, int last, int key) {
		if (last >= first) {
			int mid = first + (last - first) / 2;
			// value equals middle : found
			if (arr[mid] == key) {
				return mid;
			}
			// value smaller : search in left sub array
			if (arr[mid] > key) {
				return binarySearch(arr, first, mid - 1, key);
			}
			// value bigger : search in right sub array
			else {
				return binarySearch(arr, mid + 1, last, key);
			}
		}
		return -1;
	}

	static int noOfPairsSumSA(int arr[], int S) {
		// sort the array ascending
		MergeSort.mergeSort(arr);

		// walk until middle and check if the complement exists, number of pairs, and
		// enough to check from the middle until the last - noOfPairs
		int noOfPairs = 0;
		int i;
		for (i = 0; i < arr.length; i++) {
			// could've used only Array.binarySearch()
			if (binarySearch(arr, i + 1, (arr.length - 1 - noOfPairs), (S - arr[i])) != -1) {
				noOfPairs++;
			}
		}
		return noOfPairs;
	}

	/*
	 * version B -- (assume input is correct) searching without ordering the
	 * elements : using one loop to walk on the array until the last one(the last
	 * cannot have pair after him), each case search for a solution : using a linear
	 * search, array not necessarily ordered;
	 * 
	 * Complexity : O(n^2) - more precisely sum(1 : n)
	 */
	static int searchPair(int arr[], int l, int h, int x) {
		int i;
		for (i = l + 1; i < h; i++) {
			if (arr[i] == x)
				return (1);
		}
		return (0);
	}

	static int noOfPairsSumB(int arr[], int S) {
		int noOfPairs = 0;
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			if (searchPair(arr, i, arr.length, (S - arr[i])) != 0)
				noOfPairs++;
		}
		return noOfPairs;
	}

	public static void main(String[] args) {
		/// n = 3
		// 0 pairs with sum 7
		// int arr[] = {1, 2, 3};
		/// n = 4
		// 1 pair with sum 7
		// int arr[] = {1, 2, 3, 6};
		/// n = 6
		// 3 pairs with sum 7
		int arr[] = { 1, 4, 3, 5, 2, 6 };
		int S = 7;
		System.out.println("Number of pairs summing up to " + S + " are(solution A) : " + noOfPairsSumSA(arr, S));
		System.out.println("Number of pairs summing up to " + S + " are(solution B) : " + noOfPairsSumSA(arr, S));
	}
}