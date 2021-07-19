package top.wsure.leetcode.question;
//统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 👍 159 👎 0

/**
 * FileName: SolutionOffer53
 * Author:   wsure
 * Date:     2021/7/16 9:32 上午
 * Description:
 */
public class SolutionOffer53 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0, q = nums.length - 1;
        while (p < q) {
            int m = (p + q) / 2;
            if (nums[m] < target)
                p = m + 1;
            else
                q = m;
        }
        if(nums[p] == target){
            q = p;
            while (p < nums.length && nums[p] == target){
                p ++;
            }
            return p - q;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer53().search(new int[]{5,7,7,8,8,10},8));
    }
}
/**
 * //100%
 * // 73%
 */