package top.wsure.leetcode.question;

/**
 * FileName: Solution24
 * Author:   wsure
 * Date:     2021/6/25 2:38 下午
 * Description:两两交换链表中的节点
 */
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
// 👍 951 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import top.wsure.leetcode.entity.ListNode;
import top.wsure.leetcode.entity.Node;
import top.wsure.leetcode.utils.InputDataFormatUtils;
import top.wsure.leetcode.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//leetcode submit region end(Prohibit modification and deletion)

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode p1 = head,
                p2 = nextNode(head),
                root = p2,
                h = null;
        if(p2 == null) return head;
        while (p2 != null){
            ListNode tail = nextNode(p2);
            p2.next = p1;
            p1.next = tail;
            if(h != null){
                h.next = p2;
            }
            h = p1;
            p1 = nextNode(p1);
            p2 = nextNode(p1);
        }

        return root;
    }

    public ListNode nextNode(ListNode head){
        return Optional.ofNullable(head).map(node -> node.next).orElse(null);
    }

    public static void main(String[] args) {
        ListNode root = InputDataFormatUtils.createListNode("[1,2,3,4,5,6]");
        root = new Solution24().swapPairs(root);
        PrintUtils.printListNode(root);
    }
    /*
    5:10 下午	info: 已提交,请稍等

    5:10 下午	info
					解答成功:
					执行耗时:1 ms,击败了100.00% 的Java用户
					内存消耗:36.2 MB,击败了15.87% 的Java用户
     */

}
