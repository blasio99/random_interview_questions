package src;

import java.util.HashMap;
import java.util.Map;

public class AppearsNHalfTimes {
	/*
	 * 2. Given an array of N natural numbers, find the number that appears more
	 * than N/2 times.
	 */

	/*
	 * using a hash table to store the appearances ie. mapping by the value and
	 * storing, if new value 1, as first appearance or incrementing the already
	 * existing one; at the end just iterate through the hash map and look for the
	 * criteria; logically only one value can appear more times than half of the
	 * array's length -> can use a return statement if this element is found and
	 * leave the function;
	 * 
	 * Complexity : O(n), since get and put are O(1) in the hash map; O(n) memory
	 * needed for the hash map
	 */
	static int getAppearances(int arr[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i;
		for (i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				int app = map.get(arr[i]);
				map.put(arr[i], app + 1);
			}
		}
		for (Map.Entry<Integer, Integer> ind : map.entrySet()) {
			if (ind.getValue() > arr.length / 2)
				return (ind.getKey());
		}
		return (-1);
	}

	public static void main(String[] args) {
		// none appearing
		// int arr[] = {1, 2, 3, 4, 5};
		// one appearing
		int arr[] = { 1, 1, 1, 3, 4 };
		System.out.print("Array of length " + arr.length + ", element(s): "
				+ (getAppearances(arr) > 0 ? getAppearances(arr) : "") + " appearing more than " + arr.length / 2
				+ " times!");
	}
}