package LeetCode.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsExtraCandies {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int size =  scn.nextInt();
		
		int[] candies = new int[size];
		
		for(int i=0;i<candies.length;i++) {
			candies[i] = scn.nextInt();
		}
		
		int extraCandies = scn.nextInt();
		
		List<Boolean> result = kidsWithCandies(candies,extraCandies);
		
		System.out.println(result);
		
	}
	
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		
    	List<Boolean> answer = new ArrayList<Boolean>();
    	
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<candies.length;i++) {
    		
    		if(max<candies[i])
    			max=candies[i];
    		
    	}
    	
    	for(int i=0;i<candies.length;i++) {
    		
    		int sum=candies[i]+extraCandies;
    		if(sum>=max) {
    			answer.add(true);
    		}else
    			answer.add(false);
    		
    	}
    	
    	return answer;
        
    }
	
}
