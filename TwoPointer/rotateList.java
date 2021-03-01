package TwoPointer;

import java.util.List;

public class rotateList {

    public static void main(String[] args) {


    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if (head == null || head.next == null)
                return head;

            if (k == 0)
                return head;


            int size = 1;
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
                size++;
            }

            if (k > size) {
                k = k % size;
            }

            for (int i = 0; i < k; i++) {

                ListNode prev = head;
                tail = head;
                while (tail.next != null) {
                    prev = tail;
                    tail = tail.next;
                }
                tail.next = head;
                prev.next = null;
                head = tail;

            }
            return head;
        }
    }

}
