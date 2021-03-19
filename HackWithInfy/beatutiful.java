package HackWithInfy;

import java.util.*;

class Solution {
    public static int beautifulFunction(int N,int q,int count){
        if(q==N && count > 0){
            return count;
        }
        N=N+1;
        String str = String.valueOf(N);
        int len = str.length();
        int ans=0;
        for(int i=len-1;i>=0;i--){

            if(str.charAt(i) == '0'){
                str = str.substring(0,i);
            }else{
                count++;
                ans = beautifulFunction(Integer.parseInt(str),q,count);
                break;
            }

        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N;
        N=scan.nextInt();
        int result;
        result = beautifulFunction(N,N,0);
        System.out.print(result);
        return ;
    }
}