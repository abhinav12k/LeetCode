package TwoPointer;

public class removeNthNode {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode res = new ListNode(0);
            res.next = head;
            ListNode curr = head;
            ListNode prev = curr;

            for(int i = 0;i < n;i++)
                head = head.next;

            //if head == null -> n -> size of LL
            if(head == null)
                return res.next.next;

            while(head != null){
                prev = curr;
                curr = curr.next;
                head = head.next;
            }
            prev.next = curr.next;
            return res.next;
        }
    }
}
