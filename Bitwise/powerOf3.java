package Bitwise;

public class powerOf3 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkPowersOfThree(12));
    }

    static class Solution {
        public boolean checkPowersOfThree(int n) {
            long lmt = (long)Math.pow(2,15);;
            for (long i = lmt; i >= 0; i--) {
                String str = getBinary( i);
                long ans = 0;
                for(int j = 0 ;j<str.length();j++){
                    if(str.charAt(j) == '1'){
                        ans += Math.pow(3,j-str.length()+1);
                    }
                }
                System.out.println(i + "\t" + str +"\t"+ans);

                if(ans==n)
                    return true;

            }
            return false;
        }
    }

    static String getBinary(long n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            if ((n & 1) == 1)
                ans.insert(0, "1");
            else
                ans.insert(0, "0");
            n >>= 1;
        }
        return ans.toString();
    }
}
