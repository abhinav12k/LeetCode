package Mock;

import java.util.Scanner;

public class unluckyNumber {

    /**
     * Tushar is very superstitious. So naturally he hates the number 13.
     * Not just that, he even hates numbers that consist of only 1s and/or 3s.
     * He calls them 'Unlucky Numbers'
     * One day (Friday the 13th) he sat down and wondered what the N-th unlucky number would be.
     * Help him figure it out!
     *
     * Sample input
     *
     * 5
     *
     * Sample output
     *
     * 31
     * */


    public static void main(String[] args) {

        /**TLE Solution*/
        Scanner scn = new Scanner(System.in);
        int target = scn.nextInt();
        int count=0;
        int start=1;
        while(count<target){
            int temp = start;

            while(temp!=0){
                int rem = temp%10;
                if(rem!=1 && rem!=3){
                    break;
                }
                temp/=10;
            }
            if(temp==0)
                count++;

            start++;
        }
        if(count==target) {
            System.out.println(start-1);
        }
    }
}
