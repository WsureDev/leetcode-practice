package top.wsure.leetcode.utils;

import top.wsure.leetcode.entity.ListNode;
import top.wsure.leetcode.entity.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FileName: PrintUtils
 * Author:   wsure
 * Date:     2021/6/25 5:02 下午
 * Description:
 */
public class PrintUtils {

    public static void printListNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }
        System.out.println();
    }

    public static <R> String printList(List<R> list, Function<? super R, String> mapper, CharSequence delimiter) {
        return list.stream().map(mapper).collect(Collectors.joining(delimiter));
    }

    public static void printListListInteger(List<List<Integer>> list) {
        System.out.println(printList(list, v -> printList(v, Object::toString, ","), "\n"));
    }

    public static void printTreeNode(TreeNode root) {
        int wd = 4;
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>() {{
            add(root);
        }};
        List<List<String>> res = new ArrayList<>();
        while (!linkedList.isEmpty() && !linkedList.stream().allMatch(Objects::isNull)) {
            res.add(linkedList.stream().map(v -> String.format("%" + wd + "s", v == null ? "null" : String.valueOf(v.val))).collect(Collectors.toList()));
            linkedList = bfs(linkedList);
        }
        int longest = res.size();
        for (int i = 0; i < res.size(); i++) {
            List<String> row = res.get(i);
            int pre = (int) ((Math.pow(2, longest - i - 1) - 1) * wd);
            int delimiter = (int) ((Math.pow(2, longest - i) - 1) * wd);
            System.out.println(repeat(" ", pre) + String.join(repeat(" ", delimiter), row));
            if (i != res.size() - 1) {
                System.out.println(repeat(" ", pre) + row.stream().map(v -> String.format("%" + wd + "s", " / \\")).collect(Collectors.joining(repeat(" ", delimiter))));
            }
        }
    }
/*  推算过程
              11                        1: 2^(n-i)-1    :
      22              33                2: 2^(n-i)-1    :  2^(n-i+1)-1
  44      55      66      77
88  99  00  00  00  00  00  00
              11                        1: 2^(n-i)-1    :
          _   /\_                    -:
      22              33                2: 2^(n-i)-1    :  2^(n-i+1)-1
    _ /\_          _  /\_
  44      55      66      77
 _/\_    _/\_    _/\_    _/\_
88  99  00  00  00  00  00  00
*/

    public static String repeat(String s, int count) {
        return String.join("", Collections.nCopies(count, s));
    }

    public static LinkedList<TreeNode> bfs(LinkedList<TreeNode> parentLevel) {
        LinkedList<TreeNode> res = new LinkedList<TreeNode>();
        int parentLevelSize = parentLevel.size();
        for (TreeNode node : parentLevel) {
            if (node != null) {
                res.addLast(node.left);
                res.addLast(node.right);
            } else {
                res.addLast(null);
                res.addLast(null);
            }
        }
        return res;
    }

    public static void printArray(int[][] arr) {
        System.out.println(Arrays.stream(arr).map(Arrays::toString).collect(Collectors.joining()));
    }
}
