public class longestTurbulentSubArrau {

    public static void main(String[] args) {
        int[] arr = {4};
        Print p = new Print();
        p.print(new Solution().maxTurbulenceSize(arr));
    }

    static class Solution {
        public int maxTurbulenceSize(int[] arr) {

            int inc = 1,dec = 1,ans = 0;
            for(int i=1;i<arr.length;i++) {
                if (arr[i] > arr[i - 1]) {
                    inc = dec + 1;
                    dec = 1;
                }else if(arr[i] < arr[i-1]){
                    dec = inc +1 ;
                    dec = 1;
                }else{
                    inc = 1;
                    dec = 1;
                }
                ans = Math.max(ans,Math.max(inc,dec));
            }
            return ans;
        }
    }

    static class Print<V>{
        void println(String s){
            System.out.println(s);
        }
        void print(String s){
            System.out.print(s);
        }
        void println(int num){
            System.out.println(num);
        }
        void print(int num){
            System.out.print(num);
        }
        void print(int[] arr){
            print("[");
            for(int i=0;i<arr.length-1;i++)
                print(arr[i] + ", ");
            print(arr[arr.length-1] + "]");
        }
        void print(V v){
            System.out.println(v);
        }
    }
}
