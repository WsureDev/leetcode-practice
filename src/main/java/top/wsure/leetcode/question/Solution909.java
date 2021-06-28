package top.wsure.leetcode.question;

//N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
//
// 例如，一块 6 x 6 大小的棋盘，编号如下：
//
//
//
//
// r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 boa
//rd[r][c]。
//
// 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
//
// 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
//
//
// 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
//
//
// 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
//
//
// 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。
//
//
// 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
//
// 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
//
//
//
// 示例：
//
// 输入：[
//[-1,-1,-1,-1,-1,-1],
//[-1,-1,-1,-1,-1,-1],
//[-1,-1,-1,-1,-1,-1],
//[-1,35,-1,-1,13,-1],
//[-1,-1,-1,-1,-1,-1],
//[-1,15,-1,-1,-1,-1]]
//输出：4
//解释：
//首先，从方格 1 [第 5 行，第 0 列] 开始。
//你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
//然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
//然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
//然后你决定移动到方格 36, 游戏结束。
//可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
//
//
//
//
// 提示：
//
//
// 2 <= board.length = board[0].length <= 20
// board[i][j] 介于 1 和 N*N 之间或者等于 -1。
// 编号为 1 的方格上没有蛇或梯子。
// 编号为 N*N 的方格上没有蛇或梯子。
//
// Related Topics 广度优先搜索 数组 矩阵
// 👍 59 👎 0


import top.wsure.leetcode.utils.InputDataFormatUtils;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int start = numToHash(n-1,0);
        deque.add(start);
        map.put(start,0);
        while (!deque.isEmpty())
        {
            int hash = deque.pollLast();
            int step = map.get(hash);
            int index = hashToIndex(hash,n);
            if(index == n*n) return step;
            for (int i=0;i<6;i++){
                int newIndex = index+i+1;
                if(newIndex <=0 || newIndex>n*n) continue;
                int newHash = indexToHash(newIndex,n);
                int toVal = getVal(board,newHash,n);
                if(toVal>0 ) {
                    newIndex = toVal;
                    newHash = indexToHash(newIndex,n);
                }
                if(!map.containsKey(newHash)){
                    map.put(newHash,step+1);
                    deque.addFirst(newHash);
                }
            }

        }
        return -1;
    }

    public int getVal(int[][] board,int hash,int n){
        return board[hashToNum(hash,true)][hashToNum(hash,false)];
    }

    public int hashToIndex(int hash, int n){
        int x = hashToNum(hash,true);
        int y = hashToNum(hash,false);
        return n * (n - x -1) + ( n % 2 == 0 ? (x % 2 == 0 ? n - y : y + 1 ) : (x % 2 == 0 ? y + 1 : n - y ) );
    }

    public int indexToHash(int index,int n){
        int x = n - ( index - 1) / n - 1;
        int t = index - n * (n - x -1);
        int y = n % 2 == 0 ? (x % 2 == 0 ? n - t : t - 1 ) : (x % 2 == 0 ? t - 1 : n - t ) ;
        return numToHash(x,y);
    }

    public int numToHash(int x,int y){
        return (x << 5) | y;
    }

    public int hashToNum(int num,boolean isX){
        return isX ? num >> 5 : num & ((1 << 5) -1);
    }

    public static void main(String[] args) {
        Solution909 solution = new Solution909();
        int [][] array =InputDataFormatUtils.stringToArray("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]");
        System.out.println(solution.snakesAndLadders(array));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 5:36 下午	info: 已提交,请稍等

 5:36 下午	info
 解答成功:
 执行耗时:14 ms,击败了16.82% 的Java用户
 内存消耗:38.4 MB,击败了82.27% 的Java用户
 */