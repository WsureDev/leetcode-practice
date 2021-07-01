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
        //res 用于提交，noNullLine 用于存放null，当有非null时提交到res且清空自身
        StringBuilder res = new StringBuilder(), noNullLine = new StringBuilder();
        //经典bfs起手式
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            //尾插头取
            TreeNode node = deque.pollFirst();
            if(node != null){
                //非null时肯定有自己左右孩子的null，直接插（最后一层除外，多余的null用noNullLine提交的方式规避）
                deque.addLast(node.left);
                deque.addLast(node.right);
                //遇到非null，就提交noNullLine到res，再提交自己
                res.append(noNullLine).append(node.val).append(',');
                //清空noNullLine
                noNullLine.delete(0,noNullLine.length());
            } else {
                //记录null，等待非null出现一并提交
                noNullLine.append("null,");
            }
        }
        //去尾部逗号 加括号
        return "["+(res.length() > 0 ? res.subSequence(0,res.length()-1).toString() : res.toString())+"]";
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        //去括号
        data = data.replaceAll("]","").replaceAll("\\[","");
        TreeNode root = null;
        if(!data.isEmpty()){
            //切成数组
            String[] nums = data.split(",");
            if(nums.length>0){
                //index 表示当前起始位置 ，len表示index开始的一层的元素数量
                int index = 0,len = 1;
                root = createNode(nums,0);
                //bfs起手式
                Deque<TreeNode> deque = new LinkedList<>();
                deque.addFirst(root);
                //todo 前面的蛆，以后再来探索吧
                /**
                 * 思想 ： 使用一个双向链表实现存储一层，可能存在null，遍历记录本层非Null数量*2 ，就是下一层的长度。
                 * 在取出本层元素的时候，同时填充下一层，
                 * 每个取出的非null node的left位于 ：起始位置 + 本层长度 + 在本层非null元素序号（从0开始） * 2
                 * 每个取出的非null node的right位于 ：起始位置 + 本层长度 + 在本层非null元素序号（从0开始） * 2 +1
                 * 当每个层循环取出并填充孩子结束后，队列又被填满下一层的null和非null元素
                 */
                while (!deque.isEmpty() && index + len < nums.length){
                    //记录在本层的非null元素数，用于统计下一层元素数
                    int numCount = 0;
                    for(int i = 0;i<len;i++){
                        TreeNode node = deque.removeLast();
                        if(node != null) {
                            TreeNode left = createNode(nums,index +len+2*numCount);
                            TreeNode right = createNode(nums,index +len+2*numCount+1);
                            node.left = left;
                            node.right = right;
                            deque.addFirst(left);
                            deque.addFirst(right);
                            numCount ++;
                        }
                    }
                    //一层结束，index 移到下一层的位置
                    index += len;
                    //本层的非null元素数*2就是下一层的长度
                    len = numCount *2;
                }
            }
        }
        return root;
    }

    public TreeNode createNode(String[] nums,int index){
        return index < 0 || index >= nums.length || nums[index] == null || nums[index].isEmpty() || nums[index].equals("null") ? null : new TreeNode(Integer.parseInt(nums[index]));
    }

    /**
     * 4:02 下午	info: 已提交,请稍等
     *
     * 4:02 下午	info
     * 					解答成功:
     * 					执行耗时:28 ms,击败了24.76% 的Java用户
     * 					内存消耗:39.7 MB,击败了92.44% 的Java用户
     */





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
//        String arrStr = codec37.serialize(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),new TreeNode(7,new TreeNode(8),null))));
//        System.out.println(arrStr);
//        TreeNode node = codec37.deserialize(arrStr);
//        System.out.println(codec37.serialize(node));
//        codec37.deserialize("[]");
//        System.out.println(codec37.serialize(null));

        String input = "[5,2,3,null,null,2,4,3,1]";
        TreeNode t1 = codec37.deserialize(input);
        System.out.println(codec37.serialize(t1));
    }
}
