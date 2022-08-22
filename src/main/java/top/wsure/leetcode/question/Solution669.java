package top.wsure.leetcode.question;

import top.wsure.leetcode.entity.TreeNode;
import top.wsure.leetcode.utils.InputDataFormatUtils;
import top.wsure.leetcode.utils.PrintUtils;

import java.util.LinkedList;

/*
    FileName:   Solution669
    Author:     wsure
    Date:       2022/8/17
    Description:
*/
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        if(root.val < low) {
            return trimBST(root.right,low,high);
        } else if(root.val > high) {
            return trimBST(root.left,low,high);
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }




    public static void main(String[] args) {
        TreeNode node = InputDataFormatUtils.createTreeNode("[3,1,4,null,2]");
        new Solution669().trimBST(node,3,4);
        PrintUtils.printTreeNode(node);
    }
}
