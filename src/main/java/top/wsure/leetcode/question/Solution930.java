package top.wsure.leetcode.question;
//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
//
// 子数组 是数组的一段连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//
//
// 示例 2：
//
//
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// nums[i] 不是 0 就是 1
// 0 <= goal <= nums.length
//
// Related Topics 数组 哈希表 前缀和 滑动窗口
// 👍 134 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Solution930
 * Author:   wsure
 * Date:     2021/7/8 10:31 上午
 * Description:
 */
public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums == null || nums.length == 0) return 0;
        int[] numsSum = new int[nums.length +1];
        for (int i = 1;i < numsSum.length;i++){
            numsSum[i] = nums[i-1] + numsSum[i-1];
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>(){{
            put(0,1);
        }};
        int res = 0;
        for (int i = 0;i <nums.length && goal <= numsSum[i+1];i++){
            int p = numsSum[i+1], q = p - goal;
            res += map.getOrDefault(q,0);
            map.put(q,map.getOrDefault(q,0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution930().numSubarraysWithSum(new int[]{1,0,1,0,1},0));
    }
}
