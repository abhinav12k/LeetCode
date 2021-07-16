package Recursion;

public class nBitBinary {
    public static void main(String[] args) {
        printNthBinaryWith1sMoreThan0s(3,0,0,"");
    }

    private static void printNthBinaryWith1sMoreThan0s(int n,int nOnes,int nZeros,String ans){

        if(nOnes < nZeros){
            return;
        }

        if(n == 0){
            System.out.println(ans);
            return;
        }

        printNthBinaryWith1sMoreThan0s(n-1,nOnes+1,nZeros,ans+"1");
        printNthBinaryWith1sMoreThan0s(n-1,nOnes,nZeros+1,ans+"0");

    }
}
