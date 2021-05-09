package HackWithInfyGuidedPath.SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class formATriangle {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(12, 3, 7, 4, 28));
        if (isTrianglePossible(arr)) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

    private static boolean isTrianglePossible(ArrayList<Integer> arr) {

        Collections.sort(arr);

        for(int i=0;i+3<=arr.size();i++){
            int a = arr.get(i);
            int b = arr.get(i+1);
            int c = arr.get(i+2);
            if(isNonDegenerateTriangle(a,b,c)){
               return true;
            }
        }
        return false;
    }

    private static boolean isNonDegenerateTriangle(int a,int b, int c){
        return a+b>c && b+c>a && a+c>b;
    }
}
