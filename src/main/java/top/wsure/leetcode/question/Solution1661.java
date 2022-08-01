package top.wsure.leetcode.question;
//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
// 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
//
//
// 示例 2：
//
//
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
//
//
//
//
// 提示：
//
//
// 树中的节点数在
// [1, 10⁴]范围内
//
// -10⁵ <= Node.val <= 10⁵
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 59 👎 0


import top.wsure.leetcode.entity.ListNode;
import top.wsure.leetcode.entity.TreeNode;
import top.wsure.leetcode.utils.InputDataFormatUtils;
import top.wsure.leetcode.utils.PrintUtils;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution1661 {
    public int maxLevelSum(TreeNode root) {
        int maxSumLevel = 1 , maxSum = root.val,level = 1;
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>(){{
            add(root);
        }};
        while (!linkedList.isEmpty()){
            bfs(linkedList);
            level ++;
            if(linkedList.isEmpty()){
                break;
            }
            int nowSum = linkedList.stream().mapToInt( v -> v.val).sum();
            if(nowSum > maxSum){
                maxSumLevel = level;
                maxSum = nowSum;
            }
        }
        return maxSumLevel;
    }

    public void bfs(LinkedList<TreeNode> parentLevel){
        int parentLevelSize = parentLevel.size();
        while (parentLevelSize > 0){
            TreeNode node = parentLevel.pollFirst();
            if(node != null && node.left != null){
                parentLevel.addLast(node.left);
            }
            if(node != null && node.right != null){
                parentLevel.addLast(node.right);
            }
            parentLevelSize --;
        }
    }

    public static void main(String[] args) {
        TreeNode root = InputDataFormatUtils.createTreeNode("[-100,-200,-300,-20,-5,-10,null,12,12,234,345,25,22,75,26,null,24,null,44,-1,null,null,null,1]");
        Solution1661 solution1661 = new Solution1661();
        PrintUtils.printTreeNode(root);
        System.out.println(solution1661.maxLevelSum(root));
    }

}
