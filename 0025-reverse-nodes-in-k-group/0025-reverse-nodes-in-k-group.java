/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode count = head;
        int n = 0;
        while(count != null){
            count = count.next;
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        
        while(n>=k){
            ListNode Ghead = prevGroupTail.next;
            ListNode Gtail = Ghead;
            for(int i=1;i<k;i++){
                Gtail = Gtail.next;
            }
            ListNode nextGroupHead = Gtail.next;
            Gtail.next = null;
            prevGroupTail.next = reverse(Ghead);
            Ghead.next = nextGroupHead;
            prevGroupTail = Ghead;
            n-=k;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prev = null;
        while(temp!= null){
            ListNode t1 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t1;
        }
        return prev;
    }
}