package DynamicProgramming;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int sum = 1;
        System.out.println(countTargetSum(arr,sum));
    }

    private static int countTargetSum(int[] arr,int sum){
        int range = 0;
        for(int a: arr)
            range+=a;

        int val = (sum + range)/2;

        return countSubsetSum(arr,val);

    }

    private static int countSubsetSum(int[] arr,int val){
        int[][] t = new int[arr.length+1][val+1];
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=val;j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<=arr.length;i++){
            for(int j =1;j<=val;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][val];
    }
}
