//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        int [][]dp=new int[m][n];
        
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) dp[i][j] = (points[i][j] >= 0 ? 1 : Math.abs(points[i][j]) + 1);
                else if (i == m - 1) dp[i][j] = points[i][j] >= dp[i][j + 1] ? 1 : dp[i][j + 1] - points[i][j];
                else if (j == n - 1) dp[i][j] = points[i][j] >= dp[i + 1][j] ? 1 : dp[i + 1][j] - points[i][j];
                else {
                    int mn = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    dp[i][j] = points[i][j] >= mn ? 1 : mn - points[i][j];
                }
            }
        }
        
        return dp[0][0];
    }
}
