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
 import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.ZERO;
        BigInteger multiplier1 = BigInteger.ONE;
        ListNode temp1 = l1;
        while (temp1 != null) {
            BigInteger val = BigInteger.valueOf(temp1.val);
            num1 = num1.add(val.multiply(multiplier1));
            multiplier1 = multiplier1.multiply(BigInteger.TEN);
            temp1 = temp1.next;
        }

        BigInteger num2 = BigInteger.ZERO;
        BigInteger multiplier2 = BigInteger.ONE;
        ListNode temp2 = l2;
        while (temp2 != null) {
            BigInteger val = BigInteger.valueOf(temp2.val);
            num2 = num2.add(val.multiply(multiplier2));
            multiplier2 = multiplier2.multiply(BigInteger.TEN);
            temp2 = temp2.next;
        }


        BigInteger sum = num1.add(num2);
        String sumStr = sum.toString();

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int i = sumStr.length() - 1; i >= 0; i--) {
            int digit = sumStr.charAt(i) - '0';
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }
}