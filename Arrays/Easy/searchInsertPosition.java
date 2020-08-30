package LeetCode.Arrays.Easy;

import java.util.Scanner;

public class searchInsertPosition {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
		
		int target = scn.nextInt();
		
		System.out.println(getPosition(arr,target));
		
	}

	private static int getPosition(int[] arr, int target) {
		
		int lo=0;
		int hi = arr.length-1;
		
		while(lo<hi) {
			
			int mid = (lo+hi)/2;

			if(arr[mid]==target) {
				return mid;
			}else if(arr[mid]<target) {
				lo=mid+1;
			}else
				hi=mid-1;
			
		}
		
		if(arr[lo]<target)
			return lo+1;
		return lo;
	}
	
}
