package top.wsure.leetcode.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
//
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：[3]
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：[1]
//
//
// 示例 3：
//
//
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
// Related Topics 数组 哈希表 计数 排序 👍 411 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
public class Solution229 {
    /**
     * 可以设计哈希表，或者原地哈希，但是没必要，面试时间来不及
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        return map.keySet().stream().filter( k-> map.getOrDefault(k,0) > nums.length/3 ).collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
15:01	info: 已提交,请稍等

15:01	info
			解答成功:
			执行耗时:14 ms,击败了8.66% 的Java用户
			内存消耗:41.7 MB,击败了80.19% 的Java用户
 */