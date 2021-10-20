package top.wsure.leetcode.question;
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，
//pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
// 说明：不允许修改给定的链表。
//
// 进阶：
//
//
// 你是否可以使用 O(1) 空间解决此题？
//
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围在范围 [0, 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
// pos 的值为 -1 或者链表中的一个有效索引
//
// Related Topics 哈希表 链表 双指针 👍 1221 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//
//import top.wsure.leetcode.entity.ListNode;

import top.wsure.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution142 {
    /**
     * 非最优解，最优解是假设a+b长度，那么你走a+nb步一定在入口，面试时先写出最简单解，等后续讲优化时再引出推导的优化方法
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        set.add(p);
        while (p.next != null && !set.contains(p.next)){
            set.add(p.next);
            p = p.next;
        }
        return p.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 *
 15:45	info: 已提交,请稍等

 15:45	info
 解答成功:
 执行耗时:4 ms,击败了11.90% 的Java用户
 内存消耗:39.7 MB,击败了5.10% 的Java用户

 */