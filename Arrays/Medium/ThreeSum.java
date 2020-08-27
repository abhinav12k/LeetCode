package LeetCode.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * Sets are better to use when we have to make sure that there are no duplicates
 */


public class ThreeSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int size = scn.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

//		int target = scn.nextInt();

		quickSort(arr, 0, arr.length - 1);

		List<List<Integer>> triplets = getTriplets(arr, 0);

		for (List<Integer> list : triplets) {
			System.out.println(list);
		}

	}

	private static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int left = lo;
		int right = hi;

		int pivot = arr[(left + right) / 2];

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				// swap
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;

				left++;
				right--;
			}

		}

		quickSort(arr, left, hi);
		quickSort(arr, lo, right);

	}

	public static List<List<Integer>> getTriplets(int[] arr, int target) {

		if (arr.length < 3) 
			return new ArrayList<>();
		
//		List<List<Integer>> answers = new ArrayList<List<Integer>>();

		Set<List<Integer>> answers = new HashSet<List<Integer>>();
		
		for (int i = 0; i < arr.length - 2; i++) {

			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {

				int cs = arr[i] + arr[left] + arr[right];

				if (cs == target) {
//					List<Integer> triplet = new ArrayList<Integer>();
//					triplet.add(arr[i]);
//					triplet.add(arr[left]);
//					triplet.add(arr[right]);
//					if (!answers.contains(triplet))
//						answers.add(triplet);
					
					answers.add(Arrays.asList(arr[i],arr[left],arr[right]));
					left++;
					right--;
				} else if (cs > target) {
					right--;
				} else {
					left++;
				}

			}

		}
		return new ArrayList<List<Integer>>(answers);
	}

}
