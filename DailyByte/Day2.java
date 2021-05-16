package DailyByte;

public class Day2 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama.";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str){

        int l = 0;
        int r = str.length()-1;

        while(l<=r){

            char c1 = str.charAt(l);
            char c2 = str.charAt(r);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)){
//               System.out.println(c1 + " "+ c2);
               if(Character.toLowerCase(c1)!=Character.toLowerCase(c2))
                   return false;
               l++;
               r--;
            }else if(!Character.isAlphabetic(c1))
                l++;
            else if(!Character.isAlphabetic(c2))
                r--;
            else {
                l++;
                r--;
            }
        }
        return true;
    }

}
