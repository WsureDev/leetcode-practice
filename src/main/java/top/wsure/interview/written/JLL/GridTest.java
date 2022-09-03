package top.wsure.interview.written.JLL;

import java.util.LinkedList;

/*
    FileName:   GridTest
    Author:     wsure
    Date:       2022/8/25
    Description:
*/
public class GridTest {
    int answers;
    int[][] grid;
    int tr, tc;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    int R, C;

    LinkedList<int[]> res = new LinkedList<>();
    public LinkedList<int[]> findPath(int[] a, int[] b, int e) {
        int[][] grid = new int[100][100];
        grid[a[0]][a[1]] = 1;
        grid[b[0]][b[1]] = 2;
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int todo = 0;
        int sr = 0, sc = 0;
        for (int r = 0; r < R; ++r){
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] != -1) {
                    todo++;
                }

                if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                } else if (grid[r][c] == 2) {
                    tr = r;
                    tc = c;
                }
            }
        }


        answers = 0;
        dfs(sr, sc, todo,new LinkedList<int[]>(),e);
        return res;
    }

    public void dfs(int r, int c, int todo,LinkedList<int[]> path,int e) {
        todo--;
        if (todo < 0) return;
        if (r == tr && c == tc) {
            if (todo == 0){
                answers++ ;
                if(path.size() % e == 0){
                    res = new LinkedList<>(path);
                }
            }
            return;
        }

        path.add(new int[]{r,c});
        grid[r][c] = 3;
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] % 2 == 0)
                    dfs(nr, nc, todo,path,e);
            }
        }
        grid[r][c] = 0;
        path.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new GridTest().findPath(new int[]{2,1},new int[]{99,99},10));
    }

}
