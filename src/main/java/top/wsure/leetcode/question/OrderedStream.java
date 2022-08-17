package top.wsure.leetcode.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    FileName:   OrderedStream
    Author:     wsure
    Date:       2022/8/16
    Description:
*/
public class OrderedStream {
    String [] items;
    int ptr;
    public OrderedStream(int n) {
        this.items = new String[n];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        items[idKey - 1]= value;
        List<String> res = new LinkedList<>();
        while (ptr <= items.length && items[ptr - 1] != null){
            res.add(items[ptr - 1]);
            ptr++;
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));// 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(1, "aaaaa")); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd")); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
}
