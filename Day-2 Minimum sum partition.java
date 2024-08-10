//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java------------------------------my code -------------------------------------------------------------

class Solution
{

    public int findDiff(int n,int []arr,int i,int j,int [][]dp){
        if(n==-1){
            return Math.abs(i-j);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=Math.min(findDiff(n-1,arr,i+arr[n],j,dp),findDiff(n-1,arr,i,j+arr[n],dp));
    }
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    if(n==1) return arr[0];
	    int sum=0;
	    for(int i=0;i<n;i++){
	        sum+=arr[i];
	    }
	    int [][]dp=new int[sum+1][sum+1];
	    for(int []i:dp){
	        Arrays.fill(i,-1);
	    }
	    return findDiff(n-1,arr,0,0,dp);
	} 
}
