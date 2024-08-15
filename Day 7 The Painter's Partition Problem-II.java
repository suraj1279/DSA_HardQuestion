//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
---------------------------------------------------------------------------My code------------------------------------------------------------------------

class Solution {
    static long minTime(int[] arr, int n, int k) {
        long start = Integer.MIN_VALUE;
        long end = 0;
        for (int i = 0; i < n; i++) {
            start=Math.max(start,arr[i]);
            end+=arr[i];
        }
        long res=-1;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValid(arr, n, k, mid)) {
                res=mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
    static boolean isValid(int[] arr, int n, int k, long time) {
        int painters = 1;
        long currTime = 0;

        for (int i = 0; i < n; i++) {
            currTime += arr[i];
            if (currTime > time) {
                painters++;
                currTime = arr[i];
            }
            if(painters>k){
                return false;
            }
        }

        return true;
    }
}


