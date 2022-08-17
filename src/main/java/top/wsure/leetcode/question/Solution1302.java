package top.wsure.leetcode.question;

import top.wsure.leetcode.entity.TreeNode;
import top.wsure.leetcode.utils.InputDataFormatUtils;

import java.util.LinkedList;

/*
    FileName:   Solution1302
    Author:     wsure
    Date:       2022/8/17
    Description:
*/
public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        int sum = Integer.MIN_VALUE;
        if(root == null) return sum;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 1;
        sum = 0;
        while (!queue.isEmpty()){
            TreeNode n = queue.pollFirst();
            sum+=n.val;
            if(n.left != null){
                queue.add(n.left);
            }
            if(n.right != null){
                queue.add(n.right);
            }
            len -- ;
            if(len == 0){
                len = queue.size();
                if(!queue.isEmpty()){
                    sum = 0;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = InputDataFormatUtils.createTreeNode("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]");
        System.out.println(new Solution1302().deepestLeavesSum(treeNode));
    }
}
/*
> 2022/08/17 15:28:54
Success:
	Runtime:9 ms, faster than 7.84% of Java online submissions.
	Memory Usage:43.8 MB, less than 50.98% of Java online submissions.
 */