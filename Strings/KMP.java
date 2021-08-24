package Strings;

public class KMP {

    public int getIndex(String str,String pat){

        if(str.isEmpty() || pat.isEmpty())
            return -1;

        int n = str.length();
        int m = pat.length();

        if(m>n)
            return -1;

        int[] lps = generateLPS(pat);

//        for(int l: lps)
//            System.out.println(l);

        int j=0;
        int i=0;
        while(i<str.length() && j<pat.length()){
            if(str.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }else {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
//        System.out.println(pat.length()+" "+j+" : "+i);
        return j==pat.length() ? i-j : -1;
    }

    private int[] generateLPS(String pattern){
        int[] arr = new int[pattern.length()];

        int left = 0;
        for(int i=pattern.length()-1;i>=0;i--){
            int idx=i;
            while(left < idx && pattern.charAt(idx) == pattern.charAt(left)){
                arr[idx] = left+1;
                left++;
                idx++;
            }
            left=0;
        }
        return arr;
    }
}
