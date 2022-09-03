package top.wsure.interview.written;

import java.util.LinkedList;

/*
    FileName:   SolutionIter
    Author:     wsure
    Date:       2022/8/27
    Description: 某证券公司笔试第三题
    题目大意：给你长度为N的A[] B[] ，其中表示A[i] -> B[i] 是这张有向图的一条边，这张图只有N个点和N条边，你要做的就是判断这个图是不是一个
    `能从某一点出发，经过所有点再回到起点` 的环
*/
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution20220827 {
    List<Integer>[] edges ;
    boolean[] visit ;
    boolean res = false;
    boolean[] onPath;
    public boolean solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int n = A.length;
        res = false;
        edges = new LinkedList[n];
        visit = new boolean[n];
        onPath = new boolean[n];
        for(int i=0;i<n;i++){
            edges[i] = new LinkedList<>();
        }
        for(int i=0;i<n;i++){
            int from = A[i]-1 ,to = B[i]-1;
            edges[from].add(to);
        }
        for(int i=0;i<n;i++){
            dfs(i);
            if(res)return true;
        }
        return res;
    }
    public void dfs(int s){
        if(onPath[s]){
            int count = 0;
            for(boolean b:onPath){
                if(b) count++;
            }
            if(count == onPath.length){
                res = true;
            }

        }
        if(visit[s] || res) return;

        visit[s] = true;
        onPath[s] = true;
        for(int t: edges[s]){
            dfs(t);
        }
        if(res) return;
        onPath[s] = false;
    }

    public static void main(String[] args) {
        int [] A = new int[]{ 3,1,2};
        int [] B = new int[]{ 2,3,1};
        System.out.println(new Solution20220827().solution(A,B));
    }
}
