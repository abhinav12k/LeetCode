package LeetCode.Arrays.Easy;

import java.util.Scanner;

public class shuffleTheArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int size = scn.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int n = scn.nextInt();

		int[] result = shuffle(arr, n);
		for (int i : result)
			System.out.println(i);
	}

	public static int[] shuffle(int[] nums, int n) {

		int prev = 0;
		int after = n;

		int[] answer = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0)
				answer[i] = nums[prev++];
			else
				answer[i] = nums[after++];
		}
		return answer;
	}

}
