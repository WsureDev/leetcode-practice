package top.wsure.leetcode.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1331 {
    Map<Integer,Integer> map = new HashMap<>();

    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(sortedArr);

        for (int i=0,index=1;i<sortedArr.length;i++){
            if(i == 0 || sortedArr[i] > sortedArr[i-1]) {
                index++;
                map.put(sortedArr[i],index);
            }
        }
        int [] res = new int[arr.length];
        for (int i = 0;i< arr.length;i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
