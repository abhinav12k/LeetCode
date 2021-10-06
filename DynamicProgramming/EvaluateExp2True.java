package DynamicProgramming;

import java.util.HashMap;

public class EvaluateExp2True {
    public static void main(String[] args) {
        String exp = "T|F&T^F";
        System.out.println(evaluateExpToTrue(exp,0,exp.length()-1,true));
    }


    static HashMap<String,Integer> map = new HashMap<>();
    private static int evaluateExpToTrue(String str, int i, int j, boolean isTrue) {

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue)
                if(str.charAt(i) == 'T')
                    return 1;
                else
                    return 0;
            else
                if(str.charAt(i) == 'F')
                    return 1;
                else
                    return 0;
        }

        String key = i + " "+ j + " " + isTrue;
        if(map.containsKey(key))
            return map.get(key);
        int ans = 0;
        for (int k = i+1; k <= j - 1; k += 2) {
            int lT = evaluateExpToTrue(str, i, k-1, true);
            int lF = evaluateExpToTrue(str, i, k-1, false);
            int rT = evaluateExpToTrue(str,k+1,j,true);
            int rF = evaluateExpToTrue(str,k+1,j,false);

            if(str.charAt(k)=='&'){
                if(isTrue){
                    ans += lT*rT;
                }else{
                    ans += lT*rF + lF*rT + lF*rF;
                }
            }else if(str.charAt(k) == '|'){
                if(isTrue){
                    ans += lT*rT + lF*rT + lT*rF;
                }else{
                    ans += lF*rF;
                }
            }else if(str.charAt(k) == '^'){
                if(isTrue){
                    ans += lT*rF + lT*rF;
                }else{
                    ans += lF*rF + lT*rT;
                }
            }
        }
        map.put(key,ans);
        return ans;
    }
}
