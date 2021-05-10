package Stack;

import java.util.Stack;

public class minStack {

    public static void main(String[] args) {

//        push(51);
//        push(16);
//        push(8);
//        push(14);
//        push(17);
//        push(16);
//
//        System.out.println(getMin());
//        System.out.println(pop());
//        System.out.println(getMin());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(getMin());

        push_v2(5);
        push_v2(8);
        push_v2(4);
        push_v2(10);
        push_v2(3);
        push_v2(7);

        System.out.println(s2);
        System.out.println(getMin_v2());
        System.out.println(pop_v2());
        System.out.println(pop_v2());
        System.out.println(getMin_v2());

    }

    /***Method 1 - in O(n) extra space**/
    private static final Stack<Integer> s = new Stack<>();
    private static final Stack<Integer> ss = new Stack<>();

    private static void push(int val){

        s.push(val);

        if(ss.isEmpty())
            ss.push(val);

        if(ss.peek() >= val){
            ss.push(val);
        }
    }

    private static int pop(){

        int val = s.pop();
        if(ss.peek() == val)
            ss.pop();
        return val;
    }

    private static int getMin(){

        if(ss.isEmpty())
            return -1;

        return ss.peek();
    }

    /***Method 2 - in O(1) extra space***/

    private static final Stack<Integer> s2 = new Stack<>();
    private static int minElement = -1;

    private static void push_v2(int val){

        if(s2.isEmpty()){
            s2.push(val);
            minElement = val;
        }else{

            if(s2.peek() <= val)
                s2.push(val);
            else{
                s2.push(2*val-minElement);
                minElement = val;
            }

        }

    }

    private static int pop_v2(){

        if(s2.isEmpty())
            return -1;

        int val = s2.pop();

        if(val < minElement){
            int ans = minElement;
            minElement = 2*minElement-val;
            return ans;
        }else{
            return val;
        }
    }

    private static int peek_v2(){
        if(s2.isEmpty())
            return -1;

        int val = s2.peek();

        if(val < minElement){
            return minElement;
        }else{
            return val;
        }
    }

    private static int getMin_v2(){
        if(s2.isEmpty())
            return -1;

        return minElement;
    }

}
