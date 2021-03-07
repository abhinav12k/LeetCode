package TwoPointer;

public class intersectionLL {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int len1 = 0;
            int len2 = 0;

            ListNode temp1 = headA;
            ListNode temp2 = headB;
            while (temp1!=null){
                len1++;
                temp1 = temp1.next;
            }

            while (temp2!=null){
                len2++;
                temp2 = temp2.next;
            }
            ListNode tmp;
            if(len1 > len2){

                tmp = headA;
                while(tmp!=null && len1 != len2){
                    len1--;
                    tmp = tmp.next;
                }

                while(tmp!=headB){
                    tmp = tmp.next;
                    headB = headB.next;
                }
                return tmp;

            }else if(len2 > len1){

                tmp = headB;
                while(tmp!=null && len2 != len1){
                    len2--;
                    tmp = tmp.next;
                }

                while(tmp!=headA){
                    tmp = tmp.next;
                    headA = headA.next;
                }
                return tmp;
            }


            return null;
        }
    }
}
