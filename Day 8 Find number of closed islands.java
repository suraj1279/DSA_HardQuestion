//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
--------------------------------------------------------------------------My function------------------------------------------------------------------------
class Solution
{
    static void f(int i, int j, int m, int n, int[][] mat, boolean[] flag, boolean[][] vis) {
        if (i < 0 || j < 0 || i == m || j == n || mat[i][j] == 0 || vis[i][j]) {
            return;
        }
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            flag[0] = true;
        }
        vis[i][j] = true;
        f(i - 1, j, m, n, mat, flag, vis);
        f(i, j - 1, m, n, mat, flag, vis);
        f(i + 1, j, m, n, mat, flag, vis);
        f(i, j + 1, m, n, mat, flag, vis);
    }

    public int closedIslands(int[][] matrix, int N, int M) {
        int cnt = 0;
        boolean[][] vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !vis[i][j]) {
                    boolean[] flag = {false};
                    f(i, j, N, M, matrix, flag, vis);
                    if (!flag[0]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
