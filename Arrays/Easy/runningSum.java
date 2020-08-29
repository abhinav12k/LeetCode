package LeetCode.Arrays.Easy;

import java.util.Scanner;

public class runningSum {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int size = scn.nextInt();
		
		int[] arr = new int[size];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
		
		int[] result = getRunningSum(arr);
		
		for(int i : result) {
			System.out.println(i);
		}
		
	}

	private static int[] getRunningSum(int[] arr) {
		
		int sum = arr[0];
		for(int i=1;i<arr.length;i++) {
			arr[i] += sum;
			sum = arr[i];
		}
		return arr;
	}
	
}
