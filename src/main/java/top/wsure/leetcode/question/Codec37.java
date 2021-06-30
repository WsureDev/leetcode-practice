package top.wsure.leetcode.question;

/**
 * FileName: Codec37
 * Author:   wsure
 * Date:     2021/6/30 3:46 下午
 * Description:序列化二叉树
 */
//请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。
//
//
//
// 示例：
//
//
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
//
//
//
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树
// 👍 198 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import top.wsure.leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

public class Codec37 {
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if(node != null){
                deque.addLast(node.left);
                deque.addLast(node.right);
                res.append(node.val).append(',');
            } else {
                res.append("null,");
            }
        }
        return "["+(res.length() > 0 ? res.subSequence(0,res.length()-1).toString() : res.toString())+"]";
    }
    public TreeNode deserialize(String data) {
        data = data.replaceAll("]","").replaceAll("\\[","");
        TreeNode root = null;
        if(!data.isEmpty()){
            String[] nums = data.split(",");
            if(nums.length>0){
                int index = 0,len = 1;
                root = createNode(nums,index);
                Deque<TreeNode> deque = new LinkedList<>();
                deque.addFirst(root);
                //todo 前面的蛆，以后再来探索吧
                /*
                while (!deque.isEmpty()){
                    int numCount = 0;
                    for(int i =0;i<len;i++){
                        if()
                        TreeNode left =
                    }
                }
                */
            }
        }
        return root;
    }

    public TreeNode createNode(String[] nums,int index){
        return index < 0 || index >= nums.length || nums[index] == null || nums[index].isEmpty() ? null : new TreeNode(Integer.parseInt(nums[index]));
    }

    /**
     * 理解错题意的笨比做法
     * null补齐
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serializeOld(TreeNode root) {
        TreeNode node = null;
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        Deque<TreeNode> temp = null;
        deque1.addFirst(root);
        int noNullCount = 1;
        while (noNullCount > 0){
            noNullCount = deque1.size();
            StringBuilder line = new StringBuilder();
            while (!deque1.isEmpty()){
                node = deque1.pollLast();
                if(node == null){
                    line.append("null,");
                    deque2.addFirst(null);
                    deque2.addFirst(null);
                    noNullCount --;
                } else {
                    line.append(node.val).append(',');
                    deque2.addFirst(node.left);
                    deque2.addFirst(node.right);
                }
            }
            temp = deque2;
            deque2 = deque1;
            deque1 = temp;
            if(noNullCount>0){
                res.append(line);
            }
        }
        return res.length()>0 ? "[" + res.subSequence(0,res.length()-1).toString() + "]" : "[]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeOld(String data) {
        data = data.replaceAll("]","").replaceAll("\\[","");
        TreeNode root = null;
        if(data != null && !data.isEmpty()){
            List<TreeNode> list = Arrays.stream(data.split(","))
                    .map(v-> v.equals("null") ? null : new TreeNode(Integer.parseInt(v)))
                    .collect(Collectors.toList());
            if(list.isEmpty()) return root; else root = list.get(0);
            for (int i = 0;i<list.size();i++){
                TreeNode node = list.get(i);
                if(node != null && 2* i +2 < list.size()){
                    node.left = list.get(2* i +1);
                    node.right = list.get(2* i +2);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec37 codec37 = new Codec37();
        String arrStr = codec37.serialize(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),new TreeNode(7,new TreeNode(8),null))));
        System.out.println(arrStr);
//        TreeNode node = codec37.deserialize(arrStr);
//        System.out.println(codec37.serialize(node));
        codec37.deserialize("[]");
        System.out.println(codec37.serialize(null));
    }
}
