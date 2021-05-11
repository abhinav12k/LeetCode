package Stack;

import java.util.HashMap;
import java.util.Stack;

public class freqStack {

    public static void main(String[] args) {



    }

    static class FreqStack {

        HashMap<Integer,Integer> freq;
        HashMap<Integer, Stack<Integer>> group;
        int maxFreq;

        public FreqStack() {
            freq = new HashMap();
            group = new HashMap();
            maxFreq = 0;
        }

        public void push(int val) {
            int f = freq.getOrDefault(val,0);
            freq.put(val,f+1);
            if(f>maxFreq)
                maxFreq = f;
            group.computeIfAbsent(f,z->new Stack<Integer>()).push(val);
        }

        public int pop() {

            int val = group.get(maxFreq).pop();
            freq.put(val,freq.get(val)-1);
            if(group.get(maxFreq).size()==0)
                maxFreq--;
            return val;
        }
    }

}
