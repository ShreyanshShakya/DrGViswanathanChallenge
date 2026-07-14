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
    public boolean isPalindrome(ListNode head) {
        ListNode a = head;
        Stack<Integer> st = new Stack<>();
        while(a!=null){
            st.push(a.val);
            a = a.next;
        }
        a = head;
        while(a!=null){
            if(a.val != st.pop()){
                return false; 
            }
            a = a.next;
        }
        return true;
    }
}