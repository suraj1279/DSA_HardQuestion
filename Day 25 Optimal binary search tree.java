//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int find(int []keys,int []freq,int [][]dp,int i,int j){
        if(i>j) return 0;
        if (dp[i][j]!=-1) return dp[i][j];

        int fs=0;
        for (int x=i;x<=j; x++){
            fs+=freq[x];
        }
        int min=Integer.MAX_VALUE;
        for (int k=i;k<=j;k++){
            int left=find(keys,freq,dp,i,k - 1);
            int right=find(keys,freq,dp,k+1,j);
            min=Math.min(min,left+right+fs);
        }

        return dp[i][j]=min;
    }
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
         int[][] dp=new int[n][n];
        for (int[] i:dp) {
            Arrays.fill(i,-1);
        }
        return find(keys,freq,dp,0,n-1);
    }
}
