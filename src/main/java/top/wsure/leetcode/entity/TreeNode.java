package top.wsure.leetcode.entity;

/**
 * FileName: TreeNode
 * Author:   wsure
 * Date:     2021/6/30 4:24 下午
 * Description:TreeNode
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int x) {
        val = x;
    }
    public TreeNode(int x,TreeNode left,TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}