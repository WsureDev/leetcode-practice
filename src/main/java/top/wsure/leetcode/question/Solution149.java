package top.wsure.leetcode.question;
//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//
//
//
// 示例 1：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// points 中的所有点 互不相同
//
// Related Topics 几何 哈希表 数学
// 👍 275 👎 0

import top.wsure.leetcode.utils.InputDataFormatUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Solution149
 * Author:   wsure
 * Date:     2021/6/24 4:43 下午
 * Description:直线上最多的点数
 */
public class Solution149 {
    public int maxPoints(int[][] points) {
        int max = 1;
        String key = null;

        for (int i = 0;i<points.length;i++){
            int pointCount = 0;
            Map<String,Integer> map = new HashMap<>();
            for (int j = i+1;j< points.length;j++){
                key = createKey(points,i,j);
                map.put(key, map.getOrDefault(key, 0) + 1);
                pointCount = Math.max(pointCount, map.get(key));
            }
            max = Math.max(max, pointCount+1);
        }
        return max;
    }

    public String createKey(int[][] points,int i ,int j){
        int y = points[i][1] - points[j][1], x = points[i][0] - points[j][0];
        int k = gcd(x,y);
        return String.format("%s %s",x/k,y/k);
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] points = InputDataFormatUtils.stringToArray("[[1,1],[2,2],[3,3]]");
        System.out.println(new Solution149().maxPoints(points));
    }
}
