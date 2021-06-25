package top.wsure.leetcode.question;

import top.wsure.leetcode.utils.InputDataFormatUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FileName: Solution752
 * Author:   wsure
 * Date:     2021/6/25 10:30 上午
 * Description:打开转盘🔒
 */
//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
//
//
//
// 示例 1:
//
//
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
//
//
// 示例 2:
//
//
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
//
//
// 示例 3:
//
//
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
//
//
// 示例 4:
//
//
//输入: deadends = ["0000"], target = "8888"
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= deadends.length <= 500
// deadends[i].length == 4
// target.length == 4
// target 不在 deadends 之中
// target 和 deadends[i] 仅由若干位数字组成
//
// Related Topics 广度优先搜索 数组 哈希表 字符串
// 👍 293 👎 0


class Solution752 {
    public int openLock(String[] deadends, String target) {
        int step = 1;
        String zero = IntStream.range(0,target.length()).mapToObj(v -> "0").collect(Collectors.joining(""));
        if(target.equals(zero)) return 0;
        Set<String> deadendsSet = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> set = new HashSet<>();
        Set<String> level = new HashSet<>();
        addToSet(set,deadendsSet,preNums(target));
        while (step != -1 && !set.contains(zero)){
            level.clear();
            for (String str:set){
                addToSet(level,deadendsSet,preNums(str));
            }
            deadendsSet.addAll(level);
            set.clear();
            set.addAll(level);
            if(set.isEmpty()){
                step = -1;
            } else {
                step ++;
            }
        }
        return step;
    }

    public void addToSet(Set<String> set,Set<String> deadendsSet,String[] preName){
        for (String s:preName){
            if(!set.contains(s)&&!deadendsSet.contains(s)){
                set.add(s);
            }
        }
    }

    public String[] preNums(String target){
        String[] res = new String[target.length()*2];
        for (int i = 0;i<target.length();i++){
            res[2*i] = target.substring(0,i) + offset(target.charAt(i),1)+target.substring(i+1);
            res[2*i+1] = target.substring(0,i) + offset(target.charAt(i),-1)+target.substring(i+1);
        }
        return res;
    }


    public char offset(char c,int o){
        return (c + o) > '9' ? offset(c ,o-10) : (char) ((c + o) < '0' ? offset(c, 10+o) : c + o);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution752().preNums("99")));

        String [] deadends = InputDataFormatUtils.strArrToList("[8888]", v -> v).toArray(new String[0]);
        System.out.println(new Solution752().openLock(deadends,"0009"));
    }
}
