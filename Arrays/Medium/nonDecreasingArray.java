package Arrays.Medium;

public class nonDecreasingArray {

    public static void main(String[] args) {

        int[] arr = {5,7,1,8};
        System.out.println(canBeMadeNonDecreasing(arr));
    }

    private static boolean canBeMadeNonDecreasing(int[] arr){

        int count =0;
        for(int i=1;i<arr.length;i++){

            if(arr[i-1]>arr[i]){
                count++;
                if(i-2<0 || arr[i-2] <= arr[i])
                    arr[i-1] = arr[i];
                else
                    arr[i] = arr[i-1];
            }
            if(count>1)
                return false;
        }
        return true;
    }

}
