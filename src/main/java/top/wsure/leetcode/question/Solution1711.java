package top.wsure.leetcode.question;
//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
//
// 你可以搭配 任意 两道餐品做一顿大餐。
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 109 + 7 取余。
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
//
//
//
// 示例 1：
//
//
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
//
//
// 示例 2：
//
//
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
//
//
//
// 提示：
//
//
// 1 <= deliciousness.length <= 105
// 0 <= deliciousness[i] <= 220
//
// Related Topics 数组 哈希表
// 👍 50 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FileName: Solution1711
 * Author:   wsure
 * Date:     2021/7/7 8:16 下午
 * Description:
 */
public class Solution1711 {
    public int countPairs(int[] deliciousness) {
        int res = 0;
        if(deliciousness == null || deliciousness.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int k : deliciousness) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        int [] nums = map.keySet().stream().mapToInt(v->v).toArray();
        for (int i = 0;i< map.size();i++){
            int n = map.get(nums[i]);
            if(Integer.bitCount(nums[i] + nums[i]) == 1){
                res += ((n * (n - 1) )/ 2);
            }
            for (int j = i+1;j< map.size();j++){
                if(Integer.bitCount(nums[i] + nums[j]) == 1) res += (n * map.get(nums[j]));
            }
        }
        return res;
    }
}
