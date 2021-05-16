package DailyByte;

public class Day5 {

    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "101";
        System.out.println(calculateBinarySum(s1,s2));
    }

    private static String calculateBinarySum(String s1,String s2){

        StringBuilder sb = new StringBuilder();
        int a = s1.length()-1,b = s2.length()-1,carry=0;
        while(a>=0 || b>=0) {
            int sum = carry;
            if (a >= 0) {
                sum += s1.charAt(a) - '0';
                a--;
            }
            if(b >= 0){
                sum+=s2.charAt(b)-'0';
                b--;
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0)
            sb.append("1");
        return sb.reverse().toString();
    }

}
