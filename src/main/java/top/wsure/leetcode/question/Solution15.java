package top.wsure.leetcode.question;

import top.wsure.leetcode.utils.InputDataFormatUtils;
import top.wsure.leetcode.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * FileName: Solution15
 * Author:   wsure
 * Date:     2021/6/29 3:38 下午
 * Description:三数之和
 */

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 3456 👎 0

public class Solution15 {
    /**
     * 笨比解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        Set<String> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = null;
        String key = null;
        for (int i = 0; i < nums.length; i++) {
            int twoSum = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (j + 2 < nums.length && nums[j] == nums[j + 2]) continue;
                if (map.containsKey(nums[j])) {
                    temp = Arrays.asList(nums[i], nums[j], nums[map.get(nums[j])]);
                    key = temp.stream().sorted().map(Object::toString).collect(Collectors.joining(","));
                    if (!set.contains(key)) {
                        res.add(temp);
                        set.add(key);
                    }
                } else {
                    map.put(twoSum - nums[j], j);
                }
            }
        }
        return res;
    }

    /**
     * 聪明解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int p, q;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            p = i + 1;
            q = nums.length - 1;
            while (p < q) {
                int t = nums[i] + nums[p] + nums[q];
                if (t == 0) {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    while (p < q && nums[p + 1] == nums[p]) p++;
                    while (p < q && nums[q - 1] == nums[q]) q--;
                    p++;
                    q--;
                } else if (t < 0) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String arrStr = "[1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2,1,1,-2]";
        int[] nums = InputDataFormatUtils.strArrToList(arrStr, Integer::parseInt).stream().mapToInt(v -> v).toArray();
        long t1 = System.currentTimeMillis();
        List<List<Integer>> res = new Solution15().threeSum(nums);
        System.out.println((System.currentTimeMillis() - t1));
        PrintUtils.printListListInteger(res);
    }
}
/**
 * 5:27 下午	info: 已提交,请稍等
 * <p>
 * 5:27 下午	info
 * 解答成功:
 * 执行耗时:23 ms,击败了80.92% 的Java用户
 * 内存消耗:42.2 MB,击败了81.95% 的Java用户
 */