package Strings;

public class stringstr {

    public static void main(String[] args) {
        String str = "ababcabcabababd";
        String pat = "ababd";
        System.out.println(naiveApproach(str,pat));
        System.out.println(new KMP().getIndex(str,pat));
    }

    private static int naiveApproach(String str,String pat){

        if(str.isEmpty() || pat.isEmpty())
            return -1;

        if(str.length() < pat.length())
            return -1;

        int m = str.length();
        int n = pat.length();
        for(int i=0;i<=m-n;i++){
            boolean fl = true;
            for(int j=0;j<n;j++){
                if(str.charAt(i+j)!=pat.charAt(j)){
                    fl = false;
                    break;
                }
            }
            if(fl){
                return i;
            }
        }
        return -1;
    }

}
