package top.wsure.leetcode.question;

import top.wsure.leetcode.utils.InputDataFormatUtils;
import top.wsure.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.LinkedList;

/*
    FileName:   Solution646
    Author:     wsure
    Date:       2022/9/3
    Description:
*/
public class Solution646 {

    LinkedList<Integer> queue = new LinkedList<>();
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) return 0;
        Arrays.sort(pairs,(a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int ans = 1; int[] f = new int[pairs.length];
        for(int i =0; i<pairs.length;i++){
            f[i] = 1;
            for (int j = i -1; j >=0 && f[i] == 1;j--){
                if(pairs[j][1] < pairs[i][0]) f[i] = f[j] +1;
            }
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] pairs = InputDataFormatUtils.stringToArray("[[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]");

        System.out.println(new Solution646().findLongestChain(pairs));
        PrintUtils.printArray(pairs);
    }
}
