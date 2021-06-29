package top.wsure.leetcode.utils;

import top.wsure.leetcode.entity.ListNode;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static <R> String printList(List<R> list, Function<? super R, String> mapper,CharSequence delimiter){
        return list.stream().map(mapper).collect(Collectors.joining(delimiter));
    }

    public static void printListListInteger(List<List<Integer>> list){
        System.out.println(printList(list,v -> printList(v, Object::toString,","),"\n"));
    }
}
