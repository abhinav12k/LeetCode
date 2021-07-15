package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class sortArray {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,5,64,8,32,10,5));
        sortArray(list);
        System.out.println(list);
    }

    private static void sortArray(ArrayList<Integer> arr){

        if(arr.size()==1)
            return;

        int last = arr.remove(arr.size()-1);
        sortArray(arr);

        insert(arr,last);

    }

    private static void insert(ArrayList<Integer> arr, int last){

        if(arr.size()==0 || arr.get(arr.size()-1) <= last){
            arr.add(last);
            return;
        }

        int prev = arr.remove(arr.size()-1);
        insert(arr,last);
        arr.add(prev);
    }

}
