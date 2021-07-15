package Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class decodeString {

    public static void main(String[] args) {

        System.out.println(decode("3[c2[a]]"));

    }

    private static String decode(String str){

        Queue<Character> queue = new LinkedList<>();
        for(char c : str.toCharArray()){
            queue.add(c);
        }
        return helper(queue);
    }

    private static String helper(Queue<Character> queue){

        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(!queue.isEmpty()){

            char ch = queue.poll();

            if(Character.isDigit(ch)){
                num = num*10 + ch-'0';
            }else if(ch == '['){
                String subAns = helper(queue);
                for(int i=1;i<=num;i++){
                    sb.append(subAns);
                }
                num = 0;
            }else if(ch == ']'){
                break;
            }else{
                sb.append(ch);
            }

        }
        return sb.toString();
    }

}
