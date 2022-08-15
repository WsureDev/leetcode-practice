//有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
//
// 给定一个整数数组 groupSizes ，其中
// groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
//
// 返回一个组列表，使每个人 i 都在一个大小为
// groupSizes[i] 的组中。
//
// 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
//
//
//
// 示例 1：
//
//
//输入：groupSizes = [3,3,3,3,3,1,3]
//输出：[[5],[0,1,2],[3,4,6]]
//解释：
//第一组是 [5]，大小为 1，groupSizes[5] = 1。
//第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
//第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
//其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
//
//
// 示例 2：
//
//
//输入：groupSizes = [2,1,3,3,3,2]
//输出：[[1],[0,5],[2,3,4]]
//
//
//
//
// 提示：
//
//
// groupSizes.length == n
// 1 <= n <= 500
// 1 <= groupSizes[i] <= n
//
//
// Related Topics 数组 哈希表 👍 115 👎 0

package top.wsure.leetcode.question;

import top.wsure.leetcode.utils.InputDataFormatUtils;
import top.wsure.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> m = new HashMap<>();
        for (int i = 0;i < groupSizes.length;i++){
            List<Integer> l = m.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            l.add(i);
            if(groupSizes[i] == l.size()){
                res.add(l);
                m.put(groupSizes[i],new ArrayList<>());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = InputDataFormatUtils.strArrToList("[3,3,3,3,3,1,3]", Integer::parseInt).stream().mapToInt(v->v).toArray();
        List<List<Integer>> lists = new Solution1282().groupThePeople(input);
        PrintUtils.printListListInteger(lists);
    }
}
/*
> 2022/08/12 23:59:33
Success:
	Runtime:5 ms, faster than 83.84% of Java online submissions.
	Memory Usage:41.8 MB, less than 89.33% of Java online submissions.
 */