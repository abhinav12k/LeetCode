package Recursion;

public class towerOfHanoi {

    public static void main(String[] args) {

        printSteps(1,3,2,3);
    }

    private static void printSteps(int source,int dest,int helper,int n){

        if(n==1){
            System.out.println("Shift Plate from "+source+"to"+dest);
            return;
        }

        printSteps(source,helper,dest,n-1);
        System.out.println("Shift Plate form "+source+"to"+dest);
        printSteps(helper,dest,source,n-1);
    }

}
