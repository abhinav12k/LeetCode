package TwoPointer;

public class validPalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
    static class Solution {
        public boolean isPalindrome(String s) {

            int left = 0;
            int right = s.length() - 1;
            boolean flag = true;
            while (left<right){

                if(!isAlphaNumeric(String.valueOf(s.charAt(left)))) {
                    left++;
                    continue;
                }
                if(!isAlphaNumeric(String.valueOf(s.charAt(right)))) {
                    right--;
                    continue;
                }

                if(isAlphaNumeric(String.valueOf(s.charAt(left))) && isAlphaNumeric(String.valueOf(s.charAt(right)))){
                    if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                        flag = false;
                        break;
                    }
                    left++;
                    right--;
                }
            }
            return flag;
        }

        public static boolean isAlphaNumeric(String s) {
            return s != null && s.matches("^[a-zA-Z0-9]*$");
        }
    }
}
