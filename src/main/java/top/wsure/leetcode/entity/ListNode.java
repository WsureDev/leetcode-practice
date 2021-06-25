package top.wsure.leetcode.entity;

/**
 * FileName: ListNode
 * Author:   wsure
 * Date:     2021/6/25 2:41 下午
 * Description:
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}