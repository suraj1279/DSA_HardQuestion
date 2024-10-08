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
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.ZigZagMaxLength(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
--------------------------------------------------------------------------------------------------------------My code--------------------------------
class Solution
{
    public int ZigZagMaxLength(int[] nums)
    {
        // code here
        int mn=1,mx=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                mn=mx+1;
            }
            else if(nums[i]<nums[i-1]){
                mx=mn+1;
            }
        }
        return Math.max(mx,mn);
    }
}
