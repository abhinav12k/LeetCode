package TwoPointer;

public class LL_cycle {

    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = null;
            if(head != null)
                fast = head.next;

            while(slow != null && fast != null && fast.next!= null){

                if(slow == fast)
                    return true;

                slow = slow.next;
                fast = fast.next.next;

            }
            return false;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
