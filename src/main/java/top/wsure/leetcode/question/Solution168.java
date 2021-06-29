package top.wsure.leetcode.question;
//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学 字符串
// 👍 378 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution168 {
    /**
     * 思路：AZ = 26*2 ， n % 26 == 0时，n == 26
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            int p = columnNumber % 26;
            res.insert(0, (char) ('A' + (p == 0 ? 25 : p - 1)));
            columnNumber /= 26;
            if (p == 0) columnNumber -= 1;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution168().convertToTitle(701));
        System.out.println(new Solution168().convertToTitle(28));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 10:57 上午	info: 已提交,请稍等
 * <p>
 * 10:57 上午	info
 * 解答成功:
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * 内存消耗:35.2 MB,击败了97.77% 的Java用户
 */