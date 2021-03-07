public class ninjaChess {

    public static void main(String[] args) {

        ninjaChess2021("d4","e5");
    }

    static int[] ninjaChess2021(String king, String ninja) {
        int[] ans  = new int[4];
        isCheckMate(0,0,king,ninja);
        // for(int i=0;i<8;i++){
        //     for(int j=0;j<8;j++){

        //         if(isCheckMate(i,j,king,ninja)){
        //             ans[0]++;
        //         }else if(isCheck(i,j,king,ninja)){
        //             ans[1]++;
        //         }else if(isStaleMate(i,j,king,ninja)){
        //             ans[2]++;
        //         }else{
        //             ans[3]++;
        //         }

        //     }
        // }
        return ans;
    }

    static boolean isCheckMate(int i,int j,String king,String ninja){
        int[] k = getCord(king);
        int[] n = getCord(ninja);

        System.out.println(k[0] +" : "+k[1]);
        return false;
    }

    static int[] getCord(String king){
        int[] ans = new int[2];
        char ch= king.charAt(0);
        switch(ch){
            case 'a':
                ans[0]=0;
                break;
            case 'b':
                ans[0]=1;
                break;
            case 'c':
                ans[0]=2;
                break;
            case 'd':
                ans[0]=3;
                break;
            case 'e':
                ans[0]=4;
                break;
            case 'f':
                ans[0]=5;
                break;
            case 'g':
                ans[0]=6;
                break;
            case 'h':
                ans[0]=7;
                break;
            default:
                break;
        }
        ans[1] = Integer.parseInt(String.valueOf(king.charAt(1)));
        return ans;
    }

}
