//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
//
//
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
//
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
//
//
// 示例 2：
//
//
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
// Related Topics 数组 哈希表 👍 63 👎 0

package top.wsure.leetcode.question;

import top.wsure.leetcode.utils.InputDataFormatUtils;

import java.util.HashMap;
import java.util.Map;

/*
    FileName:   Solution1224
    Author:     wsure
    Date:       2022/8/18
    Description:
*/
public class Solution1224 {
    public int maxEqualFreq(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0;i< nums.length;i++){
            int n = nums[i];
            int count = map.computeIfAbsent(n,v -> 0) +1;
            map.put(n,count);
            if( check(map)){
                max = i+1;
            }
        }
        return max;
    }

    // 1        1
    // 2 1      2  2:1 ,1,1
    // 1 1 2    3  1:2, 2:1 -> 2；1 ，1:1
    // 2 2 1 2  4  2:3 , 1:1
    // 2 2 3 2  4  2:3 , 3:1
    private boolean check(Map<Integer, Integer> map) {
        int keys = map.keySet().size();
        if(keys == 1) return true;
        int [][] count = new int[2][2];
        for(int i: map.values()){
            if(count[0][0] == i){
                count[0][1] += 1;
            } else if(count[1][0] == i){
                count[1][1] += 1;
            } else if(count[0][0] == 0){
                count[0][0] = i;
                count[0][1] = 1;
            } else if(count[1][0] == 0){
                count[1][0] = i;
                count[1][1] = 1;
            } else {
                return false;
            }
        }
        if(count[1][0] == 0 && count[0][0] == 1) return true;
        if(count[0][1] > count[1][1] || (count[0][1] == count[1][1] && count[1][0] > count[0][0])){
            int[] temp = count[0];
            count[0] = count[1];
            count[1] = temp;
        }
        if(count[0][1] ==1 ){
            return count[0][0] == 1 || count[0][0] - count[1][0] == 1 ;//|| (count[1][1] == 1 && count[1][0] - count[0][0] == 1);
        }

        return false;
    }


    public static void main(String[] args) {
        String arrStr = "[1,1,1,2,2,2]";
        int[] nums = InputDataFormatUtils.strArrToList(arrStr, Integer::parseInt).stream().mapToInt(v -> v).toArray();
        System.out.println(new Solution1224().maxEqualFreq(nums));
    }
}
