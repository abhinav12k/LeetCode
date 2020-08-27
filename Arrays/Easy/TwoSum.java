package LeetCode.Arrays.Easy;

import java.util.HashMap;
import java.util.Scanner;

//Question Link - https://leetcode.com/problems/two-sum/

public class TwoSum {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
		
		int target = scn.nextInt();
		
		int[] indexes = 
		getIndexesUsingMap(arr, target);
		for(int i:indexes) {
			System.out.println(i);
		}
		
		
	}

	//Approach 1 - using two loops
	//Time Complexity - O(n^2)
	//Space Complexity - O(1)
	
	//Approach 2 -using hashmap
	//Time Complexity - O(n)
	//Space Complexity - O(n)
	private static int[] getIndexesUsingMap(int[] arr,int target) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++) {
			int x = arr[i];
			
			int y = target-x;
			
			if(map.containsKey(y)) {
				return new int[] {map.get(y),i};
			}else {
				map.put(x, i);
			}
			
		}
		return new int[0];
	}
	
	
	//Approach 3 - using two pointer approach / Caution - using this method indexes also gets changed of the array
	//Time Complexity - O(nlogn)
	//Space Complexity - O(1)
	
	private static int[] getIndexes(int[] arr, int target) {
		
		quickSort(arr,0,arr.length-1);
		
		int left = 0;
		int right = arr.length-1; 
		
		while(left<right) {
			int calculatedSum = arr[left]+arr[right];
			if(calculatedSum<target) {
				left++;
			}else if(calculatedSum>target) {
				right--;
			}else
				return new int[] {left,right};
		}
		return new int[] {};
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		
		if(lo>=hi) {
			return;
		}
		
		int left = lo;
		int right = hi;
		
		int pivot = arr[(lo+hi)/2];
		
		while(left<=right) {
			
			while(arr[left]<pivot) {
				left++;
			}
			
			while(arr[right]>pivot) {
				right--;
			}
			
			if(left<=right) {
				//swap
				int temp = arr[left];
				arr[left]= arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		quickSort(arr, left, hi);
		quickSort(arr, lo, right);
		
	}
	
}
