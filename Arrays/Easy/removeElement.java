package LeetCode.Arrays.Easy;

import java.util.Scanner;

public class removeElement {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		
		int[] arr = new int[size];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = scn.nextInt();
		}
		
		int target = scn.nextInt();
		
		System.out.println(removeSpecificElement(arr,target));
	}

	private static int removeSpecificElement(int[] arr, int target) {
		
		int idx = 0;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]!=target) {
				arr[idx]=arr[i];
				idx++;
			}
			
		}
		return idx;
	}
	
}
