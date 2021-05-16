package DailyByte;

public class Day4 {

    public static void main(String[] args) {

        String str = "Kelvin";
        System.out.println(isValidCapitalisation(str));
    }

    private static boolean isValidCapitalisation(String str){
        int uppercase_count = 0;
        int lowercase_count = 0;
        boolean isFirstUppercase = false;
        int ct = 1;
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c) && ct==1) {
                isFirstUppercase = true;
            }
            ct++;
            if(Character.isUpperCase(c)){
                uppercase_count++;
            }else
                lowercase_count++;
        }
        return uppercase_count == str.length() || lowercase_count == str.length() || (isFirstUppercase && lowercase_count == str.length()-1);
    }
}
