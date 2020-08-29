package LeetCode.Arrays.Easy;

import java.util.Scanner;

public class removeDuplicatesFromSortedArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int size = scn.nextInt();

		int[] arr = new int[size];

		// input sorted Array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(removeDuplicates(arr));

	}

	private static int removeDuplicates(int[] arr) {

		if(arr.length==0||arr.length==1) {
			return arr.length;
		}
		
		int count = 1;
		int j = 0;
		
		for(int i=1;i<arr.length && j<arr.length-1 ;i++) {
			
			int prev = arr[j];
			int curr = arr[i];
			
			if(prev!=curr) {
				count++;
				j++;
				arr[j]=curr;
			}
				
		}
		return count;
	}

}
