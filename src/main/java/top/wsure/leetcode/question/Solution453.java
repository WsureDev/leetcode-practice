package top.wsure.leetcode.question;
//给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：3
//解释：
//只需要3次操作（注意每次操作会增加两个元素的值）：
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
//
//
// 示例 2：
//
//
//输入：nums = [1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// 答案保证符合 32-bit 整数
//
// Related Topics 数组 数学 👍 313 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution453 {

    /**
     * 给n-1个数+1，那不就是最大的数不增加么，此消彼长，直接给最大数-1就好了，最后结果就是全都减到和最小值一样大
     * 直接求最小数,求差值的和完事
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1;i<nums.length;i++){
            res += nums[i] - nums[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
* 14:41	info: 已提交,请稍等

14:41	info
			解答成功:
			执行耗时:12 ms,击败了52.43% 的Java用户
			内存消耗:39 MB,击败了23.34% 的Java用户
			*/