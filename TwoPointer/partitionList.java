package TwoPointer;

public class partitionList {

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
        public ListNode partition(ListNode head, int x) {
            //Approach 1
            if (head == null || head.next == null)
                return head;

            ListNode result = new ListNode();
            ListNode track = result;

            ListNode target = head;

            while (target != null && target.val < x) {
                target = target.next;
            }

            if (target == null) {
                //no element is either greater or equal to x
                return head;
            } else {
                ListNode start = head;
                while (start.val < target.val) {
                    ListNode temp = new ListNode(start.val);
                    track.next = temp;
                    track = temp;
                    start = start.next;
                }

                ListNode end = target.next;
                while (end != null) {
                    if (end.val < target.val && end.val < x) {
                        ListNode temp = new ListNode(end.val);
                        track.next = temp;
                        track = temp;
                    }
                    end = end.next;
                }

                while (target != null) {
                    if (target.val >= x) {
                        ListNode temp = new ListNode(target.val);
                        track.next = temp;
                        track = temp;
                    }
                    target = target.next;
                }
            }
            return result.next;
        }

        public ListNode partition2(ListNode head,int x){

            //Approach 2 -> Make two separate lists and then merge them

            ListNode firstHead = new ListNode(0);
            ListNode first = firstHead;

            ListNode secondHead = new ListNode(x);
            ListNode second = secondHead;

            ListNode currNode = head;
            while(currNode != null){

                if(currNode.val < x){

                    first.next = currNode;
                    first = currNode;

                }else{

                    second.next = currNode;
                    second = currNode;
                    second.next = null;

                }

                currNode = currNode.next;
            }
            first.next = secondHead.next;
            return firstHead.next;
        }

    }
}
