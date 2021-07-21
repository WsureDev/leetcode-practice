package top.wsure.leetcode.question;

import top.wsure.leetcode.entity.ListNode;

import java.util.Optional;
//输入两个链表，找出它们的第一个公共节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/
//
// Related Topics 哈希表 链表 双指针
// 👍 289 👎 0
/**
 * FileName: SolutionOffer52
 * Author:   wsure
 * Date:     2021/7/21 4:45 下午
 * Description:
 */
public class SolutionOffer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode tailB = headB,tailA = headA;int countB = 0;
        while (tailB.next != null || tailA.next != null){
            if(tailB.next != null){
                countB ++;
                tailB = tailB.next;
            }
            if(tailA.next != null) {
                countB--;
                tailA = tailA.next;
            }
        }
        if(tailA != tailB){
            return null;
        } else {
            tailA = headA;
            tailB = headB;
            if(countB >0){

                while (countB>0){
                    tailB = tailB.next;
                    countB --;
                }
            } else if(countB < 0){

                while (countB<0){
                    tailA = tailA.next;
                    countB ++;
                }
            }

            while (tailA != null && tailB != null && tailA != tailB){
                tailA = tailA.next;
                tailB = tailB.next;
            }
            return tailA;
        }

    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(8,new ListNode(4,new ListNode(5)));
        ListNode n1 = new ListNode(4,new ListNode(1,n3));
        ListNode n2 = new ListNode(5,new ListNode(0,new ListNode(3,n3)));

        System.out.println(Optional.ofNullable(new SolutionOffer52().getIntersectionNode(n1,n2)).map( v->v.val).orElse(null));

    }
}

/**
 *
 * 4:55 下午	info: 已提交,请稍等
 *
 * 4:55 下午	info
 * 					解答成功:
 * 					执行耗时:1 ms,击败了100.00% 的Java用户
 * 					内存消耗:41.2 MB,击败了41.01% 的Java用户
 */