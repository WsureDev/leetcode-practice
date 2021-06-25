package top.wsure.leetcode.utils;

import top.wsure.leetcode.entity.ListNode;

/**
 * FileName: PrintUtils
 * Author:   wsure
 * Date:     2021/6/25 5:02 下午
 * Description:
 */
public class PrintUtils {

    public static void printListNode(ListNode root){
        while (root!=null){
            System.out.print(root.val+"->");
            root = root.next;
        }
        System.out.println();
    }
}
