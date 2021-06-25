package top.wsure.leetcode.entity;

import java.util.List;

/**
 * FileName: Node
 * Author:   wsure
 * Date:     2021/6/25 3:45 下午
 * Description:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}