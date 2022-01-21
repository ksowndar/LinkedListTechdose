Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode middle=getMiddle(head);
        ListNode left=sortList(head);
        ListNode right=sortList(middle);
        return merge(left,right);
        
    }
    public ListNode getMiddle(ListNode head)
    {
        ListNode midPrev=null;
        while(head!=null && head.next!=null)
        {
            midPrev=(midPrev==null)?head:midPrev.next;
            head=head.next.next;
        }
        ListNode mid=midPrev.next;
        midPrev.next=null;
        return mid;
    }
    public ListNode merge(ListNode list1,ListNode list2)
    {
        ListNode node=new ListNode();
        ListNode tail=node;
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                tail.next=list1;
                list1=list1.next;
                tail=tail.next;
            }
            else
            {
                tail.next=list2;
                list2=list2.next;
                tail=tail.next;
            }
        }
        while(list1!=null)
        {
                tail.next=list1;
                list1=list1.next;
                tail=tail.next;
        }
        while(list2!=null)
        {
                tail.next=list2;
                list2=list2.next;
                tail=tail.next;
        }
        return node.next;
    }
}
