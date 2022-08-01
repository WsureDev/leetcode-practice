package top.wsure.leetcode.utils;

import top.wsure.leetcode.entity.ListNode;
import top.wsure.leetcode.entity.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * FileName: InputDataFormatUtils
 * Author:   wsure
 * Date:     2021/6/24 4:47 下午
 * Description:输入格式转换
 */
public class InputDataFormatUtils {

    /**
     * 输入转二维数组
     *
     * 输入示例: [[1,1],[2,2],[3,3]]
     * @param string
     * @return
     */
    public static int[][] stringToArray(String string){
        List<List<Integer>> out = strArrToList(string,v -> strArrToList(v, Integer::parseInt));
        return out.stream().map( arr -> arr.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }

    public static <R> List<R> strArrToList(String str, Function<String, ? extends R> mapper){
        if(str == null || str.length() <= 2) return new ArrayList<>();
        String string = str.substring(1,str.length()-1);
        return Arrays.stream(string.split(string.contains("[")? "(?<=\\D)," : ","))
                .filter(s -> ! s.isEmpty())
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String str = "[[1,1],[2,2],[3,3]]";
        int[][] arr = stringToArray(str);
        System.out.printf("[%s]%n",
                Arrays.stream(arr).map(Arrays::toString).collect(Collectors.joining(","))
        );
    }


    public static ListNode createListNode(String str){
        List<ListNode> list = strArrToList(str,v-> {
            try {
                return new ListNode(Integer.parseInt(v));
            }catch (Exception e){
                return null;
            }
        });
        for (int i =0;i<list.size();i++){
            if(i<list.size()-1){
                list.get(i).next = list.get(i+1);
            }
        }
        return list.isEmpty() ? null : list.get(0);
    }

    public static TreeNode createTreeNode(String str){
        TreeNode root = null;
        List<Integer> list = strArrToList(str,v-> {
            try {
                return Integer.parseInt(v);
            }catch (Exception e){
                return null;
            }
        });
        if(list.size()>0 && list.get(0) != null){
            root = new TreeNode(list.get(0),null,null);
            TreeNode finalRoot = root;
            LinkedList<TreeNode> layer = new LinkedList<TreeNode>(){{
                add(finalRoot);
            }};
            int parentLayerNum = 1, start = 1 ,end;
            while (start < list.size()){
                end = start+parentLayerNum*2;
                setChildren(layer,list.stream().skip((long) start).limit(parentLayerNum* 2L).collect(Collectors.toList()));
                start = end;
                parentLayerNum = (int) layer.stream().filter(Objects::nonNull).count();
            }
        }

        return root;
    }

    public static void setChildren(LinkedList<TreeNode> parentLevel,List<Integer> level){
        int index = 0,parentSize = parentLevel.size();
        for (int i = 0;i<parentSize;i++){
            TreeNode node = parentLevel.pollFirst();
            if(node != null){
                Integer leftVal ;
                try { leftVal = level.get(index); } catch (Exception e) { leftVal = null; };
                TreeNode left = leftVal == null ? null : new TreeNode(leftVal,null,null);
                node.left = left;
                parentLevel.addLast(left);
                index ++ ;

                Integer rightVal ;
                try { rightVal = level.get(index); } catch (Exception e) { rightVal = null; };
                TreeNode right = rightVal == null ? null : new TreeNode(rightVal,null,null);
                node.right = right;
                parentLevel.addLast(right);
                index ++ ;
            }
        }
    }


}
