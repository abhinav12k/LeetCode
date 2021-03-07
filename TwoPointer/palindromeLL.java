package TwoPointer;

import java.util.List;
import java.util.Stack;

public class palindromeLL {

    public static void main(String[] args) {


    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {

            Stack<Integer> s = new Stack<>();
            ListNode temp = head;
            while(temp!=null){
                s.push(temp.val);
                temp = temp.next;
            }

            ListNode track = head;
            while(!s.isEmpty()){
                if(s.pop() != track.val){
                    return false;
                }
                s.pop();
                track = track.next;
            }

            return true;
        }
    }

}
