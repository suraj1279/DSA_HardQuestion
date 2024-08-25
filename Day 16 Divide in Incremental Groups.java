//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
---------------------------------------------------------------------My code------------------------------------------------------------------
class Solution {
    int solve(int sum,int count,int prev,int [][][]dp){
        if(count==0 && sum==0) return 1;
        if(count==0 && sum!=0) return 0;
        if(count!=0 && sum==0) return 0;
        if(dp[sum][prev][count]!=-1){
            return dp[sum][prev][count];
        }
        int ans=0;
        for(int i=prev;i<=sum;i++){
            ans+=solve(sum-i,count-1,i,dp);
        }
        return dp[sum][prev][count]=ans;
    }
    public int countWaystoDivide(int N, int K) {
        // Code here
        int [][][]dp=new int[N+1][N+1][K+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int l = 0; l <= K; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return solve(N,K,1,dp);
    }
}
