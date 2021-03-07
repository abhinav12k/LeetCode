public class checkPowerOf3 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean checkPowersOfThree(int n) {
            int start = 1;
            while(true){

                if(start==n){
                    return true;
                }else if(start>n){
                    return false;
                }

                start+=start*3;
            }
        }
    }
}
