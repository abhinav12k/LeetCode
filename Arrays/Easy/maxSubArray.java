package LeetCode.Arrays.Easy;

import java.util.Scanner;

public class maxSubArray {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
		
		System.out.println(getMaxSum(arr));
	}

	private static int getMaxSum(int[] arr) {
		
		int prev=arr[0];
		int res = arr[0];

		for(int i=1;i<arr.length;i++) {
			
			if(prev>0)
				prev+=arr[i];
			else
				prev = arr[i];
			
			if(prev>res)
				res= prev;
			
		}
		return res;
	}
	
}
