package top.wsure.leetcode.question;

import java.util.Arrays;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        int exist = 0;
        for (int i = 0;i<intervals.length;i++){
            if(exist == 0 ) {
                res[i] = intervals[i];
                exist ++;
            }  else {
                int[] last = res[exist - 1];
                if((intervals[i][0] >= last[0] && intervals[i][0] <= last[1]) || (last[0] >= intervals[i][0] && last[0] <= intervals[i][1])){
                    int [] merged = new int [] { Math.min(last[0],intervals[i][0]), Math.max(intervals[i][1],last[1]) };
                    res[exist - 1] = merged;
                } else {
                    res[exist] = intervals[i];
                    exist ++;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, exist);
    }
}
