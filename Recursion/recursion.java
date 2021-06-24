package Recursion;

public class recursion {

    public static void main(String[] args) {

//        PD(10);
//        PI(10);
//        System.out.println(getFibonacci(1));
//        System.out.println(factorial(7));
        int[] arr = {1,5,8,6,7,2,0,60,8};
//        printArray(arr,0);
//        printRevArray(arr,0);
//        System.out.println(max(arr,0));
        System.out.println(getFirstIndex(arr,0,8));
        System.out.println(getLastIndex(arr,0,8));
        int[] ans = findAllIndex(arr,0,8,0);
        for(int a: ans)
            System.out.print(a+" ");
    }

    private static void PD(int n){

        if(n==0)
            return;

        System.out.println(n);
        PD(n-1);

    }

    private static void PI(int n){

        if(n==0)
            return;

        PI(n-1);
        System.out.println(n);

    }

    private static int getFibonacci(int n){

        if(n==0)
            return 0;
        else if(n==1)
            return 1;

        return getFibonacci(n-1)+getFibonacci(n-2);

    }

    private static int factorial(int n){

        if(n==0||n==1)
            return 1;

        return n * factorial(n-1);

    }

    private static void printArray(int[] arr,int idx){

        if(idx==arr.length)
            return;

        System.out.println(arr[idx]);
        printArray(arr,idx+1);
    }

    private static void printRevArray(int[] arr,int idx){

        if(idx==arr.length)
            return;

        printRevArray(arr,idx+1);
        System.out.println(arr[idx]);

    }

    private static int max(int[] arr,int idx){

        if(idx==arr.length)
            return Integer.MIN_VALUE;

       int rr = max(arr,idx+1);

        return Math.max(rr, arr[idx]);
    }

    private static int getFirstIndex(int[] arr, int idx,int item){

        if(idx==arr.length)
            return -1;

        if(arr[idx]==item)
            return idx;

        return getFirstIndex(arr,idx+1,item);
    }

    private static int getLastIndex(int[] arr,int idx,int item){

        if(idx == arr.length)
            return -1;

        int rr = getLastIndex(arr,idx+1,item);

        if(arr[idx]==item && rr == -1)
            return idx;

        return rr;
    }

    private static int[] findAllIndex(int[] arr,int idx,int item,int count){

        if(idx==arr.length){
            int[] br = new int[count];
            return br;
        }

        int[] rr;

        if(arr[idx]==item){

            rr = findAllIndex(arr,idx+1,item,count+1);
            rr[count] = idx;

        }else{
            rr = findAllIndex(arr,idx+1,item,count);
        }

        return rr;
    }

}
