package top.wsure.leetcode.utils;

import top.wsure.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        List<ListNode> list = strArrToList(str,v->new ListNode(Integer.parseInt(v)));
        for (int i =0;i<list.size();i++){
            if(i<list.size()-1){
                list.get(i).next = list.get(i+1);
            }
        }
        return list.isEmpty() ? null : list.get(0);
    }

}
