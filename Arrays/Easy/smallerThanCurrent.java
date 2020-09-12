package LeetCode.Arrays.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class smallerThanCurrent {

	class Solution {
		public int[] smallerNumbersThanCurrent(int[] nums) {

//	         int[] result = new int[nums.length];
//	         Arrays.fill(result,0);

//	         for(int start = 0;start<nums.length;start++){
//	             for(int i = 0;i<nums.length;i++){
//	                 if(start==i)
//	                     continue;
//	                 if(nums[i]<nums[start]){
//	                     result[start] +=1; 
//	                 }
//	             }
//	         }
//	         return result;

			int[] clone = nums.clone();
			Arrays.sort(clone);

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			map.put(clone[0], 0);

			for (int i = 0; i < clone.length - 1; i++) {
				if (clone[i + 1] > clone[i]) {
					map.put(clone[i + 1], i + 1);
				}
			}

			int[] res = new int[nums.length];

			for (int i = 0; i < nums.length; i++) {
				res[i] = map.get(nums[i]);
			}

			return res;

		}
	}

}
