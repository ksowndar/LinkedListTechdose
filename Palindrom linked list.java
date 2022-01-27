Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


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
    public ListNode reverseNode(ListNode head)
    {
       if(head==null)
           return head;
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        
        while(present!=null)
        {
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null)
                next=next.next;
       }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverse=reverseNode(slow);
        ListNode rerevNode=reverse;
        
        while(head!=null && reverse!=null)
        {
            if(head.val!=reverse.val)
            {
                break;
            }
            head=head.next;
            reverse=reverse.next;
        }
        reverseNode(rerevNode);
        
        return head==null || reverse==null;
    }
}
